package com.example.baitaplon.drawerLayout.activity1;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.baitaplon.R;

public class chitietsanpham extends AppCompatActivity {
    ImageButton back;
    ImageView imageView;
    TextView textViewName,textViewPrice;

    private ImageView productImage;
    private TextView productName, productPrice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitietsanpham);
        back = findViewById(R.id.btnBack);
        productImage = findViewById(R.id.productImage);
        productName = findViewById(R.id.productName);
        productPrice = findViewById(R.id.productPrice);

        // sử lí sự kiên nút trở về
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


            }

        }
