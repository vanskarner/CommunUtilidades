package vanskarner.android.communutilidades.utilities.lib.firebase.cloudmessaging;


import com.google.firebase.messaging.FirebaseMessaging;

public class CloudMsg implements ICloudMsg {

    @Override
    public void subscribeToTopic(String topic, OnResultListener listener) {
        FirebaseMessaging.getInstance()
                .subscribeToTopic(topic).addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                listener.onSuccess();
            } else {
                listener.onFail();
            }
        });
    }

    @Override
    public void unsubscribeFromTopic(String topic, OnResultListener listener) {
        FirebaseMessaging.getInstance()
                .unsubscribeFromTopic(topic).addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                listener.onSuccess();
            } else {
                listener.onFail();
            }
        });
    }
}
