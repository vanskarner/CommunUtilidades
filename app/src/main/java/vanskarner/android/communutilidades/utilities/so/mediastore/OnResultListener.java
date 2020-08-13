package vanskarner.android.communutilidades.utilities.so.mediastore;

public interface OnResultListener<T> {
    void onSuccess(T object);

    void onOperationCancelled();
}
