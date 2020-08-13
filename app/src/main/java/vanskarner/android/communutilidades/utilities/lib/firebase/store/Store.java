package vanskarner.android.communutilidades.utilities.lib.firebase.store;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class Store implements IStore {

    private String collection;

    public Store(String collection) {
        this.collection = collection;
    }

    @Override
    public void getDataOrderByDes(String fieldOrderBy, int limitElements, OnDataListener listener) {
        FirebaseFirestore.getInstance()
                .collection(collection)
                .orderBy(fieldOrderBy, Query.Direction.DESCENDING).limit(limitElements)
                .get().addOnCompleteListener(task -> {
            if (task.isSuccessful() && task.getResult() != null && task.getResult().size() > 0) {
                listener.onSuccess(task.getResult());
            } else {
                listener.onFail();
            }
        });
    }

    @Override
    public void getDataOrderByAsc(String fieldOrderBy, int limitElements, OnDataListener listener) {
        FirebaseFirestore.getInstance()
                .collection(collection)
                .orderBy(fieldOrderBy, Query.Direction.ASCENDING).limit(limitElements)
                .get().addOnCompleteListener(task -> {
            if (task.isSuccessful() && task.getResult() != null && task.getResult().size() > 0) {
                listener.onSuccess(task.getResult());
            } else {
                listener.onFail();
            }
        });
    }

}
