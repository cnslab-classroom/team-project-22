package com.example.test.DBSP;

import android.content.SharedPreferences;
import android.content.Context;

public class SP {
    public static final String PREFERENCES_NAME = "shared_preference";
    private static final int DEFAULT_VALUE_INT = 0;
    private static final String DEFAULT_VALUE_STRING = "";


    public static void clearmessage(Context context)
    {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();

        editor.remove("date1");
        editor.remove("event1");
        editor.remove("date2");
        editor.remove("event2");
        editor.remove("date3");
        editor.remove("event3");
        editor.remove("date4");
        editor.remove("event4");
        editor.remove("date5");
        editor.remove("event5");
        editor.remove("color1");
        editor.remove("color2");
        editor.remove("color3");
        editor.remove("color4");
        editor.remove("color5");
    }


    //test용 함수
    public static void clearData(Context context) {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();

        // 배경과 골드를 초기화 (삭제)
        editor.remove("button1");  // 배경 삭제
        editor.remove("button2");
        editor.remove("button3");
        editor.remove("button4");
        editor.remove("date1");
        editor.remove("event1");
        editor.remove("date2");
        editor.remove("event2");
        editor.remove("date3");
        editor.remove("event3");
        editor.remove("date4");
        editor.remove("event4");
        editor.remove("date5");
        editor.remove("event5");
        editor.remove("color1");
        editor.remove("color2");
        editor.remove("color3");
        editor.remove("color4");
        editor.remove("color5");

        editor.remove("messagenum");
        editor.remove("num");
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


    public static void setDate(Context context, String datekey, String text)
    {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(datekey, text);
        editor.apply();
    }

    public static String getDate(Context context, String dateKey){
        SharedPreferences prefs = getPreferences(context);
        return prefs.getString(dateKey, DEFAULT_VALUE_STRING);
    }

    public static void setEvent(Context context, String eventkey, String text)
    {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(eventkey, text);
        editor.apply();
    }

    public static String getEvent(Context context, String eventKey){
        SharedPreferences prefs = getPreferences(context);
        return prefs.getString(eventKey, DEFAULT_VALUE_STRING);
    }


    public static void setCoin(Context context, String coinkey, int coin) {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(coinkey, coin);
        editor.apply();
    }

    //저금통
    public static void setBackground(Context context,String backkey ,String background) {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(backkey, background);
        editor.apply();
    }

    public static void setmessageBackground(Context context,String messagekey ,String bankbackground) {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(messagekey, bankbackground);
        editor.apply();
    }

    public static String getmessageBackground(Context context, String messageKey){
        SharedPreferences prefs = getPreferences(context);
        return prefs.getString(messageKey, DEFAULT_VALUE_STRING);
    }

    //그냥 숫자랑 혼용해서 쓰는 DB
    public static void setMessageCount(Context context, String numkey,int MessageCount) {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(numkey, MessageCount);
        editor.apply();
    }

    public static void setvalue(Context context, String valuekey,int value) {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(valuekey, value);
        editor.apply();
    }

    public static int getvalue(Context context, String valuekey){
        SharedPreferences prefs = getPreferences(context);
        return prefs.getInt(valuekey, 1);
    }

    public static int getCoin(Context context, String coinkey){
        SharedPreferences prefs = getPreferences(context);
        return prefs.getInt(coinkey, 0);
    }

    //저금통
    public static String getBackground(Context context, String backkey){
        SharedPreferences prefs = getPreferences(context);
        return prefs.getString(backkey, DEFAULT_VALUE_STRING);
    }

    public static int getMessageCount(Context context, String numkey){
        SharedPreferences prefs = getPreferences(context);
        return prefs.getInt(numkey, DEFAULT_VALUE_INT);
    }

}
