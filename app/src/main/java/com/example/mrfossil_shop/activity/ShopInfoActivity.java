package com.example.mrfossil_shop.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mrfossil_shop.R;
import com.example.mrfossil_shop.adapter.ShopInfoActivityAdapter;
import com.example.mrfossil_shop.model.ShopData;
import com.example.mrfossil_shop.model.ShopProduct;
import com.example.mrfossil_shop.views.DefaultTitleBar;
import com.example.mrfossil_shop.views.TitleBar;

import java.util.ArrayList;
import java.util.List;

public class ShopInfoActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DefaultTitleBar titleBar;
    private ShopData shopData;
    private List<ShopProduct> shopProduct;
    private ShopInfoActivityAdapter shopInfoAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected LayoutManagerType mCurrentLayoutManagerType;

    private boolean linearLayout = true;
    private final int column = 2;
    private final int spacing = 50; // 50px
    private boolean includeEdge = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_info);
        titleBar = findViewById(R.id.titleBar);
        recyclerView = findViewById(R.id.recyclerView);
        initShopData();
        initTitleBar();
        shopProduct = initProjectData();
        initAdapter();
    }

    private void initTitleBar(){
        titleBar.tvTitle.setText(shopData.getShopAreaName());
        titleBar.setTitleBarListener(new TitleBar.TitleBarListener() {
            @Override
            public void onTitleBarClick(View v) {

            }

            @Override
            public void onTitleBarLeftButtonsClick(View v, int position) {
                finish();
            }

            @Override
            public void onTitleBarRightButtonsClick(View v, int position) {
                if(linearLayout){
                    setRecyclerViewLayoutManager(LayoutManagerType.GRID_LAYOUT_MANAGER);
                    linearLayout = false;
                }else{
                    setRecyclerViewLayoutManager(LayoutManagerType.LINEAR_LAYOUT_MANAGER);
                    linearLayout = true;
                }
            }
        });
    }
    private void initHeadView(){

    }

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    private void initShopData(){
        Bundle bundle = getIntent().getExtras();
        shopData = (ShopData) bundle.getSerializable("shopData");
    }

    public List<ShopProduct> initProjectData(){
        List<ShopProduct> shopProducts = new ArrayList<>();
        shopProducts.add(new ShopProduct(R.drawable.light1,"空間藝術品-迅猛龍燈","產品詳情\n" +
                "這恐龍燈是好友易健立設計師堅持多年的夢想,迅猛龍燈優美動態的線條,每個可以轉動的關節,讓迅猛龍活靈活現,\n" +
                "工業設計和古生物最佳的結合,恐龍燈把我沈睡已久的童心都喚了出來,太好玩了.\n" +
                "優質商品,生產的數量不多,請把握！\n" +
                "尺寸：604mm x 458mm x 207mm\n" +
                "材質：鋁合金,塑料\n" +
                "電源：DC12V 1A\n" +
                "照度：1500 Lux(距離照射面40cm)\n" +
                "色溫：2700-4500\n" +
                "台灣製造",3780));
        shopProducts.add(new ShopProduct(R.drawable.orange2,"緬甸琥珀\b-羽毛","產品詳情\n" +
                "當樹脂排出植物體外，便會滴落下來，這個過程中容易黏住蟲子或小動物，當然也包括在樹上休息的鳥，運氣好的留下羽毛，運氣不好的...化石先生絕對好好收藏：）\n" +
                "產地：緬甸\n" +
                "年代：9700萬年前（白堊紀)",76500));
        shopProducts.add(new ShopProduct(R.drawable.orange3,
                "緬甸琥珀-羽毛","產品詳情\n" +
                "當樹脂排出植物體外，便會滴落下來，這個過程中容易黏住蟲子或小動物，當然也包括在樹上休息的鳥，運氣好的留下羽毛，運氣不好的...化石先生絕對好好收藏：）\n" +
                "產地：緬甸\n" +
                "年代：9700萬年前（白堊紀)",9200));
        shopProducts.add(new ShopProduct(R.drawable.orange6,"甲龍背甲","產品詳情\n" +
                "這是一件白堊紀晚期，稀有的北美甲龍裝甲上的甲板，出土自蒙大拿州\n" +
                "當時這隻甲龍被沖刷到河床裡，牠的實心甲板卡在礫石堆裏，一起埋藏膠結，像件藝術品般的保存下來。\n" +
                "甲龍是白堊紀最晚期的恐龍，搞不好牠見過當時隕石撞地球後的白堊紀末日。",96000));
        shopProducts.add(new ShopProduct(R.drawable.orange5,"寶石手環系列-天然蜜蠟手環","Mr.Fossil ｜信義店5F｜寶石手環系列-天然蜜蠟手環｜售價3860｜\n" +
                "天然生成的亮黃色蜜蠟能突顯氣質的高雅，墨綠和田碧玉顯得低調而不凡，\n" +
                "透亮的白玉掛墜更象徵純潔的妳，來自亙古的美，值得妳我永恆的愛。",3860));
        return shopProducts;
    }
    private void initAdapter(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,column);
        recyclerView.setLayoutManager(gridLayoutManager);
        setRecyclerViewLayoutManager(LayoutManagerType.LINEAR_LAYOUT_MANAGER);
        shopInfoAdapter = new ShopInfoActivityAdapter(shopProduct);
        shopInfoAdapter.setOnItemClickListener(mItemClickListener);
        recyclerView.setAdapter(shopInfoAdapter);
    }

    private BaseQuickAdapter.OnItemClickListener mItemClickListener = (adapter, view, position) -> {
        Intent intent = new Intent(this, ProductInfo.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("shopProduct",shopProduct.get(position));
        intent.putExtras(bundle);
        this.startActivity(intent);
    };


    public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;
        // If a layout manager has already been set, get current scroll position.
        if (recyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) recyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
            // 獲取當前第一個可見Item的position
        }

        switch (layoutManagerType) {
            case GRID_LAYOUT_MANAGER:
                mLayoutManager = new GridLayoutManager(ShopInfoActivity.this, column);
                mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
                break;
            case LINEAR_LAYOUT_MANAGER:
                mLayoutManager = new LinearLayoutManager(ShopInfoActivity.this);
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                break;
            default:
                mLayoutManager = new LinearLayoutManager(ShopInfoActivity.this);
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        }
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.scrollToPosition(scrollPosition);
    }
}