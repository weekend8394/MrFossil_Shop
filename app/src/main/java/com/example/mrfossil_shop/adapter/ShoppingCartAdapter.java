package com.example.mrfossil_shop.adapter;

import android.support.annotation.Nullable;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mrfossil_shop.R;
import com.example.mrfossil_shop.model.ShopingCart;

import java.util.List;

public class ShoppingCartAdapter extends BaseQuickAdapter<ShopingCart, BaseViewHolder> {
    public ShoppingCartAdapter(@Nullable List data) {
        super(R.layout.item_shopping_cart,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopingCart item) {
        helper.setImageResource(R.id.iv_HeadImage,item.getImageSrc());
        helper.setText(R.id.tv_ProductName," 名稱 : " + item.getName());
        helper.setText(R.id.tv_counter,"數量 : " + item.getAmount() + "個");
        helper.setText(R.id.tv_money,"單價 : " + item.getPrice() + "元");
        int smallTotal = (item.getPrice()) * (item.getAmount());
        helper.setText(R.id.tv_smallTotal,"小計 : " + smallTotal + "元");
        Log.d("TAG","照片id : " + item.getImageSrc() + "名稱 : "+ item.getName() + "數量 : " + item.getAmount() +  "單價 : " + item.getPrice() +  "小計 : " +  smallTotal);
    }
}
