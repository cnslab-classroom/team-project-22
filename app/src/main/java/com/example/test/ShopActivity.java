//ShopActivity.java
package com.example.test;

import static com.example.test.DBSP.SP.getCoin;
import static com.example.test.DBSP.SP.setbuttonMode;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.test.DBSP.SP;


public class ShopActivity extends AppCompatActivity {
    private int gold; // 예시: 사용자 골드 초기값
    private int selectedBackground;
    private TextView goldView; // 화면에 보일 gold라는 이름의 text view
    private int backgroundImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);


        goldView = findViewById(R.id.gold_view);



        restorecoin("coin");




        ImageView backgroundImage1 = findViewById(R.id.backgroundImage1);
        ImageView backgroundImage2 = findViewById(R.id.backgroundImage2);
        ImageView backgroundImage3 = findViewById(R.id.backgroundImage3);
        ImageView backgroundImage4 = findViewById(R.id.backgroundImage4);

        Button purchaseButton1 = findViewById(R.id.purchaseButton1);
        Button purchaseButton2 = findViewById(R.id.purchaseButton2);
        Button purchaseButton3 = findViewById(R.id.purchaseButton3);
        Button purchaseButton4 = findViewById(R.id.purchaseButton4);

        ImageButton backButton = findViewById(R.id.backButton);


        restoreButtonState(purchaseButton1,"button1");
        restoreButtonState(purchaseButton2,"button2");
        restoreButtonState(purchaseButton3, "button3");
        restoreButtonState(purchaseButton4, "button4");


        // 배경 선택 시 변경
        purchaseButton1.setOnClickListener(v -> handlePurchase(0, purchaseButton1,"button1" ,R.drawable.piggy_bank_image));
        purchaseButton2.setOnClickListener(v -> handlePurchase(20, purchaseButton2, "button2",R.drawable.potato_image));
        purchaseButton3.setOnClickListener(v -> handlePurchase(30, purchaseButton3,"button3" ,R.drawable.bin_image));
        purchaseButton4.setOnClickListener(v -> handlePurchase(50, purchaseButton4, "button4",R.drawable.dog_image));

        // 뒤로 가기 버튼
        backButton.setOnClickListener(v -> finish());
    }

    private void updategoldView() {
        goldView.setText("Gold :" + gold);
    }

    // 구매 처리 메서드
    private void handlePurchase(int cost, Button button, String buttonKey, int backgroundResource) {

            if (button.getText().toString().equals("구매하기")) {
                // 구매 성공: 골드 차감 및 버튼 텍스트 변경
                if (gold <= cost)
                {
                    Toast.makeText(this, "돈이 부족합니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                gold -= cost;
                SP.setCoin(this,"coin",gold);
                updategoldView();
                button.setText("적용하기");

               SP.setbuttonMode(this,buttonKey,"적용하기");
               Toast.makeText(this, "구매 완료! 배경이 준비되었습니다.", Toast.LENGTH_SHORT).show();}

            }
            else {
                // "적용하기" 클릭 시 배경 적용
                selectedBackground = backgroundResource;
                SP.setBackground(this,"backkey",String.valueOf(backgroundResource));
                Toast.makeText(this, "배경이 적용되었습니다!", Toast.LENGTH_SHORT).show();
            }

    }

    private void restorecoin(String coinkey)
    {
        gold = SP.getCoin(this, coinkey);
        updategoldView();
    }


    private void restoreButtonState(Button button, String buttonkey)
    {
        String mode = SP.getbuttonMode(this,buttonkey);
        if (mode.equals("적용하기"))
        {
            button.setText("적용하기");
        }
        else {
            button.setText("구매하기");
        }
    }
}






