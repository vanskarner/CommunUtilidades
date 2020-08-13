package vanskarner.android.communutilidades.utilities.so.preference;

public interface IUtilityPrefence {

    void saveString(String key, String value);

    void saveInt(String key, int value);

    void saveBoolean(String key, boolean value);

    void saveLong(String key, long value);

    void saveFloat(String key, float value);

    void saveObject(String key, Object object);

    void getInt(String key, OnPreference<Integer> listener) ;

    void getBoolean(String key, OnPreference<Boolean> listener);

    void getLong(String key, OnPreference<Long> listener) ;

    void getFloat(String key, OnPreference<Float> listener);

    void getString(String key, OnPreference<String> listener);

    void getObject(String key, Class formatObject, OnPreference<Object> listener);

    // Delete all preferences
    void deleteAllPreferences();

}
