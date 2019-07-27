package com.example.mrfossil_shop.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;

public class ShopProduct implements Serializable {
    private int imageRes;
    private String productName;
    private String productDescription;
    private int price;


    public ShopProduct(int imageRes, String productName, String productDescription, int price) {
        this.imageRes = imageRes;
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
