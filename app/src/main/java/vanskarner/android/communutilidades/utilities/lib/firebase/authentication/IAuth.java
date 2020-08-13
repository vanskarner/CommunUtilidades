package vanskarner.android.communutilidades.utilities.lib.firebase.authentication;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

public interface IAuth {

    void checkFirebaseUser(OnSessionListener<FirebaseUser> listener);

    void getTokenUser(OnTokenListener listener);

    void signInWithGoogle(String tokenGoogle, OnSessionListener<AuthResult> listener);

}
