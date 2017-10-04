package example.mvp.com.myapplication.SharedPreferences;

import android.content.SharedPreferences;

import java.security.Key;

import javax.inject.Inject;

/**
 * Created by Guest User on 9/28/2017.
 */

public class MySharedPreferences {
    private SharedPreferences mSharedPreferences;

    @Inject
    public MySharedPreferences(SharedPreferences mSharedPreferences) {
        this.mSharedPreferences = mSharedPreferences;
    }
    public void putData(String key, String data) {
        mSharedPreferences.edit().putString(key,data).apply();
    }

    public String getData(String key) {
        return mSharedPreferences.getString(key,"");
    }

    public void putLast(String key, String data) {
        mSharedPreferences.edit().putString(key,data).apply();
    }

    public String getLast(String key) {
        return mSharedPreferences.getString(key,"");
    }
}
