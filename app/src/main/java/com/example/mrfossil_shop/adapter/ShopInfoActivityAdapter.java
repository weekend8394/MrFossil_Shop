package com.example.mrfossil_shop.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mrfossil_shop.R;
import com.example.mrfossil_shop.model.ShopProduct;

import java.util.List;

public class ShopInfoActivityAdapter extends BaseQuickAdapter<Object, BaseViewHolder> {
    public ShopInfoActivityAdapter(@Nullable List data) {
        super(R.layout.item_shop_product, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {
        ShopProduct data = (ShopProduct) item;
        helper.setImageResource(R.id.iv_headPic,data.getImageRes());
        helper.setText(R.id.title,data.getProductName());
        helper.setText(R.id.tv_price,"NT" + data.getPrice() + "元");
    }
}
