package com.example.mrfossil_shop.views.footer;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;

import butterknife.ButterKnife;

public abstract class BaseFooter {

    public BaseFooter(Context context) {
        contentView = LayoutInflater.from(context)
                .inflate(getLayoutRes(), null, false);

        ButterKnife.bind(this, contentView);

        onCreateView(context);
    }

    abstract @LayoutRes
    int getLayoutRes();

    abstract void onCreateView(Context context);

    protected View contentView;

    public View getContentView() {
        return contentView;
    }
}
