package com.example.mrfossil_shop.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.mrfossil_shop.model.ShopProduct;
import com.example.mrfossil_shop.model.ShopingCart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDBHelper extends SQLiteOpenHelper {
    /**資料庫名稱*/
    private static final String DB_NAME = "ShoppingCarts";
    /**版本*/
    private static final int DB_VERSION = 1;
    /**表格名子*/
    private static final String TABLE_NAME = "ShoppingCart";
    /**欄位名稱*/
    private static final String id = "id";//id
    private static final String name = "name";//產品名稱
    private static final String imageSrc = "image";//產品大頭照
    private static final String price = "price";//產品價格
    private static final String amount = "amount";//產品數量
    private static final String description = "description";//產品描述

    /**建表格*/
    private static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + "(" +
            id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            name + " TEXT NOT NULL, " +
            imageSrc + " INTEGER, " +
            price + " INTEGER, " +
            amount + " INTEGER, " +
            description + " TEXT );";

    public ShoppingCartDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /**刪除原有表格*/
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /**搜尋表格全部資料*/
    public List<ShopingCart> getShopingCartList(){
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM ShoppingCart;";
        String[] args = {};
        Cursor cursor = db.rawQuery(sql,args);

//        String[] columns = {
//                id, name, imageSrc, price, amount, description
//        };
//        Cursor cursor = db.query(TABLE_NAME, columns, null, null, null, null,
//                null);

        List<ShopingCart> shopingCartList = new ArrayList<>();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            int imageSrc = cursor.getInt(2);
            int price = cursor.getInt(3);
            int amount = cursor.getInt(4);
            String description = cursor.getString(5);
            ShopingCart shopingCart = new ShopingCart(id, name, imageSrc, price, amount, description);
            shopingCartList.add(shopingCart);
        }
        cursor.close();
        Log.d("TAG","照片id : " + imageSrc + "名稱 : "+ name + "數量 : " + amount +  "單價 : " + price );

        return shopingCartList;
    }


    public ShopingCart findById(int id){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "SELECT * FROM ShoppingCart WHERE id = " + id + ";";
        String[] args = {};
        Cursor cursor = db.rawQuery(sql,args);
        ShopingCart shopingCart = null;
        if(cursor.moveToNext()){
            id = cursor.getInt(0);
            String name = cursor.getString(1);
            int imageSrc = cursor.getInt(2);
            int price = cursor.getInt(3);
            int amount = cursor.getInt(4);
            String description = cursor.getString(5);
            shopingCart = new ShopingCart(id,name,imageSrc,price,amount,description);
        }
        cursor.close();
        return shopingCart;
    }

    public long insert(ShopingCart shopingCart){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(name, shopingCart.getName());
        values.put(imageSrc, shopingCart.getImageSrc());
        values.put(price, shopingCart.getPrice());
        values.put(amount, shopingCart.getAmount());
        values.put(description, shopingCart.getDescription());
//        String whereClause = id + " = ?;";
//        String[] whereArgs = {Integer.toString(shopingCart.getId())};
        return db.insert(TABLE_NAME,null, values);
    }

    private int Update(ShopingCart shopingCart){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(name,shopingCart.getName());
        values.put(imageSrc,shopingCart.getImageSrc());
        values.put(price,shopingCart.getPrice());
        values.put(amount,shopingCart.getAmount());
        values.put(description,shopingCart.getDescription());
        String whereClause = id + " = ? ;";
        String[] whereArgs = {Integer.toString(shopingCart.getId())};
        return db.update(TABLE_NAME,values,whereClause,whereArgs);
    }

    public int deleteById(int id ){
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = id + " = ?;";
        String[] whereArgs = {String.valueOf(id)};
        return db.delete(TABLE_NAME,whereClause,whereArgs);
    }
}
