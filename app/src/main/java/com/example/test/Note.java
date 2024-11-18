//Note.java
package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.DBSP.SP;

public class Note extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_item);


        Intent intent = getIntent();
        int value = intent.getIntExtra("value",0);
        String date = SP.getDate(this,"date"+value);

        String event = SP.getEvent(this,"event"+value);

        // TextView에 편지 내용 표시
        TextView notesTextView = findViewById(R.id.dateTextView);
        notesTextView.setText("날짜 : " + date);

        TextView eventTextView = findViewById(R.id.contentTextView);
        eventTextView.setText(event);
    }
}



