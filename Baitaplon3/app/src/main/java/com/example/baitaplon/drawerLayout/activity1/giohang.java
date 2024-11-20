package com.example.baitaplon.drawerLayout.activity1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitaplon.R;
import com.example.baitaplon.drawerLayout.adapter.GiohangAdapter;
import com.example.baitaplon.drawerLayout.model.giohangmodel;

import java.util.ArrayList;
import java.util.List;


public class giohang extends AppCompatActivity {

    private RecyclerView recyclerView;
     ImageView back;
     TextView tongtien;
     Button muahang;
    private GiohangAdapter giohangAdapter;
    private List<giohangmodel> giohangList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giohang); // Ensure giohang.xml layout has a RecyclerView with ID recyclerView
        // Nhận dữ liệu từ Intent
        giohangList = (List<giohangmodel>) getIntent().getSerializableExtra("giohangList");
        if (giohangList == null) {
            giohangList = new ArrayList<>();
        }
        // Thiết lập RecyclerView
        recyclerView = findViewById(R.id.recyclergiohang);
        tongtien=findViewById(R.id.tongtien);
        giohangAdapter = new GiohangAdapter(giohangList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(giohangAdapter);
        // Hiển thị số lượng và tổng giá trị của giỏ hàng (nếu cần)
        tongtien = findViewById(R.id.tongtien);
        updateTotalPrice();


        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Closes the activity and goes back
            }
        });


    }

    private void updateTotalPrice() {
        double totalPrice = 0;
        for (giohangmodel item : giohangList) {
            totalPrice += item.getQuantity() * Double.parseDouble(item.getPrice());
        }
        tongtien.setText("Tổng: " + totalPrice + " VND");
    }

}