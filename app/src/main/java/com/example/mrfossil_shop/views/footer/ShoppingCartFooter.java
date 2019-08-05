package com.example.mrfossil_shop.views.footer;

import android.content.Context;
import android.widget.TextView;

import com.example.mrfossil_shop.R;

import butterknife.BindView;

public class ShoppingCartFooter extends BaseFooter {
    @BindView(R.id.tv_TotalMoney)
    TextView totalMoney;

    public ShoppingCartFooter(Context context) {
        super(context);
    }

    @Override
    int getLayoutRes() {
        return R.layout.footer_shoppingcart;

    }

    @Override
    void onCreateView(Context context) {
    }

    public TextView getTotalMoney(){
        return totalMoney;
    }
}
