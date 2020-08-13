package vanskarner.android.communutilidades.utilities.pl.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilityDate implements IUtilityDate {

    public static final String FORMAT_PATTERN_DATE_1 = "E yyy/MM/dd HH:mm";

    @Override
    public String dateFormat(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) SimpleDateFormat.getInstance();
        simpleDateFormat.applyPattern(pattern);
        return simpleDateFormat.format(date);
    }

    @Override
    public String dateCurrentFormat(String pattern) {
        SimpleDateFormat simpleDateFormat =  (SimpleDateFormat) SimpleDateFormat.getInstance();
        Date dateCurrent = new Date();
        simpleDateFormat.applyPattern(pattern);
        return simpleDateFormat.format(dateCurrent);
    }

}
