package com.example.test;

import android.graphics.drawable.GradientDrawable;
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
    private LinearLayout noteLayout;
    private EditText dateInput, happyEventInput;

    private int num = 1;
    private int messagenum = 0;

    private String DBColor = "White";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_add);

        // Spinner와 쪽지 입력 레이아웃 초기화
        colorSpinner = findViewById(R.id.colorSpinner);
        noteLayout = findViewById(R.id.noteLayout);

        // 날짜와 이벤트
        dateInput = findViewById(R.id.dateInput);
        happyEventInput = findViewById(R.id.happyEventInput);
        updatenum();
        updatemessagenum();

        // 추가 버튼
        ImageButton addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(v -> {
            // Get the values from the EditText fields
            String date = dateInput.getText().toString();
            String happyEvent = happyEventInput.getText().toString();

            String datekey = "date" + num;
            String eventkey = "event" + num;
            String colorkey = "color" + num;
            num++;
            messagenum++;
            SP.setvalue(NoteAddActivity.this, "num", num);
            SP.setMessageCount(NoteAddActivity.this, "messagenum", messagenum);
            SP.setDate(NoteAddActivity.this, datekey, date);
            SP.setEvent(NoteAddActivity.this, eventkey, happyEvent);
            SP.setmessageBackground(NoteAddActivity.this, colorkey, DBColor);

            Toast.makeText(NoteAddActivity.this, "추가되었습니다", Toast.LENGTH_SHORT).show();

            if (messagenum >= 5) {
                Toast.makeText(NoteAddActivity.this, "목표값에 도달하였습니다. 저금통을 열어보세요!", Toast.LENGTH_SHORT).show();
            }

            addButton.setVisibility(View.GONE);
        });

        // 뒤로가기 버튼
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        // 색상 목록을 Spinner에 추가
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.color_list,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpinner.setAdapter(adapter);

        // Spinner에서 색상 선택 시 이벤트 처리
        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedColor = (String) parentView.getItemAtPosition(position);
                changeNoteBackgroundColor(selectedColor);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                resetNoteBackground();
            }
        });

        // 초기 배경 설정
        resetNoteBackground();
    }

    private void updatenum() {
        num = SP.getvalue(this, "num");
    }

    private void updatemessagenum() {
        messagenum = SP.getMessageCount(this, "messagenum");
    }

    // 배경색 및 둥근 모서리 적용 메소드
    private void changeNoteBackgroundColor(String color) {
        GradientDrawable background = (GradientDrawable) noteLayout.getBackground();

        switch (color) {
            case "Red":
                background.setColor(0xFFFFE5E5);
                DBColor = "Red";
                break;
            case "Green":
                background.setColor(0xFFDCF8DC);
                DBColor = "Green";
                break;
            case "Blue":
                background.setColor(0xFFDAF5F9);
                DBColor = "Blue";
                break;
            case "Yellow":
                background.setColor(0xFFFAF4C0);
                DBColor = "Yellow";
                break;
            case "Magenta":
                background.setColor(0xFFFFD9FA);
                DBColor = "Magenta";
                break;
            default:
                background.setColor(0xFFFFFFFF);
                DBColor = "White";
                break;
        }
    }

    // 초기 배경을 둥근 모서리로 설정
    private void resetNoteBackground() {
        noteLayout.setBackgroundResource(R.drawable.round_border);
    }
}
