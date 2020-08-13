package vanskarner.android.communutilidades.utilities.lib.firebase.authentication;

public interface OnSessionListener<T> {

    void onSuccess(T t);

    void onFail();

}
