package com.example.mrfossil_shop.model;

public class ShopingCart {
    private int id;
    private String name;
    private int imageSrc;
    private int price;
    private int amount;
    private String description;

    public ShopingCart() {
    }

    public ShopingCart(int id, String name, int imageSrc, int price, int amount, String description) {
        this.id = id;
        this.name = name;
        this.imageSrc = imageSrc;
        this.price = price;
        this.amount = amount;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(int imageSrc) {
        this.imageSrc = imageSrc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
