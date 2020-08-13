package vanskarner.android.communutilidades.utilities.lib.firebase.cloudmessaging;

public interface ICloudMsg {

    void subscribeToTopic(String topic, OnResultListener listener);

    void unsubscribeFromTopic(String topic, OnResultListener listener);

}
