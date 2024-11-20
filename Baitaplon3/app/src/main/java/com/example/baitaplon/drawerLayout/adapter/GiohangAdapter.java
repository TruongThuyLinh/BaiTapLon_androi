package com.example.baitaplon.drawerLayout.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitaplon.R;

import com.example.baitaplon.drawerLayout.model.giohangmodel;


import java.text.BreakIterator;
import java.util.List;

public class GiohangAdapter extends RecyclerView.Adapter<GiohangAdapter.GiohangViewHolder> {
    private List<giohangmodel> giohangList;
    private Context context;

    public GiohangAdapter(List<giohangmodel> giohangList, Context context) {
        this.giohangList = giohangList;
        this.context = context;
    }

    @NonNull
    @Override
    public GiohangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_giohang, parent, false);
        return new GiohangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GiohangViewHolder holder, int position) {
        giohangmodel item = giohangList.get(position);

        // Set tên sản phẩm, giá và số lượng
        holder.productName.setText(item.getName());
        holder.productPrice.setText(item.getPrice());
        holder.itemGiohangSoluong.setText(String.valueOf(item.getQuantity()));

        // Set hình ảnh sản phẩm
        holder.productImage.setImageResource(item.getImage());

        // Xử lý sự kiện giảm số lượng
        holder.itemGiohangTru.setOnClickListener(view -> {
            if (item.getQuantity() > 1) {
                item.setQuantity(item.getQuantity() - 1);
                notifyItemChanged(position);
            }
        });

        // Xử lý sự kiện tăng số lượng
        holder.itemGiohangCong.setOnClickListener(view -> {
            item.setQuantity(item.getQuantity() + 1);
            notifyItemChanged(position);
        });
    }

    @Override
    public int getItemCount() {
        return giohangList.size();
    }

    public static class GiohangViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage, itemGiohangTru, itemGiohangCong;
        TextView productName, productPrice, itemGiohangSoluong;

        public GiohangViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);
            productName = itemView.findViewById(R.id.productName);
            productPrice = itemView.findViewById(R.id.productPrice);
            itemGiohangTru = itemView.findViewById(R.id.item_giohang_tru);
            itemGiohangCong = itemView.findViewById(R.id.item_giohang_cong);
            itemGiohangSoluong = itemView.findViewById(R.id.item_giohang_soluong);
        }
    }
}
