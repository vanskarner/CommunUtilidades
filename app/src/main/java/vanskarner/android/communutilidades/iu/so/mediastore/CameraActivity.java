package vanskarner.android.communutilidades.iu.so.mediastore;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import vanskarner.android.communutilidades.MainActivity;
import vanskarner.android.communutilidades.R;
import vanskarner.android.communutilidades.utilities.so.mediastore.IUtilityMediaStore;
import vanskarner.android.communutilidades.utilities.so.mediastore.OnCameraListener;
import vanskarner.android.communutilidades.utilities.so.mediastore.OnResultListener;
import vanskarner.android.communutilidades.utilities.so.mediastore.UtilityMediaStore;


public class CameraActivity extends AppCompatActivity {

    private ImageView imageView;
    private ImageButton imageButton;
    private Button btnBack;
    private IUtilityMediaStore utilityMediaStore;

    private static final int REQUEST_CODE_PERMISSION=1000;
    private static final int REQUEST_CODE_CAMERA=333;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_activity);
        utilityMediaStore=new UtilityMediaStore();
        utilityMediaStore.requestCameraPermission(this,REQUEST_CODE_PERMISSION);

        imageView=findViewById(R.id.imageView);
        imageButton=findViewById(R.id.imageButton);
        btnBack = findViewById(R.id.btnBack);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utilityMediaStore.accessCamera(CameraActivity.this, REQUEST_CODE_CAMERA, new OnCameraListener() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onPermissionDenied() {
                        Toast.makeText(CameraActivity.this, "No se puede acceder a la cámara, revisar permisos...", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CameraActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        utilityMediaStore.getCameraImage(requestCode, REQUEST_CODE_CAMERA, resultCode, RESULT_OK, data, new OnResultListener<Bitmap>() {
            @Override
            public void onSuccess(Bitmap object) {
                imageView.setImageBitmap(object);
            }

            @Override
            public void onOperationCancelled() {
                Toast.makeText(CameraActivity.this, "Operación cancelada", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
