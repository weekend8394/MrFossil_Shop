package com.example.mrfossil_shop.model;

import java.io.Serializable;

public class ShopData implements Serializable {
    private String shopAreaName;
    private String address;
    private String phone;

    public ShopData(String shopAreaName, String address, String phone) {
        this.shopAreaName = shopAreaName;
        this.address = address;
        this.phone = phone;
    }

    public String getShopAreaName() {
        return shopAreaName;
    }

    public void setShopAreaName(String shopAreaName) {
        this.shopAreaName = shopAreaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
