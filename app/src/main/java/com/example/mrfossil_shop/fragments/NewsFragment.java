package com.example.mrfossil_shop.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mrfossil_shop.R;
import com.example.mrfossil_shop.adapter.NewsFragmentAdapter;
import com.example.mrfossil_shop.model.News;
import com.example.mrfossil_shop.views.DefaultTitleBar;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {
    private DefaultTitleBar titleBar;
    private RecyclerView mRecyclerView;
    private NewsFragmentAdapter newsAdapter;
    private List<News> newsList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_fragment, container, false);
        titleBar = view.findViewById(R.id.titleBar);
        mRecyclerView = view.findViewById(R.id.recyclerView);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initTitleBar();
        newsList = getNewsList();
        initAdapter();
    }

    private void initTitleBar(){
        titleBar.tvTitle.setText("最新消息");
    }

    public List<News> getNewsList(){
        List<News> newsList = new ArrayList<>();
        newsList.add(new News(R.drawable.newspic1,"綠世界店開幕!!！","Mr. fossil 冰果室烤肉吧，綠世界店開幕，歡迎大家來玩！"));
        newsList.add(new News(R.drawable.newspic1,"綠世界店開幕!!！","Mr. fossil 冰果室烤肉吧，綠世界店開幕，歡迎大家來玩！"));
        newsList.add(new News(R.drawable.newspic1,"綠世界店開幕!!！","Mr. fossil 冰果室烤肉吧，綠世界店開幕，歡迎大家來玩！"));
        newsList.add(new News(R.drawable.newspic1,"綠世界店開幕!!！","Mr. fossil 冰果室烤肉吧，綠世界店開幕，歡迎大家來玩！"));
        newsList.add(new News(R.drawable.newspic1,"綠世界店開幕!!！","Mr. fossil 冰果室烤肉吧，綠世界店開幕，歡迎大家來玩！"));
        newsList.add(new News(R.drawable.newspic1,"綠世界店開幕!!！","Mr. fossil 冰果室烤肉吧，綠世界店開幕，歡迎大家來玩！"));
    return newsList;
    }

    private void initAdapter(){
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        newsAdapter = new NewsFragmentAdapter(newsList);
        mRecyclerView.setAdapter(newsAdapter);
    }
}
