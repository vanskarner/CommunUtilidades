package vanskarner.android.communutilidades.utilities.so.mediastore;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public interface IUtilityMediaStore {

    void accessMultipleImageGallery(AppCompatActivity appCompatActivity, int requestCodeMultipleImageGallery);

    void getGalleryImageMultiple(Context context, int requestCode, int compareRequestCode, int resultCode, int compareResultCode, Intent data, OnResultListener<List<Bitmap>> listener);

    void getGalleryImageMultiple_Resized(Context context, int requestCode, int compareRequestCode, int resultCode, int compareResultCode, Intent data, int dstWidth, int dstHeight, boolean filter, OnResultListener<List<Bitmap>> listener);

    void accessImageGallery(AppCompatActivity appCompatActivity, int requestCodeImageGallery);

    void getGalleryImage(Context context, int requestCode, int compareRequestCode, int resultCode, int compareResultCode, Intent data, OnResultListener<Bitmap> listener);

    void getGalleryImage_Resized(Context context, int requestCode, int compareRequestCode, int resultCode, int compareResultCode, Intent data, int dstWidth, int dstHeight, boolean filter, OnResultListener<Bitmap> listener);

    void requestCameraPermission(AppCompatActivity appCompatActivity, int requestCodePermission);

    void accessCamera(AppCompatActivity appCompatActivity, int requestCodeCamera, OnCameraListener listener);

    void getCameraImage(int requestCode, int compareRequestCode, int resultCode, int compareResultCode, Intent data, OnResultListener<Bitmap> listener);

}
