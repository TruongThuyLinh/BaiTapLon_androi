package com.example.baitaplon.drawerLayout.model;

import java.io.Serializable;

public class giohangmodel implements Serializable {
    private  String name;
    private  String price;
    private  int image;
    private int quantity; // Số lượng sản phẩm
    public  giohangmodel(String name,String price,int image){
        this.image=image;
        this.name=name;
        this.price=price;
        this.quantity=1;
    }
    // Constructor 4 tham số
    public giohangmodel(String name, String price, int image, int quantity) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public  String getName(){
        return  name;
    }
    public  String getPrice(){
        return  price;
    }
    public  int getImage(){
        return  image;
    }
    // Getter cho số lượng sản phẩm
    public int getQuantity() {
        return quantity;
    }

    // Setter để cập nhật số lượng sản phẩm
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    // Tính tổng giá của sản phẩm (Giá * Số lượng)
    public double getTotalPrice() {
        try {
            return Double.parseDouble(price) * quantity;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}

