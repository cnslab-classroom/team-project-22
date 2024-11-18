//NoteListActivity.java
package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.DBSP.SP;

public class NoteListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);  // activity_note_list.xml을 사용하여 레이아웃 설정


        ImageButton Imagebtn1 = findViewById(R.id.imageButton1);
        ImageButton Imagebtn2 = findViewById(R.id.imageButton2);
        ImageButton Imagebtn3 = findViewById(R.id.imageButton3);
        ImageButton Imagebtn4 = findViewById(R.id.imageButton4);
        ImageButton Imagebtn5 = findViewById(R.id.imageButton5);
        ImageButton Imagebtn6 = findViewById(R.id.imageButton6);


        Imagebtn1.setOnClickListener(v -> {
            // Note.java로 이동하는 Intent 생성
            Intent intent = new Intent(NoteListActivity.this, Note.class);
            intent.putExtra("value", 1);
            startActivity(intent);
        });

        Imagebtn2.setOnClickListener(v -> {
            Intent intent = new Intent(NoteListActivity.this, Note.class);

            intent.putExtra("value", 2);
            startActivity(intent);
        });


        Imagebtn3.setOnClickListener(v -> {
            // Note.java로 이동하는 Intent 생성
            Intent intent = new Intent(NoteListActivity.this, Note.class);
            intent.putExtra("value", 3);
            startActivity(intent);
        });


        Imagebtn4.setOnClickListener(v -> {
            // Note.java로 이동하는 Intent 생성
            Intent intent = new Intent(NoteListActivity.this, Note.class);
            intent.putExtra("value", 4);
            startActivity(intent);
        });


        Imagebtn5.setOnClickListener(v -> {
            // Note.java로 이동하는 Intent 생성
            Intent intent = new Intent(NoteListActivity.this, Note.class);
            intent.putExtra("value", 5);
            startActivity(intent);
        });

        Imagebtn6.setOnClickListener(v -> {
            // Note.java로 이동하는 Intent 생성
            Intent intent = new Intent(NoteListActivity.this, Note.class);
            intent.putExtra("value", 6);
            startActivity(intent);
        });



        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());
    }

    private void showMessage() {


    }


}
