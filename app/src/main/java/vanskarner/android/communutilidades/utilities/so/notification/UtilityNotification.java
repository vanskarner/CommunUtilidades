package vanskarner.android.communutilidades.utilities.so.notification;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import javax.annotation.Nullable;


public class UtilityNotification implements IUtilityNotification{
    private Context context;
    private NotificationObject notificationObject;

    public UtilityNotification(Context context, NotificationObject notificationObject) {
        this.context = context;
        this.notificationObject = notificationObject;
    }

    private PendingIntent createPendingIntent() {
        return PendingIntent.getActivity(context, notificationObject.getREQUESTCODE_PENDINGINTENT(), notificationObject.getIntent(), PendingIntent.FLAG_ONE_SHOT);
    }

    private NotificationCompat.Builder createNotifBasic() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, notificationObject.getID_CHANNEL());
        builder.setSmallIcon(notificationObject.getSmallIcon());
        builder.setColor(context.getResources().getColor(notificationObject.getColorSmallIcon()));
        builder.setContentTitle(notificationObject.getTitle());
        builder.setContentText(notificationObject.getDescription());
        builder.setSubText(notificationObject.getSubText());
        builder.setTicker(notificationObject.getTicker());//Para versiones Android menor a 5.0
        builder.setWhen(System.currentTimeMillis());
        builder.setPriority(notificationObject.getPRIORITY());
        builder.setCategory(notificationObject.getCATEGORY());
        builder.setContentIntent(createPendingIntent());
        builder.setAutoCancel(true);
        Uri soundUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + context.getPackageName() + "/" + notificationObject.getSound());
        builder.setSound(soundUri);
        return builder;
    }

    private NotificationCompat.Builder createNotifLargeIcon(Bitmap resource) {
        NotificationCompat.Builder builder = createNotifBasic();
        builder.setLargeIcon(resource);
        return builder;
    }

    private NotificationCompat.Builder createNotifBigPicture(Bitmap resource) {
        NotificationCompat.Builder builder = createNotifBasic();
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(resource));
        return builder;
    }

    private void filterNotificationByVersionAndroid(Notification notification) {
        NotificationManagerCompat notifyManager = NotificationManagerCompat.from(context);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(notificationObject.getID_CHANNEL(), notificationObject.getNAME_CHANNEL(), notificationObject.getIMPORTANCE());
            mChannel.setDescription(notificationObject.getDESCRIPTION_CHANNEL());
            mChannel.enableVibration(notificationObject.isVibrationNotif());//*
            notifyManager.createNotificationChannel(mChannel);
            notifyManager.notify(notificationObject.getIdNotification(), notification);
        } else {
            notifyManager.notify(notificationObject.getIdNotification(), notification);
        }
    }

    @Override
    public void showNotificationBasic() {
        Notification notification = createNotifBasic().build();
        filterNotificationByVersionAndroid(notification);
    }

    @Override
    public void showNotificationBigPicture() {
        Glide.with(context)
                .asBitmap()
                .load(notificationObject.getImageBigPicture())
                .into(new CustomTarget<Bitmap>() {
                    @Override
                    public void onLoadFailed(@Nullable Drawable errorDrawable) {
                        Notification notification = createNotifBasic().build();
                        filterNotificationByVersionAndroid(notification);
                    }

                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        Notification notification = createNotifBigPicture(resource).build();
                        filterNotificationByVersionAndroid(notification);
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });
    }

    @Override
    public void showNotificationLargeIcon() {
        Glide.with(context)
                .asBitmap()
                .load(notificationObject.getImageBigPicture())
                .into(new CustomTarget<Bitmap>() {
                    @Override
                    public void onLoadFailed(@Nullable Drawable errorDrawable) {
                        Notification notification = createNotifBasic().build();
                        filterNotificationByVersionAndroid(notification);
                    }

                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        Notification notification = createNotifLargeIcon(resource).build();
                        filterNotificationByVersionAndroid(notification);
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });
    }
}
