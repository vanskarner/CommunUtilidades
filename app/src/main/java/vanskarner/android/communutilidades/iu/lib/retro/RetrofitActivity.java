package vanskarner.android.communutilidades.iu.lib.retro;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import vanskarner.android.communutilidades.iu.lib.retro.model.UserRequest;
import vanskarner.android.communutilidades.iu.lib.retro.model.UserResponse;
import vanskarner.android.communutilidades.iu.lib.retro.services.OnCompleteListener;
import vanskarner.android.communutilidades.iu.lib.retro.services.UserService;

public class RetrofitActivity extends AppCompatActivity {

    private UserService userService=new UserService();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //String token, int userId, int id, String title, String body
        UserRequest userRequest=new UserRequest("Token",12,12,"Titulo X","Contenido");
        userService.posts_POST(userRequest, new OnCompleteListener<UserResponse>() {
            @Override
            public void onSuccess(UserResponse object) {

            }

            @Override
            public void onFail(String message) {

            }
        });
    }
}
