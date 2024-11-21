package com.example.test;

import static com.example.test.DBSP.SP.getCoin;
import static com.example.test.DBSP.SP.setbuttonMode;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.test.DBSP.SP;

public class ShopActivity extends AppCompatActivity {
    private int gold;
    private int selectedBackground;
    private TextView goldView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        goldView = findViewById(R.id.gold_view);
        restoreCoin("coin");

        ImageView backgroundImage1 = findViewById(R.id.backgroundImage1);
        ImageView backgroundImage2 = findViewById(R.id.backgroundImage2);
        ImageView backgroundImage3 = findViewById(R.id.backgroundImage3);
        ImageView backgroundImage4 = findViewById(R.id.backgroundImage4);

        Button purchaseButton1 = findViewById(R.id.purchaseButton1);
        Button purchaseButton2 = findViewById(R.id.purchaseButton2);
        Button purchaseButton3 = findViewById(R.id.purchaseButton3);
        Button purchaseButton4 = findViewById(R.id.purchaseButton4);

        ImageButton backButton = findViewById(R.id.backButton);

        // 기존 버튼 상태 복원
        restoreButtonState(purchaseButton1, "button1");
        restoreButtonState(purchaseButton2, "button2");
        restoreButtonState(purchaseButton3, "button3");
        restoreButtonState(purchaseButton4, "button4");

        // 각 구매 버튼에 대한 클릭 리스너 설정
        purchaseButton1.setOnClickListener(v -> handlePurchase(0, purchaseButton1, "button1", R.drawable.piggy_bank_image));
        purchaseButton2.setOnClickListener(v -> handlePurchase(20, purchaseButton2, "button2", R.drawable.potato_image));
        purchaseButton3.setOnClickListener(v -> handlePurchase(30, purchaseButton3, "button3", R.drawable.bin_image));
        purchaseButton4.setOnClickListener(v -> handlePurchase(50, purchaseButton4, "button4", R.drawable.dog_image));

        // 뒤로 가기 버튼
        backButton.setOnClickListener(v -> finish());


    }

    // 금액 업데이트
    private void updateGoldView() {
        goldView.setText("Gold: " + gold);
    }



    // 구매 처리
    private void handlePurchase(int cost, Button button, String buttonKey, int backgroundResource) {
        if ("구매하기".equals(button.getText().toString())) {
            if (gold < cost) {
                Toast.makeText(this, "돈이 부족합니다.", Toast.LENGTH_SHORT).show();
            } else {
                gold -= cost;
                SP.setCoin(this, "coin", gold);
                updateGoldView();
                button.setText("적용하기");
                SP.setbuttonMode(this, buttonKey, "적용하기");
                Toast.makeText(this, "구매 완료! 배경이 준비되었습니다.", Toast.LENGTH_SHORT).show();
                button.setBackgroundColor(ContextCompat.getColor(this, R.color.color_button_apply)); // 수정된 부분
            }
        } else {
            selectedBackground = backgroundResource;
            SP.setBackground(this, "backkey", String.valueOf(backgroundResource));
            Toast.makeText(this, "배경이 적용되었습니다!", Toast.LENGTH_SHORT).show();
            button.setBackgroundColor(ContextCompat.getColor(this, R.color.color_button_purchase)); // 수정된 부분
        }
    }

    // 코인 정보 복원
    private void restoreCoin(String coinKey) {
        gold = SP.getCoin(this, coinKey);
        updateGoldView();
    }

    // 버튼 상태 복원
    private void restoreButtonState(Button button, String buttonKey) {
        String mode = SP.getbuttonMode(this, buttonKey);
        button.setBackgroundColor(ContextCompat.getColor(this, R.color.color_button_apply));
        button.setBackgroundColor(ContextCompat.getColor(this, R.color.color_button_purchase)); // 수정된 부분
        if ("적용하기".equals(mode)) {
            button.setText("적용하기");
        } else {
            button.setText("구매하기");

        }
    }

}

