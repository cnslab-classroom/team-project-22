//NoteListActivity.java
package com.example.test;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class NoteListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);  // activity_note_list.xml을 사용하여 레이아웃 설정
    }
}
