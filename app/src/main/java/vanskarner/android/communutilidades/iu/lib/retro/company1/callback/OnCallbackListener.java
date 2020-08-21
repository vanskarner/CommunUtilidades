package vanskarner.android.communutilidades.iu.lib.retro.company1.callback;


//General listener for all services
public interface OnCallbackListener<T> {

    void onSuccess(T object);

    void onFail(String message);
}