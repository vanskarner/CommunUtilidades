package vanskarner.android.communutilidades.iu.lib.retro.company1.callback;

import vanskarner.android.communutilidades.iu.lib.retro.company1.model.User;
import vanskarner.android.communutilidades.iu.lib.retro.company1.services.UserApi;


public class UserCallback extends ConfigCallback<User, UserApi> {

    @Override
    protected Class<UserApi> interfaceToClass() {
        return UserApi.class;
    }

    public void posts_GET(OnCallbackListener<User> listener) {
        service().posts_GET().enqueue(createCallback(listener));
    }

    public void posts_POST(User user, OnCallbackListener<User> listener) {
        //Example without header
        service().posts_POST(user).enqueue(createCallback(listener));

        //Example with header
        /*List<HeaderHttp> headersList=new ArrayList<>();
        headersList.add(new HeaderHttp("Content-Type","application/json"));
        headersList.add(new HeaderHttp("Authorization","jmFbcxibSDL3czTQQ0ULr5yoq5wFP6IrgLYxBcwuFGl"));
        serviceWithHeader(headersList).posts_POST(user).enqueue(createCallback(listener));*/
    }

    public void posts_PUT(User user, OnCallbackListener<User> listener) {
        service().posts_PUT(user).enqueue(createCallback(listener));
    }

    public void posts_DELETE(OnCallbackListener<User> listener) {
        service().posts_DELETE().enqueue(createCallback(listener));
    }


}
