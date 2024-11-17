package com.example.test.DBSP;

import android.content.SharedPreferences;
import android.content.Context;

public class SP {
    public static final String PREFERENCES_NAME = "shared_preference";
    private static final int DEFAULT_VALUE_INT = 0;
    private static final String DEFAULT_VALUE_STRING = "";

    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public static void setCoin(Context context, int coin) {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("coin", coin);
        editor.apply();
    }

    public static void setBackground(Context context, String background) {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("background", background);
        editor.apply();
    }

    public static void setMessageCount(Context context, int MessageCount) {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("MessageCount", MessageCount);
        editor.apply();
    }

    public static int getCoin(Context context){
        SharedPreferences prefs = getPreferences(context);
        return prefs.getInt("coin", DEFAULT_VALUE_INT);
    }

    public static String getBackground(Context context){
        SharedPreferences prefs = getPreferences(context);
        return prefs.getString("Background", DEFAULT_VALUE_STRING);
    }

    public static int getMessageCount(Context context){
        SharedPreferences prefs = getPreferences(context);
        return prefs.getInt("MessageCount", DEFAULT_VALUE_INT);
    }

}
