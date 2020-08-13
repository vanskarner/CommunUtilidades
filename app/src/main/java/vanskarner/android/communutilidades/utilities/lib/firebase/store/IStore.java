package vanskarner.android.communutilidades.utilities.lib.firebase.store;

public interface IStore {

    void getDataOrderByDes(String fieldOrderBy, int limitElements, OnDataListener listener);

    void getDataOrderByAsc(String fieldOrderBy, int limitElements, OnDataListener listener);

}
