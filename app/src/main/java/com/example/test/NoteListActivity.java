//NoteListActivity.java
package com.example.test;

import static com.example.test.DBSP.SP.clearmessage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.test.DBSP.SP;

public class NoteListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);  // activity_note_list.xml을 사용하여 레이아웃 설정

        int currentGold = SP.getCoin(this,"coin");
        int goldEarned = 10;
        SP.setCoin(this,"coin",currentGold+goldEarned);
        showGoldPopup(goldEarned);
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

        backButton.setOnClickListener(v -> showalertPopup());
    }

    private void showGoldPopup(int goldEarned) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("축하합니다!")
                .setMessage("골드 +" + goldEarned + " 획득!")
                .setPositiveButton("확인", (dialog, which) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showalertPopup() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("알림")
                .setMessage("뒤로가기를 하시면 편지들을 다시 확인할 수 없게 됩니다. 그래도 뒤로가기를 원하신다면 확인을 눌러주세요.")
                .setPositiveButton("확인",(dialog, which)->
                {
                    deleteDatabase();
                    finish();
                })
                .setNegativeButton("취소", (dialog, which) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    private void deleteDatabase() {

        clearmessage(this);
        
        SP.setvalue(this,"num",1);
        SP.setMessageCount(this,"messagenum",0);
    }
}
