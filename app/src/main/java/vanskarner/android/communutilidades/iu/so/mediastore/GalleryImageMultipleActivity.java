package vanskarner.android.communutilidades.iu.so.mediastore;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vanskarner.android.communutilidades.MainActivity;
import vanskarner.android.communutilidades.R;
import vanskarner.android.communutilidades.utilities.so.mediastore.IUtilityMediaStore;
import vanskarner.android.communutilidades.utilities.so.mediastore.OnResultListener;
import vanskarner.android.communutilidades.utilities.so.mediastore.UtilityMediaStore;


public class GalleryImageMultipleActivity extends AppCompatActivity {

    private TextView txtPhotos, txtDescription, txtRestrictionInfo;
    private List<Bitmap> imageList = new ArrayList<>();
    private AdapterPhotos adapterPhotos = AdapterPhotos.createInstance(imageList);
    private RecyclerView rcvMultipleImage;
    private IUtilityMediaStore utilityMediaStore = new UtilityMediaStore();
    private static final int REQUEST_CODE_IMAGE_GALLERY = 333;
    private static final int COUNT_MAX_IMAGES = 6;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_image_multiple_activity);
        LinearLayout rlAddImage = findViewById(R.id.lyAddImage);
        txtPhotos = findViewById(R.id.txtPhotos);
        txtDescription = findViewById(R.id.txtDescription);
        txtRestrictionInfo = findViewById(R.id.txtRestrictionInfo);
        ImageButton imbtnDeletePhotos = findViewById(R.id.imbtnDeletePhotos);
        rcvMultipleImage = findViewById(R.id.rcvMultipleImage);
        Button btnMenu = findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GalleryImageMultipleActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        rcvMultipleImage.setAdapter(adapterPhotos);
        rlAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utilityMediaStore.accessMultipleImageGallery(GalleryImageMultipleActivity.this, REQUEST_CODE_IMAGE_GALLERY);
            }
        });
        adapterPhotos.setListener(new AdapterPhotos.OnClickListener() {
            @Override
            public void onClickItem() {
                utilityMediaStore.accessMultipleImageGallery(GalleryImageMultipleActivity.this, REQUEST_CODE_IMAGE_GALLERY);
            }
        });

        imbtnDeletePhotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtPhotos.setText("Fotos");
                imageList.clear();
                adapterPhotos.deleteImages();
                txtDescription.setVisibility(View.VISIBLE);
                rcvMultipleImage.setVisibility(View.GONE);
                txtRestrictionInfo.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        utilityMediaStore.getGalleryImageMultiple(this, requestCode, REQUEST_CODE_IMAGE_GALLERY, resultCode, RESULT_OK, data, new OnResultListener<List<Bitmap>>() {
            @Override
            public void onSuccess(List<Bitmap> object) {
                if ((object.size()+imageList.size())<= COUNT_MAX_IMAGES) {
                    txtDescription.setVisibility(View.GONE);
                    rcvMultipleImage.setVisibility(View.VISIBLE);
                    txtRestrictionInfo.setVisibility(View.VISIBLE);
                    imageList.addAll(object);
                    adapterPhotos.updateList(imageList);
                    txtPhotos.setText("Fotos(" + imageList.size() + ")");
                    txtRestrictionInfo.setText("Solo puedes subir " + COUNT_MAX_IMAGES + " imágenes como máximo.");
                }else {
                    Toast.makeText(GalleryImageMultipleActivity.this, "Máximo "+COUNT_MAX_IMAGES+" imágenes!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onOperationCancelled() {
                Toast.makeText(GalleryImageMultipleActivity.this, "Operacion Cancelada", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
