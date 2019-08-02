package com.example.mrfossil_shop.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrfossil_shop.R;
import com.example.mrfossil_shop.model.ShopProduct;
import com.example.mrfossil_shop.model.ShopingCart;
import com.example.mrfossil_shop.views.AddshoppingCartDialog;
import com.example.mrfossil_shop.views.DefaultTitleBar;
import com.example.mrfossil_shop.views.TitleBar;

public class ProductInfo extends AppCompatActivity {
    private ShopProduct shopProduct;
    private DefaultTitleBar titleBar;
    private ImageView imageView;
    private TextView tvPrice,tvProductName,tvDescription;
    private Button btBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);
        titleBar = findViewById(R.id.titleBar);
        imageView = findViewById(R.id.imageView);
        tvPrice = findViewById(R.id.tv_Price);
        tvProductName = findViewById(R.id.tv_Product_Name);
        tvDescription = findViewById(R.id.tv_Description);
        btBuy = findViewById(R.id.bt_Buy);

        initShopData();
        initTitleBar();

        btBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AddshoppingCartDialog(ProductInfo.this,shopProduct)
                        .show();
            }
        });
    }


    private void initShopData(){
        Bundle bundle = getIntent().getExtras();
        shopProduct = (ShopProduct) bundle.getSerializable("shopProduct");
        imageView.setImageResource(shopProduct.getImageRes());
        tvPrice.setText("$ " + shopProduct.getPrice() + " 元");
        tvProductName.setText(shopProduct.getProductName());
        tvDescription.setText(shopProduct.getProductDescription());
    }

    private void initTitleBar(){
        titleBar.tvTitle.setText(shopProduct.getProductName());
        titleBar.setTitleBarListener(new TitleBar.TitleBarListener() {
            @Override
            public void onTitleBarClick(View v) { }

            @Override
            public void onTitleBarLeftButtonsClick(View v, int position) {
                finish();
            }

            @Override
            public void onTitleBarRightButtonsClick(View v, int position) {
                Intent intent = new Intent(ProductInfo.this, ShoppingCartActivity.class);
                startActivity(intent);
            }
        });
    }
}
