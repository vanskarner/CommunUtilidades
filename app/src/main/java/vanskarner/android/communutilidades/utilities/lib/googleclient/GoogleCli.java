package vanskarner.android.communutilidades.utilities.lib.googleclient;

import android.content.Context;
import android.content.Intent;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;


public class GoogleCli implements IGoogleCli {

    private Context context;
    private GoogleSignInOptions googleSignInOptions;

    public GoogleCli(Context context, String clientID) {
        this.context = context;
        googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(clientID)
                .requestEmail().build();
    }

    @Override
    public Intent getSignInIntent() {
        GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(context, googleSignInOptions);
        return googleSignInClient.getSignInIntent();
    }


    @Override
    public void signIn(Intent intent, OnSessionListener listener) {
        Task<GoogleSignInAccount> googleSignInAccountTask = GoogleSignIn.getSignedInAccountFromIntent(intent);
        googleSignInAccountTask.addOnCompleteListener(task -> {
            GoogleSignInAccount signInAccount;
            try {
                signInAccount = task.getResult(ApiException.class);
                if (signInAccount != null) {
                    listener.onSuccess(signInAccount);
                } else {
                    listener.onFail();
                }
            } catch (Exception e) {
                listener.onFail();
            }
        });
    }

    @Override
    public void signOff() {
        GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(context, googleSignInOptions);
        googleSignInClient.signOut();
    }

}
