package vanskarner.android.communutilidades.utilities.so.notification;

import android.content.Intent;

public class NotificationObject {

    private int idNotification;
    private int smallIcon;
    private int colorSmallIcon;
    private String imageLarge;
    private String imageBigPicture;
    private String title;
    private String description;
    private String subText;
    private String ticker;
    private boolean vibrationNotif;
    private int sound;
    private Intent intent;
    private String ID_CHANNEL;
    private String NAME_CHANNEL;
    private String DESCRIPTION_CHANNEL;
    private int REQUESTCODE_PENDINGINTENT;
    private int PRIORITY;//api<=25
    private int IMPORTANCE;//api>=26
    private String CATEGORY;


    public NotificationObject(int idNotification, int smallIcon, int colorSmallIcon, String imageLarge, String imageBigPicture, String title, String description, String subText, String ticker, boolean vibrationNotif, int sound, Intent intent, String ID_CHANNEL, String NAME_CHANNEL, String DESCRIPTION_CHANNEL, int REQUESTCODE_PENDINGINTENT, int PRIORITY, int IMPORTANCE, String CATEGORY) {
        this.idNotification = idNotification;
        this.smallIcon = smallIcon;
        this.colorSmallIcon = colorSmallIcon;
        this.imageLarge = imageLarge;
        this.imageBigPicture = imageBigPicture;
        this.title = title;
        this.description = description;
        this.subText = subText;
        this.ticker = ticker;
        this.vibrationNotif = vibrationNotif;
        this.sound = sound;
        this.intent = intent;
        this.ID_CHANNEL = ID_CHANNEL;
        this.NAME_CHANNEL = NAME_CHANNEL;
        this.DESCRIPTION_CHANNEL = DESCRIPTION_CHANNEL;
        this.REQUESTCODE_PENDINGINTENT = REQUESTCODE_PENDINGINTENT;
        this.PRIORITY = PRIORITY;
        this.IMPORTANCE = IMPORTANCE;
        this.CATEGORY = CATEGORY;
    }

    public int getIdNotification() {
        return idNotification;
    }

    public int getSmallIcon() {
        return smallIcon;
    }

    public int getColorSmallIcon() {
        return colorSmallIcon;
    }

    public String getImageLarge() {
        return imageLarge;
    }

    public String getImageBigPicture() {
        return imageBigPicture;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSubText() {
        return subText;
    }

    public String getTicker() {
        return ticker;
    }

    public boolean isVibrationNotif() {
        return vibrationNotif;
    }

    public int getSound() {
        return sound;
    }

    public Intent getIntent() {
        return intent;
    }

    public String getID_CHANNEL() {
        return ID_CHANNEL;
    }

    public String getNAME_CHANNEL() {
        return NAME_CHANNEL;
    }

    public String getDESCRIPTION_CHANNEL() {
        return DESCRIPTION_CHANNEL;
    }

    public int getREQUESTCODE_PENDINGINTENT() {
        return REQUESTCODE_PENDINGINTENT;
    }

    public int getPRIORITY() {
        return PRIORITY;
    }

    public int getIMPORTANCE() {
        return IMPORTANCE;
    }

    public String getCATEGORY() {
        return CATEGORY;
    }

    public static NotificationObject createInstance(int idNotification, int smallIcon, int colorSmallIcon, String imageLarge, String imageBigPicture, String title, String description, String subText, String ticker, boolean vibrationNotif, int sound, Intent intent, String ID_CHANNEL, String NAME_CHANNEL, String DESCRIPTION_CHANNEL, int REQUESTCODE_PENDINGINTENT, int PRIORITY, int IMPORTANCE, String CATEGORY) {
        return new NotificationObject(idNotification, smallIcon, colorSmallIcon, imageLarge, imageBigPicture, title, description, subText, ticker, vibrationNotif, sound, intent, ID_CHANNEL, NAME_CHANNEL, DESCRIPTION_CHANNEL, REQUESTCODE_PENDINGINTENT, PRIORITY, IMPORTANCE, CATEGORY);
    }

    @Override
    public String toString() {
        return "NotificationObject{" +
                "idNotification=" + idNotification +
                ", smallIcon=" + smallIcon +
                ", colorSmallIcon=" + colorSmallIcon +
                ", imageLarge='" + imageLarge + '\'' +
                ", imageBigPicture='" + imageBigPicture + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", subText='" + subText + '\'' +
                ", ticker='" + ticker + '\'' +
                ", vibrationNotif=" + vibrationNotif +
                ", sound=" + sound +
                ", intent=" + intent +
                ", ID_CHANNEL='" + ID_CHANNEL + '\'' +
                ", NAME_CHANNEL='" + NAME_CHANNEL + '\'' +
                ", DESCRIPTION_CHANNEL='" + DESCRIPTION_CHANNEL + '\'' +
                ", REQUESTCODE_PENDINGINTENT=" + REQUESTCODE_PENDINGINTENT +
                ", PRIORITY=" + PRIORITY +
                ", IMPORTANCE=" + IMPORTANCE +
                ", CATEGORY='" + CATEGORY + '\'' +
                '}';
    }
}
