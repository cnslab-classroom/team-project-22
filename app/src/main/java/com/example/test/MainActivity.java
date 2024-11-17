package com.example.test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.DBSP.*;


public class MainActivity extends AppCompatActivity {
    private Context context;
    private TextView goldView;
    private int gold;
    private ImageView backgroundImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        DB.makeDB(context);

        //*테스트용 데이터 지우기
        //SP.clearData(this);


        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);




        //gold 이미지 버튼 누르면 shop으로 넘어감
        ImageButton goldButton = findViewById(R.id.shop);
        goldButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ShopActivity로 이동하는 Intent 생성
                Intent intent = new Intent(MainActivity.this, ShopActivity.class);
                startActivity(intent);
            }
        });

        goldView = findViewById(R.id.gold_view);


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

    @Override //화면 전환될 때마다 새로고침 해주게끔
    protected void onResume() {
        super.onResume();
        // coin 값을 새로 갱신하고 화면에 업데이트
        gold = SP.getCoin(this,"coin");  // 골드를 갱신
        updategoldView();
        restoreBackgound();  // 갱신된 골드를 화면에 표시
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