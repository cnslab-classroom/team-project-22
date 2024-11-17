//ShopActivity.java
package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ShopActivity extends AppCompatActivity {
    private int gold = 100; // 예시: 사용자 골드 초기값
    private int selectedBackground = android.R.color.white;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        ImageView backgroundImage1 = findViewById(R.id.backgroundImage1);
        ImageView backgroundImage2 = findViewById(R.id.backgroundImage2);
        ImageView backgroundImage3 = findViewById(R.id.backgroundImage3);
        ImageView backgroundImage4 = findViewById(R.id.backgroundImage4);
        Button purchaseButton1 = findViewById(R.id.purchaseButton1);
        Button purchaseButton2 = findViewById(R.id.purchaseButton2);
        Button purchaseButton3 = findViewById(R.id.purchaseButton3);
        Button purchaseButton4 = findViewById(R.id.purchaseButton4);
        ImageButton backButton = findViewById(R.id.backButton);

        // 배경 선택 시 변경
        backgroundImage1.setOnClickListener(v -> {
            selectedBackground = R.drawable.new_background; // 구매 가능한 배경
            Toast.makeText(this, "배경 1 선택됨!", Toast.LENGTH_SHORT).show();
        });
        backgroundImage2.setOnClickListener(v -> {
            selectedBackground = R.drawable.new_background; // 구매 가능한 배경
            Toast.makeText(this, "배경 2 선택됨!", Toast.LENGTH_SHORT).show();
        });
        backgroundImage3.setOnClickListener(v -> {
            selectedBackground = R.drawable.new_background; // 구매 가능한 배경
            Toast.makeText(this, "배경 3 선택됨!", Toast.LENGTH_SHORT).show();
        });
        backgroundImage4.setOnClickListener(v -> {
            selectedBackground = R.drawable.new_background; // 구매 가능한 배경
            Toast.makeText(this, "배경 4 선택됨!", Toast.LENGTH_SHORT).show();
        });

        // 구매 버튼 클릭 시
        purchaseButton1.setOnClickListener(v -> handlePurchase());
        purchaseButton2.setOnClickListener(v -> handlePurchase());
        purchaseButton3.setOnClickListener(v -> handlePurchase());
        purchaseButton4.setOnClickListener(v -> handlePurchase());

        // 뒤로 가기 버튼
        backButton.setOnClickListener(v -> finish());
    }

    // 구매 처리 메서드
    private void handlePurchase() {
        if (gold >= 50) { // 배경 가격이 50 골드라고 가정
            gold -= 50;
            Intent intent = new Intent();
            intent.putExtra("background", selectedBackground);
            setResult(RESULT_OK, intent);
            Toast.makeText(this, "구매 완료!", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "골드가 부족합니다!", Toast.LENGTH_SHORT).show();
        }
    }
}
