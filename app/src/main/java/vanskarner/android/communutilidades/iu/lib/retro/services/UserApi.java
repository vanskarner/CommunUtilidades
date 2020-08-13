package vanskarner.android.communutilidades.iu.lib.retro.services;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import vanskarner.android.communutilidades.BuildConfig;
import vanskarner.android.communutilidades.iu.lib.retro.model.UserRequest;
import vanskarner.android.communutilidades.iu.lib.retro.model.UserResponse;


public interface UserApi {
    String Authorization= BuildConfig.AUTHORIZATION;

//  @Headers({"Authorization: "+Authorization})
    @GET("/posts/1")
    Call<UserResponse> posts_GET();

//  @Headers({"Content-Type: application/json", "Authorization: "+Authorization})
    @Headers({"Content-Type: application/json"})
    @POST("/posts")
    Call<UserResponse> posts_POST(@Body UserRequest userRequestReq);

//  @Headers({"Content-Type: application/json", "Authorization: "+Authorization})
    @Headers({"Content-Type: application/json"})
    @PUT("/posts/1")
    Call<UserResponse> posts_PUT(@Body UserRequest userRequestReq);

    @DELETE("/posts/1")
    Call<UserResponse> posts_DELETE();
}
