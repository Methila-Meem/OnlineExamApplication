package com.example.appbasedonexam;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

    private static SharedPref pref;
    private SharedPreferences sharedPreferences;

    public static SharedPref getInstance(Context context) {
        if (pref == null) {
            pref = new SharedPref(context);
        }
        return pref;
    }

    public SharedPref(Context context) {
        sharedPreferences = context.getSharedPreferences("Pref", Context.MODE_PRIVATE);
    }

    public String getData(String key) {
        if (sharedPreferences != null) {
            return sharedPreferences.getString(key, null);
        }
        return null;
    }

    public void saveData(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
}
