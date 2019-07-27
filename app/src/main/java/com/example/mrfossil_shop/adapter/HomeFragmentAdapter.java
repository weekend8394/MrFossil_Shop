package com.example.mrfossil_shop.adapter;
import android.support.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mrfossil_shop.R;
import com.example.mrfossil_shop.model.ShopData;

import java.util.List;

public class HomeFragmentAdapter extends BaseQuickAdapter<Object, BaseViewHolder> {
    public HomeFragmentAdapter( @Nullable List data) {
        super(R.layout.item_home_fragment,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {
        ShopData data = (ShopData) item;
        helper.setText(R.id.title,data.getShopAreaName());
        helper.setText(R.id.tv_address,data.getAddress());
        helper.setText(R.id.tv_phone,data.getPhone());
    }
}
