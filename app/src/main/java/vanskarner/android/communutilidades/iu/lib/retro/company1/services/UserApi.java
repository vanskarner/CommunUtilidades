package vanskarner.android.communutilidades.iu.lib.retro.company1.services;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import vanskarner.android.communutilidades.BuildConfig;
import vanskarner.android.communutilidades.iu.lib.retro.company1.model.User;


public interface UserApi {
    String Authorization= BuildConfig.AUTHORIZATION;

//  @HeaderHttp({"Authorization: "+Authorization})
    @GET("/posts/1")
    Call<User> posts_GET();

  /*@HeaderHttp({"Content-Type: application/json", "Authorization: "+Authorization})*/
    /*@HeaderHttp({"Content-Type: application/json"})*/
    @POST("/posts")
    Call<User> posts_POST(@Body User userReq);

//  @HeaderHttp({"Content-Type: application/json", "Authorization: "+Authorization})
    @Headers({"Content-Type: application/json"})
    @PUT("/posts/1")
    Call<User> posts_PUT(@Body User userReq);

    @DELETE("/posts/1")
    Call<User> posts_DELETE();
}
