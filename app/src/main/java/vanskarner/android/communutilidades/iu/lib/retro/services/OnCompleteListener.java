package vanskarner.android.communutilidades.iu.lib.retro.services;


//General listener for all services
public interface OnCompleteListener<T> {

    void onSuccess(T object);

    void onFail(String message);
}