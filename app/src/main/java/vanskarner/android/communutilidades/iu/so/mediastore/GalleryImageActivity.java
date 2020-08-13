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
import vanskarner.android.communutilidades.utilities.so.mediastore.OnResultListener;
import vanskarner.android.communutilidades.utilities.so.mediastore.UtilityMediaStore;

public class GalleryImageActivity extends AppCompatActivity {

    private ImageView imageView;
    private ImageButton imageButton;
    private Button btnBack;
    private IUtilityMediaStore utilityMediaStore;
    private static final int REQUEST_CODE_IMAGE_GALLERY = 333;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_image_activity);
        utilityMediaStore = new UtilityMediaStore();

        imageView = findViewById(R.id.imageView);
        imageButton = findViewById(R.id.imageButton);
        btnBack = findViewById(R.id.btnBack);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utilityMediaStore.accessImageGallery(GalleryImageActivity.this, REQUEST_CODE_IMAGE_GALLERY);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GalleryImageActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        utilityMediaStore.getGalleryImage(this, requestCode, REQUEST_CODE_IMAGE_GALLERY, resultCode, RESULT_OK, data, new OnResultListener<Bitmap>() {
            @Override
            public void onSuccess(Bitmap object) {
                imageView.setImageBitmap(object);
            }

            @Override
            public void onOperationCancelled() {
                Toast.makeText(GalleryImageActivity.this, "Operación cancelada", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
