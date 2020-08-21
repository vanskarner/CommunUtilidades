package vanskarner.android.communutilidades.iu.lib.retro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import vanskarner.android.communutilidades.R;
import vanskarner.android.communutilidades.iu.lib.retro.company1.ServicesCallback;
import vanskarner.android.communutilidades.iu.lib.retro.company1.callback.OnCallbackListener;
import vanskarner.android.communutilidades.iu.lib.retro.company1.model.User;


public class RetrofitActivity extends AppCompatActivity implements View.OnClickListener {

    private ServicesCallback servicesCallback=new ServicesCallback();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGet = findViewById(R.id.btnGet);
        Button btnPost = findViewById(R.id.btnPost);
        Button btnPut = findViewById(R.id.btnPut);
        Button btnDelete = findViewById(R.id.btnDelete);

        btnGet.setOnClickListener(this);
        btnPost.setOnClickListener(this);
        btnPut.setOnClickListener(this);
        btnDelete.setOnClickListener(this);

    }

    public void setInfo(User userRes) {
        TextView tvId = findViewById(R.id.tvId);
        TextView tvUserId = findViewById(R.id.tvUserId);
        TextView tvBody = findViewById(R.id.tvBody);
        TextView tvTitle = findViewById(R.id.tvTitle);

        String id = String.format(getString(R.string.api_id), String.valueOf(userRes.getId()));
        String userId = String.format(getString(R.string.api_user_id), String.valueOf(userRes.getUserId()));
        String body = String.format(getString(R.string.api_body), String.valueOf(userRes.getBody()));
        String title = String.format(getString(R.string.api_title), String.valueOf(userRes.getTitle()));

        tvId.setText(id);
        tvUserId.setText(userId);
        tvBody.setText(body);
        tvTitle.setText(title);
    }

    public void setInfoDelete() {
        TextView tvId = findViewById(R.id.tvId);
        TextView tvUserId = findViewById(R.id.tvUserId);
        TextView tvBody = findViewById(R.id.tvBody);
        TextView tvTitle = findViewById(R.id.tvTitle);

        String id = String.format(getString(R.string.api_id), "");
        String userId = String.format(getString(R.string.api_user_id), "");
        String body = String.format(getString(R.string.api_body), "");
        String title = String.format(getString(R.string.api_title), "");

        tvId.setText(id);
        tvUserId.setText(userId);
        tvBody.setText(body);
        tvTitle.setText(title);
    }

    public void showProgressBar(){
        ProgressBar progressBar=findViewById(R.id.progressBar);
        progressBar.setIndeterminate(true);
    }
    public void hideProgressBar(){
        ProgressBar progressBar=findViewById(R.id.progressBar);
        progressBar.setIndeterminate(false);
    }

    @Override
    public void onClick(View v) {
        showProgressBar();
        setInfoDelete();
        switch (v.getId()) {
            case R.id.btnGet:
                servicesCallback.userCallback().posts_GET(new OnCallbackListener<User>() {
                    @Override
                    public void onSuccess(User object) {
                        setInfo(object);
                        hideProgressBar();
                    }

                    @Override
                    public void onFail(String message) {
                        Toast.makeText(RetrofitActivity.this, message, Toast.LENGTH_SHORT).show();
                        hideProgressBar();
                    }
                });
                break;
            case R.id.btnPost:
                User userReq=new User();
                userReq.setUserId(1);
                userReq.setBody("bar");
                userReq.setTitle("foo");
                servicesCallback.userCallback().posts_POST(userReq, new OnCallbackListener<User>() {
                    @Override
                    public void onSuccess(User object) {
                        setInfo(object);
                        hideProgressBar();
                    }

                    @Override
                    public void onFail(String message) {
                        Toast.makeText(RetrofitActivity.this, message, Toast.LENGTH_SHORT).show();
                        hideProgressBar();
                    }
                });

                break;
            case R.id.btnPut:
                User userReq2=new User();
                userReq2.setId(1);
                userReq2.setUserId(1);
                userReq2.setBody("bar");
                userReq2.setTitle("foo");
                servicesCallback.userCallback().posts_PUT(userReq2, new OnCallbackListener<User>() {
                    @Override
                    public void onSuccess(User object) {
                        setInfo(object);
                        hideProgressBar();
                    }

                    @Override
                    public void onFail(String message) {
                        Toast.makeText(RetrofitActivity.this, message, Toast.LENGTH_SHORT).show();
                        hideProgressBar();
                    }
                });
                break;
            case R.id.btnDelete:
                servicesCallback.userCallback().posts_DELETE(new OnCallbackListener<User>() {
                    @Override
                    public void onSuccess(User object) {
                        Toast.makeText(RetrofitActivity.this, "DELETE", Toast.LENGTH_SHORT).show();
                        hideProgressBar();
                    }

                    @Override
                    public void onFail(String message) {
                        Toast.makeText(RetrofitActivity.this, message, Toast.LENGTH_SHORT).show();
                        hideProgressBar();
                    }
                });
                break;
        }
    }
}
