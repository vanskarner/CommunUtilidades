package vanskarner.android.communutilidades.utilities.so.preference;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import com.google.gson.Gson;


public class UtilityPreference implements IUtilityPrefence {
    private static final String DEFAULT_STRING = "";
    private static final int DEFAULT_INT = 0;
    private static final float DEFAULT_FLOAT = 0.0f;
    private static final long DEFAULT_LONG = 0;
    private static final boolean DEFAULT_BOOLEAN = false;
    private static final String DEFAULT_OBJECT = null;

    private SharedPreferences sharedPreferences;

    public UtilityPreference(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

    }

    @Override
    public void saveString(String key, String value) {
        sharedPreferences
                .edit()
                .putString(key, value)
                .apply();
    }

    @Override
    public void saveInt(String key, int value) {
        sharedPreferences
                .edit()
                .putInt(key, value)
                .apply();
    }

    @Override
    public void saveBoolean(String key, boolean value) {
        sharedPreferences
                .edit()
                .putBoolean(key, value)
                .apply();
    }

    @Override
    public void saveLong(String key, long value) {
        sharedPreferences
                .edit()
                .putLong(key, value)
                .apply();
    }

    @Override
    public void saveFloat(String key, float value) {
        sharedPreferences
                .edit()
                .putFloat(key, value)
                .apply();
    }

    @Override
    public void saveObject(String key, Object object) {
        Gson gson = new Gson();
        String json = gson.toJson(object);
        sharedPreferences.edit().putString(key, json).apply();
    }

    @Override
    public void getInt(String key, OnPreference<Integer> listener) {
        int result = sharedPreferences.getInt(key, DEFAULT_INT);
        if (result == DEFAULT_INT) {
            listener.notExist();
        } else {
            listener.exists(result);
        }
    }

    @Override
    public void getBoolean(String key, OnPreference<Boolean> listener) {
        boolean result = sharedPreferences.getBoolean(key, DEFAULT_BOOLEAN);
        if (result == DEFAULT_BOOLEAN) {
            listener.notExist();
        } else {
            listener.exists(result);
        }
    }

    @Override
    public void getLong(String key, OnPreference<Long> listener) {
        long result = sharedPreferences.getLong(key, DEFAULT_LONG);
        if (result == DEFAULT_LONG) {
            listener.notExist();
        } else {
            listener.exists(result);
        }
    }

    @Override
    public void getFloat(String key, OnPreference<Float> listener) {
        float result = sharedPreferences.getFloat(key, DEFAULT_FLOAT);
        if (result == DEFAULT_FLOAT) {
            listener.notExist();
        } else {
            listener.exists(result);
        }
    }

    @Override
    public void getString(String key, OnPreference<String> listener) {
        String result = sharedPreferences.getString(key, DEFAULT_STRING);
        if (result.equals(DEFAULT_STRING)) {
            listener.notExist();
        } else {
            listener.exists(result);
        }
    }

    @Override
    public void getObject(String key, Class formatObject, OnPreference<Object> listener) {
        Gson gson = new Gson();
        String json = sharedPreferences.getString(key, DEFAULT_OBJECT);
        if (gson.fromJson(json, formatObject) == DEFAULT_OBJECT) {
            listener.notExist();
        } else {
            listener.exists(gson.fromJson(json, formatObject));
        }
    }

    @Override
    public void deleteAllPreferences() {
        sharedPreferences.edit().clear().apply();
    }

}
