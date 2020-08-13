package vanskarner.android.communutilidades.utilities.lib.googleclient;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public interface OnSessionListener {

    void onSuccess(GoogleSignInAccount account);

    void onFail();
}
