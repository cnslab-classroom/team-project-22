//Note.java
package com.example.test;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.DBSP.SP;

public class Note extends AppCompatActivity {
    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_item);


        Intent intent = getIntent();
        int value = intent.getIntExtra("value",1);

        LinearLayout linearLayout = findViewById(R.id.background);

        String date = SP.getDate(this,"date"+value);

        String event = SP.getEvent(this,"event"+value);

        String back_ground = SP.getmessageBackground(this,"color"+value);

        // 데이터 검증 및 로그 출력
        if (date == null || date.isEmpty()) {
            Log.d("NoteDebug", "Date not found for key: date" + value);
            date = "날짜 없음";
        }
        if (event == null || event.isEmpty()) {
            Log.d("NoteDebug", "Event not found for key: event" + value);
            event = "내용 없음";
        }



        linearLayout.setBackgroundColor(getColorFromName(back_ground));

        TextView notesTextView = findViewById(R.id.dateTextView);
        notesTextView.setText("날짜 : " + date);

        TextView eventTextView = findViewById(R.id.contentTextView);
        eventTextView.setText(event);
    }

    private int getColorFromName(String colorName) {
        switch (colorName) {
            case "Red":
                return Color.rgb(255, 216, 216);
            case "Green":
                return Color.rgb(183, 240, 177);
            case "Blue":
                return Color.rgb(178, 235, 244);
            case "Yellow":
                return Color.rgb(250, 244, 192);
            case "Magenta":
                return Color.rgb(255, 217, 250);
            default:
                return Color.WHITE;
        }
}}


