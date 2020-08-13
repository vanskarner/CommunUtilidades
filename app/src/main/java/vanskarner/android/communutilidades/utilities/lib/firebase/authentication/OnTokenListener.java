package vanskarner.android.communutilidades.utilities.lib.firebase.authentication;

public interface OnTokenListener {

    void onSuccess(String token);

    void onFailUserDisabled();

    void onFailNetwork();

    void onFail();

    void onSessionNotStarted();

}
