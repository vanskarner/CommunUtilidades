package vanskarner.android.communutilidades.iu.lib.retro.services;


import vanskarner.android.communutilidades.BuildConfig;
import vanskarner.android.communutilidades.iu.lib.retro.model.UserRequest;
import vanskarner.android.communutilidades.iu.lib.retro.model.UserResponse;
import vanskarner.android.communutilidades.utilities.lib.retrofit.IRetro;
import vanskarner.android.communutilidades.utilities.lib.retrofit.Retro;

public class UserService {
    private static String BASE_URL = BuildConfig.URL_BASE;
    private static IRetro iRetro=new Retro(30,30,false,BASE_URL);
    private static UserApi userApi=iRetro.createService(UserApi.class) ;

    public void posts_GET(OnCompleteListener<UserResponse> listener) {
        userApi.posts_GET().enqueue(UserCallback.defaultCallBack(listener));
    }

    public void posts_POST(UserRequest userRequest, OnCompleteListener<UserResponse> listener) {
        userApi.posts_POST(userRequest).enqueue(UserCallback.defaultCallBack(listener));
    }

    public void posts_PUT(UserRequest userRequest, OnCompleteListener<UserResponse> listener) {
        userApi.posts_PUT(userRequest).enqueue(UserCallback.defaultCallBack(listener));
    }

    public void posts_DELETE(OnCompleteListener<UserResponse> listener) {
        userApi.posts_DELETE().enqueue(UserCallback.defaultCallBack(listener));
    }

}
