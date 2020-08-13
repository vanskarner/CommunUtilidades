package vanskarner.android.communutilidades.utilities.so.mediastore;

import android.Manifest;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UtilityMediaStore implements IUtilityMediaStore {

    @Override
    public void accessMultipleImageGallery(AppCompatActivity appCompatActivity, int requestCodeMultipleImageGallery) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        }
        appCompatActivity.startActivityForResult(Intent.createChooser(intent, "Select Picture"), requestCodeMultipleImageGallery);
    }

    @Override
    public void getGalleryImageMultiple(Context context, int requestCode, int compareRequestCode, int resultCode, int compareResultCode, Intent data, OnResultListener<List<Bitmap>> listener) {
        if (requestCode == compareRequestCode && resultCode == compareResultCode && data != null) {
            List<Bitmap> imagesList = new ArrayList<>();
            try {
                ClipData clipData = data.getClipData();
                ContentResolver contentResolver = context.getContentResolver();
                if (clipData == null) {
                    Uri imageUri = data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri);
                    imagesList.add(bitmap);
                } else {
                    for (int i = 0; i < clipData.getItemCount(); i++) {
                        ClipData.Item item = clipData.getItemAt(i);
                        Uri uri = item.getUri();
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri);
                        imagesList.add(bitmap);
                    }
                }
                listener.onSuccess(imagesList);

            } catch (IOException e) {
                e.printStackTrace();
                listener.onOperationCancelled();
            }
        } else {
            listener.onOperationCancelled();
        }
    }

    @Override
    public void getGalleryImageMultiple_Resized(Context context, int requestCode, int compareRequestCode, int resultCode, int compareResultCode, Intent data, int dstWidth, int dstHeight, boolean filter, OnResultListener<List<Bitmap>> listener) {
        if (requestCode == compareRequestCode && resultCode == compareResultCode && data != null) {
            List<Bitmap> imagesList = new ArrayList<>();
            try {
                ClipData clipData = data.getClipData();
                ContentResolver contentResolver = context.getContentResolver();
                if (clipData == null) {
                    Uri imageUri = data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri);
                    Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, dstWidth, dstHeight, filter);
                    imagesList.add(resizedBitmap);
                } else {
                    for (int i = 0; i < clipData.getItemCount(); i++) {
                        ClipData.Item item = clipData.getItemAt(i);
                        Uri uri = item.getUri();
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri);
                        Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, dstWidth, dstHeight, filter);
                        imagesList.add(resizedBitmap);
                    }
                }
                listener.onSuccess(imagesList);

            } catch (IOException e) {
                e.printStackTrace();
                listener.onOperationCancelled();
            }
        } else {
            listener.onOperationCancelled();
        }
    }

    @Override
    public void accessImageGallery(AppCompatActivity appCompatActivity, int requestCodeImageGallery) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        appCompatActivity.startActivityForResult(intent, requestCodeImageGallery);
    }

    @Override
    public void getGalleryImage(Context context, int requestCode, int compareRequestCode, int resultCode, int compareResultCode, Intent data, OnResultListener<Bitmap> listener) {
        if (requestCode == compareRequestCode && resultCode == compareResultCode && data != null) {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                Uri imageUri = data.getData();
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri);
                listener.onSuccess(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
                listener.onOperationCancelled();
            }
        } else {
            listener.onOperationCancelled();
        }
    }

    @Override
    public void getGalleryImage_Resized(Context context, int requestCode, int compareRequestCode, int resultCode, int compareResultCode, Intent data, int dstWidth, int dstHeight, boolean filter, OnResultListener<Bitmap> listener) {
        if (requestCode == compareRequestCode && resultCode == compareResultCode && data != null) {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                Uri imageUri = data.getData();
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri);
                Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, dstWidth, dstHeight, filter);
                listener.onSuccess(resizedBitmap);
            } catch (IOException e) {
                e.printStackTrace();
                listener.onOperationCancelled();
            }
        } else {
            listener.onOperationCancelled();
        }
    }

    @Override
    public void requestCameraPermission(AppCompatActivity appCompatActivity, int requestCodePermission) {
        //used for api>23
        if (ActivityCompat.checkSelfPermission(appCompatActivity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(appCompatActivity, new String[]{Manifest.permission.CAMERA}, requestCodePermission);
        }
    }

    @Override
    public void accessCamera(AppCompatActivity appCompatActivity, int requestCodeCamera, OnCameraListener listener) {
        if (ActivityCompat.checkSelfPermission(appCompatActivity, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            PackageManager packageManager = appCompatActivity.getPackageManager();
            if (takePictureIntent.resolveActivity(packageManager) != null) {
                appCompatActivity.startActivityForResult(takePictureIntent, requestCodeCamera);
                listener.onSuccess();
            } else {
                listener.onPermissionDenied();
            }
        } else {
            listener.onPermissionDenied();
        }
    }

    @Override
    public void getCameraImage(int requestCode, int compareRequestCode, int resultCode, int compareResultCode, Intent data, OnResultListener<Bitmap> listener) {
        if (requestCode == compareRequestCode && resultCode == compareResultCode && data != null) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                listener.onSuccess(imageBitmap);
            } else {
                listener.onOperationCancelled();
            }
        } else {
            listener.onOperationCancelled();
        }
    }

    private String bitmapToBase64(Bitmap bm, int quality) {
        //quality for example= 100
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, quality, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(byteArray, Base64.NO_WRAP);
    }

    private Bitmap base64StringToBitmap(String base64){
        //to be displayed it must not have as a header as "data: image / jpg; base64", only bytes
        byte[] imageBytes = Base64.decode(base64, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
    }

    private String bitmapToBase64WithHeader(Bitmap bm, int quality) {
        //quality for example= 100
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, quality, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String contentBase64 = Base64.encodeToString(byteArray, Base64.NO_WRAP);
        return "data:image/jpeg;base64," + contentBase64;
    }

}
