package com.example.test;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.DBSP.*;


public class MainActivity extends AppCompatActivity {
    private Context context;
    private TextView goldView;
    private TextView message_count_button;
    private int gold;
    private ImageView backgroundImageView;
    private int messagenum=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        DB.makeDB(context);

        //*테스트용 데이터 지우기
        //SP.clearData(this);


        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //쪽지쓰기 버튼
        ImageButton writeButton = findViewById(R.id.write_button);
        writeButton.setOnClickListener(v -> {
            if (messagenum >= 5) {
                // 알림 표시하고 이벤트 종료
                Toast.makeText(MainActivity.this, "저금통부터 열어주세요!", Toast.LENGTH_SHORT).show();
                return; // 다음 코드 실행 방지
            }


            // NoteAddActivity로 이동하는 인텐트 생성

            Intent intent = new Intent(MainActivity.this, NoteAddActivity.class);
            startActivity(intent);

        });





        //저금통 열기 버튼
        Button openButton = findViewById(R.id.message_open_button);
        openButton.setOnClickListener(v -> {
            if (messagenum >= 5) {
                // NoteAddActivity로 이동하는 인텐트 생성
                Intent intent = new Intent(MainActivity.this, NoteListActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this,"쪽지가 5개 이상 찰 시 확인가능합니다. 쪽지를 적어주세요!",Toast.LENGTH_SHORT).show();
            }
        });




        //gold 이미지 버튼 누르면 shop으로 넘어감
        ImageButton goldButton = findViewById(R.id.shop);
        goldButton.setOnClickListener(v -> {
            // ShopActivity로 이동하는 Intent 생성
            Intent intent = new Intent(MainActivity.this, ShopActivity.class);
            startActivity(intent);
        });

        goldView = findViewById(R.id.gold_view);
        message_count_button = findViewById(R.id.message_count_button);
        // coin DB에서 가져옴
        gold = SP.getCoin(this,"coin");

        // view 업데이트
        updategoldView();


        backgroundImageView = findViewById(R.id.imageView);
        restoreBackgound();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });


    }



    @Override
    public void onBackPressed() {
    }



    @Override //화면 전환될 때마다 새로고침 해주게끔
    protected void onResume() {
        super.onResume();
        // coin 값을 새로 갱신하고 화면에 업데이트
        gold = SP.getCoin(this,"coin");  // 골드를 갱신
        updategoldView();
        restoreBackgound();  // 갱신된 골드를 화면에 표시
        updatemessagenum();
    }



    private void updatemessagenum() {
        messagenum = SP.getMessageCount(this, "messagenum");
        message_count_button.setText("쪽지 수 :"+messagenum);


    }



    private void updategoldView() {
        goldView.setText("Gold :" + gold);
    }


    private void restoreBackgound()
    {
        String backgroundResourceStr = SP.getBackground(this, "backkey");
        if (!backgroundResourceStr.isEmpty()) {
            int backgroundResource = Integer.parseInt(backgroundResourceStr);  // 저장된 배경 리소스를 Integer로 변환
            backgroundImageView.setImageResource(backgroundResource);  // 해당 이미지로 변경
        }
    }



}