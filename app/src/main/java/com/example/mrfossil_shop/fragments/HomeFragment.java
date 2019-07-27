package com.example.mrfossil_shop.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mrfossil_shop.R;
import com.example.mrfossil_shop.activity.ShopInfoActivity;
import com.example.mrfossil_shop.adapter.HomeFragmentAdapter;
import com.example.mrfossil_shop.model.ShopData;
import com.example.mrfossil_shop.utils.MyImageLoader;
import com.example.mrfossil_shop.views.DefaultTitleBar;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment{
    private RecyclerView mRecyclerView;
    private HomeFragmentAdapter homeFragmentAdapter;
    private Banner banner;
    private List<ShopData> test;
    private DefaultTitleBar titleBar;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        banner = view.findViewById(R.id.bv_Banner);
        titleBar = view.findViewById(R.id.titleBar);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initTitleBar();
        initBanner();
        test = initData();
        initAdapter();
    }

    @Override
    public void onStart() {
        super.onStart();
        if(banner != null){
            banner.startAutoPlay();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }

    private void initTitleBar(){
        titleBar.tvTitle.setText("Mr.Fossil");
    }

    private void initBanner(){
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.banner1);
        list.add(R.drawable.banner2);
        list.add(R.drawable.banner3);

        banner.setDelayTime(3000)
                .setBannerAnimation(Transformer.ZoomOutSlide)
                .setImages(list)
                .setImageLoader(new MyImageLoader())
                .start();
    }

    public List<ShopData> initData() {
        List<ShopData> shopNames = new ArrayList<>();
        shopNames.add(new ShopData("台北信義店","台北市信義區松高路11號","02-2271-1023"));
        shopNames.add(new ShopData("新竹綠世界","新竹縣北埔鄉大湖村7鄰20號","0918683836"));
        shopNames.add(new ShopData("台北信義店","台北市信義區松高路11號","02-2271-1023"));
        shopNames.add(new ShopData("新竹綠世界","新竹縣北埔鄉大湖村7鄰20號","0918683836"));
        shopNames.add(new ShopData("台北信義店","台北市信義區松高路11號","02-2271-1023"));
        shopNames.add(new ShopData("新竹綠世界","新竹縣北埔鄉大湖村7鄰20號","0918683836"));
        return  shopNames;
    }

    private BaseQuickAdapter.OnItemClickListener mItemClickListener = (adapter, view, position) -> {

        Intent intent = new Intent(getActivity(), ShopInfoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("shopData",test.get(position));
        intent.putExtras(bundle);
        getActivity().startActivity(intent);

    };

    private void initAdapter() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        homeFragmentAdapter = new HomeFragmentAdapter(test);
        homeFragmentAdapter.setOnItemClickListener(mItemClickListener);
        mRecyclerView.setAdapter(homeFragmentAdapter);
    }
}