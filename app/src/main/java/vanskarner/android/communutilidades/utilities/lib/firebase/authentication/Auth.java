package vanskarner.android.communutilidades.utilities.lib.firebase.authentication;


import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.GoogleAuthProvider;

public class Auth implements IAuth {
    private static final String USER_DISABLED = "ERROR_USER_DISABLED";

    @Override
    public void checkFirebaseUser(OnSessionListener<FirebaseUser> listener) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null) {
            listener.onSuccess(firebaseUser);
        } else {
            listener.onFail();
        }
    }

    @Override
    public void getTokenUser(OnTokenListener listener) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null) {
            firebaseUser.getIdToken(true).addOnCompleteListener(task -> {
                if (task.isSuccessful() && task.getResult() != null) {
                    GetTokenResult getTokenResult = task.getResult();
                    String token = getTokenResult.getToken();
                    listener.onSuccess(token);
                } else {
                    if (task.getException() != null && task.getException().getMessage() != null &&
                            task.getException().getMessage().contains(USER_DISABLED)) {
                        listener.onFailUserDisabled();
                    }
                    if (task.getException() != null &&
                            task.getException() instanceof FirebaseNetworkException) {
                        listener.onFailNetwork();
                    } else {
                        listener.onFail();
                    }
                }
            });
        } else {
            listener.onSessionNotStarted();
        }
    }

    @Override
    public void signInWithGoogle(String tokenGoogle, OnSessionListener<AuthResult> listener) {
        AuthCredential credential = GoogleAuthProvider.getCredential(tokenGoogle, null);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                listener.onSuccess(task.getResult());
            } else {
                listener.onFail();
            }
        });
    }
}
