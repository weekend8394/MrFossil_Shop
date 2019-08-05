package com.example.mrfossil_shop.activity;

import android.graphics.Canvas;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;

import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.example.mrfossil_shop.R;
import com.example.mrfossil_shop.adapter.ShoppingCartAdapter;
import com.example.mrfossil_shop.db.ShoppingCartDBHelper;
import com.example.mrfossil_shop.model.ShopingCart;
import com.example.mrfossil_shop.views.footer.ShoppingCartFooter;

import java.util.List;

public class ShoppingCartActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ShoppingCartAdapter mAdapter;
    private ShoppingCartDBHelper shoppingCartDBHelper;
    private int mPos;
    private ShoppingCartFooter shoppingCartFooter;
    private List<ShopingCart> shopingCartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        recyclerView = findViewById(R.id.recycler_view);
        shoppingCartDBHelper = new ShoppingCartDBHelper(this);
        initAdapter();
        initData();

    }

    private void initData() {
    }


    private List<ShopingCart> getShopingCartList() {
        return shoppingCartDBHelper.getShopingCartList();
    }

    /**
     *設置滑動方向，拖曳方向
     * itemDragAndSwipeCallback.setSwipeMoveFlags(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.UP | ItemTouchHelper.DOWN);
     * */
    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        shopingCartList = getShopingCartList();
        if (shopingCartList != null && shopingCartList.size() > 0) {
            mAdapter = new ShoppingCartAdapter(shopingCartList);
            ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(mAdapter);
            itemDragAndSwipeCallback.setSwipeMoveFlags(ItemTouchHelper.LEFT);
            ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
            itemTouchHelper.attachToRecyclerView(recyclerView);
            mAdapter.enableSwipeItem();
            mAdapter.setOnItemSwipeListener(new OnItemSwipeListener() {
                //開始滑動
                @Override
                public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {
                    mPos = pos;

                }

                //手離開螢幕時回調,如果被刪除pos會回調-1
                @Override
                public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {
                    if(pos >= 1){
                    }
                }

                //滑動刪除後
                @Override
                public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {
                    mAdapter.notifyDataSetChanged();
                    initFooter();
                    mAdapter.setFooterView(shoppingCartFooter.getContentView());
                    if(mAdapter.getItemCount() == 1 ){
                        Toast.makeText(ShoppingCartActivity.this, "您的購物車是空的唷!!", Toast.LENGTH_SHORT).show();
                        mAdapter.removeFooterView(shoppingCartFooter.getContentView());
                    }
                }

                @Override
                public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float dX, float dY, boolean isCurrentlyActive) {
                    canvas.drawColor(ContextCompat.getColor(ShoppingCartActivity.this, R.color.gray_67717b));

                    //偵測螢幕寬度
                    DisplayMetrics metrics = new DisplayMetrics();
                    getWindowManager().getDefaultDisplay().getMetrics(metrics);
                    Log.d("123456","metrics.widthPixels : " + -(metrics.widthPixels));

                    if(dX == -340.0){
                        Log.d("123456","dX : " + -(((metrics.widthPixels) * 0.3)));
                        mAdapter.disableSwipeItem();
                        Toast.makeText(ShoppingCartActivity.this, "" + ((metrics.widthPixels) * 0.3) , Toast.LENGTH_SHORT).show();
                    }

//                  滑到左側螢幕底 刪除
                    if(dX == -(metrics.widthPixels)){
                        shoppingCartDBHelper.deleteById(mAdapter.getItem(mPos).getId());
                    }
                }
            });
            initFooter();
            mAdapter.addFooterView(shoppingCartFooter.getContentView());
            recyclerView.setAdapter(mAdapter);
        } else {
            Toast.makeText(this, "您的購物車是空的唷!!", Toast.LENGTH_SHORT).show();
        }
    }

    private void initFooter(){
        shoppingCartFooter = new ShoppingCartFooter(ShoppingCartActivity.this);
        int price = 0;
        for(int i = 0; i < shopingCartList.size(); i++){
            price = price + (shopingCartList.get(i).getAmount())*(shopingCartList.get(i).getPrice());
        }
        shoppingCartFooter.getTotalMoney().setText(String.valueOf(price));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(shoppingCartDBHelper != null){
            shoppingCartDBHelper.close();
        }
    }
}
