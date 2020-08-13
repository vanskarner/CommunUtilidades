package vanskarner.android.communutilidades.utilities.lib.firebase.store;

import com.google.firebase.firestore.QuerySnapshot;

public interface OnDataListener {

    void onSuccess(QuerySnapshot queryDocumentSnapshots);

    void onFail();

}
