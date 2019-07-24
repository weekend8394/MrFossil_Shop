package com.example.mrfossil_shop.adapter;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mrfossil_shop.R;

import java.util.List;

public class HomeFragmentAdapter extends BaseQuickAdapter<Object, BaseViewHolder> {
    public HomeFragmentAdapter( @Nullable List data) {
        super(R.layout.item_home_fragment,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {
        String data = (String) item;
        helper.setText(R.id.title,data);
        GradientDrawable gd = (GradientDrawable) helper.getView(R.id.constraintLayout).getBackground();
    }
}
