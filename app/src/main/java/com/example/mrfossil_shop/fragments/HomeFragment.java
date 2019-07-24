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
import com.example.mrfossil_shop.adapter.HomeFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<String> test = new ArrayList<>();
    private HomeFragmentAdapter homeFragmentAdapter;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initAdapter();
    }

    private void initData() {
        test.add(0,"台北店");
        test.add(1,"新竹店");
        test.add(2,"台中店");
        test.add(3,"北橫店");
    }

    private void initAdapter() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        homeFragmentAdapter = new HomeFragmentAdapter(test);
        recyclerView.setAdapter(homeFragmentAdapter);
    }
}
