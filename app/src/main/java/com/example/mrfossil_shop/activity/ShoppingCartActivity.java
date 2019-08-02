package com.example.mrfossil_shop.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.mrfossil_shop.R;
import com.example.mrfossil_shop.adapter.ShoppingCartAdapter;
import com.example.mrfossil_shop.db.ShoppingCartDBHelper;
import com.example.mrfossil_shop.model.ShopingCart;

import java.util.List;

public class ShoppingCartActivity extends AppCompatActivity {
    private ShopingCart shopingCart;
    private RecyclerView recyclerView;
    private ShoppingCartAdapter mAdapter;
    private ShoppingCartDBHelper shoppingCartDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        recyclerView = findViewById(R.id.recycler_view);
        shoppingCartDBHelper = new ShoppingCartDBHelper(this);
        initData();
    }

    private void initData(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        List<ShopingCart> shopingCartList = getShopingCartList();
        if(shopingCartList != null && shopingCartList.size() > 0){
            mAdapter = new ShoppingCartAdapter(shopingCartList);
            recyclerView.setAdapter(mAdapter);
        }else{
            Toast.makeText(this,"您的購物車是空的唷!!",Toast.LENGTH_SHORT).show();
        }
    }

    private List<ShopingCart> getShopingCartList(){
        return shoppingCartDBHelper.getShopingCartList();
    }
}
