package vanskarner.android.communutilidades.utilities.pl.locale;

import java.util.Locale;

public class UtilityResource implements IUtilityResource{
    /**List of codes
     * Page web: https://www.w3.org/International/questions/qa-choosing-language-tags.es
     * codes: https://www.iana.org/assignments/language-subtag-registry/language-subtag-registry
     * Last consulted date: 31/07/2020
     * */
    public static final String LANGUAGE_SPANISH="es";//spanish
    public static final String LANGUAGE_ENGLISH="en";//eng
    public static final String LANGUAGE_TURKISH="tr";//tur

    @Override
    public boolean isLanguageCurrent(String languageToCompare) {
        Locale locale = Locale.getDefault();
        String languageCurrent = locale.getISO3Language();
        return languageCurrent.equals(languageToCompare);
    }
}
