//NoteAddActivity.java
package com.example.test;  // 패키지 선언 추가

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.DBSP.SP;

public class NoteAddActivity extends AppCompatActivity {

    private Spinner colorSpinner;
    private LinearLayout noteLayout; // LinearLayout 객체로 선언
    private EditText dateInput, happyEventInput;

    private int num=0;
    private int eventnum =0;
    private int messagecount=0;
    private String selectedColor = "White";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_add);

        // Spinner와 쪽지 입력 레이아웃 초기화
        colorSpinner = findViewById(R.id.colorSpinner);
        noteLayout = findViewById(R.id.noteLayout);  // LinearLayout으로 올바르게 참조


        //날짜와 이벤트
        dateInput = findViewById(R.id.dateInput);
        happyEventInput = findViewById(R.id.happyEventInput);
        updatenum();
        updateeventnum();
        updatemessagecount();

        //추가버튼 누르면
        ImageButton addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              // Get the values from the EditText fields
              String date = dateInput.getText().toString();
              String happyEvent = happyEventInput.getText().toString();

              String datekey = "date" + num;
              String eventkey = "event"+eventnum;

              num++;
              SP.setMessageCount(NoteAddActivity.this,"num",num);
              eventnum++;
              SP.setMessageCount(NoteAddActivity.this,"eventnum",eventnum);
              messagecount++;
              SP.setMessageCount(NoteAddActivity.this,"messagecount",messagecount);

              SP.setDate(NoteAddActivity.this, datekey,date);
              SP.setEvent(NoteAddActivity.this,eventkey,happyEvent);

              //SP.setBackground(NoteAddActivity.this,"color"+num,selectedColor);

              Toast.makeText(NoteAddActivity.this, "추가되었습니다", Toast.LENGTH_SHORT).show();

              addButton.setVisibility(View.GONE);
          } });


        ImageButton backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(v -> finish());

                // 색상 목록을 Spinner에 추가
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.color_list, // 색상 목록 배열 (res/values/strings.xml)
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpinner.setAdapter(adapter);

        // Spinner에서 색상 선택 시 이벤트 처리
        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // 선택된 색상에 따라 쪽지 배경 색상 변경
                String selectedColor = (String) parentView.getItemAtPosition(position);
                changeNoteBackgroundColor(selectedColor);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // 아무것도 선택되지 않은 경우, 배경색을 기본 색상으로 설정
                noteLayout.setBackgroundColor(Color.WHITE);
            }
        });
    }

    private void updatemessagecount()
    {
        messagecount = SP.getMessageCount(this,"messagecount");
    }

    private void updateeventnum() {
        eventnum = SP.getMessageCount(this,"eventnum");
    }

    private void updatenum() {
        num=SP.getMessageCount(this,"num");
    }


    // 선택된 색상에 따라 배경색을 변경하는 메소드
    private void changeNoteBackgroundColor(String color) {
        switch (color) {
            case "Red":
                noteLayout.setBackgroundColor(Color.RED);
                break;
            case "Green":
                noteLayout.setBackgroundColor(Color.GREEN);
                break;
            case "Blue":
                noteLayout.setBackgroundColor(Color.BLUE);
                break;
            case "Yellow":
                noteLayout.setBackgroundColor(Color.YELLOW);
                break;
            case "Pink":
                noteLayout.setBackgroundColor(Color.MAGENTA);
                break;
            default:
                noteLayout.setBackgroundColor(Color.WHITE);
                break;
        }
    }
}
