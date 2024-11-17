package com.example.test.DBSP;

import android.content.SharedPreferences;
import android.content.Context;

public class SP {
    public static final String PREFERENCES_NAME = "shared_preference";
    private static final int DEFAULT_VALUE_INT = 0;
    private static final String DEFAULT_VALUE_STRING = "";

    //test용 함수
    public static void clearData(Context context) {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();

        // 배경과 골드를 초기화 (삭제)
        editor.remove("button1");  // 배경 삭제
        editor.remove("button2");
        editor.remove("button3");
        editor.remove("button4");
        editor.remove("coin");  // 골드 삭제
        editor.apply();  // 변경 사항 적용
    }
    //test용 함수


    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public static void setbuttonMode(Context context, String buttonKey, String mode)
    {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(buttonKey, mode);
        editor.apply();
    }

    public static String getbuttonMode(Context context, String buttonKey){
        SharedPreferences prefs = getPreferences(context);
        return prefs.getString(buttonKey, DEFAULT_VALUE_STRING);
    }


    public static void setCoin(Context context, String coinkey, int coin) {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(coinkey, coin);
        editor.apply();
    }

    public static void setBackground(Context context,String backkey ,String background) {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(backkey, background);
        editor.apply();
    }

    public static void setMessageCount(Context context, int MessageCount) {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("MessageCount", MessageCount);
        editor.apply();
    }

    public static int getCoin(Context context, String coinkey){
        SharedPreferences prefs = getPreferences(context);
        return prefs.getInt(coinkey, 100);
    }

    public static String getBackground(Context context, String backkey){
        SharedPreferences prefs = getPreferences(context);
        return prefs.getString(backkey, DEFAULT_VALUE_STRING);
    }

    public static int getMessageCount(Context context){
        SharedPreferences prefs = getPreferences(context);
        return prefs.getInt("MessageCount", DEFAULT_VALUE_INT);
    }

}
