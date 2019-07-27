package com.example.mrfossil_shop.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mrfossil_shop.R;
import com.example.mrfossil_shop.model.News;

import java.util.List;

public class NewsFragmentAdapter extends BaseQuickAdapter<Object, BaseViewHolder> {
    public NewsFragmentAdapter(@Nullable List data) {
        super(R.layout.item_news_fragment, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {
        News data = (News)item;
        helper.setImageResource(R.id.iv_headPic,data.getImageRes());
        helper.setText(R.id.title,data.getTitle());
        helper.setText(R.id.tv_description,data.getDescription());
    }
}
