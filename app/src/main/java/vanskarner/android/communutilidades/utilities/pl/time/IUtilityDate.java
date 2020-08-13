package vanskarner.android.communutilidades.utilities.pl.time;

import java.util.Date;

public interface IUtilityDate {

    String dateFormat(Date date, String pattern);

    String dateCurrentFormat(String pattern);
}
