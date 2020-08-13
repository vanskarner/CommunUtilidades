package vanskarner.android.communutilidades.utilities.so.preference;

public interface OnPreference<T> {
    void exists(T value);

    void notExist();
}
