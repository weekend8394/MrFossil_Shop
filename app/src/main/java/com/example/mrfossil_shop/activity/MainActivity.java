package com.example.mrfossil_shop.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.example.mrfossil_shop.R;
import com.example.mrfossil_shop.fragments.HomeFragment;
import com.example.mrfossil_shop.fragments.ShopFragment;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView navView;
    private Fragment fragment = new Fragment();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    break;

                case R.id.navigation_dashboard:
                    fragment = new ShopFragment();
                    break;
            }
            item.setChecked(true);
            changeFragment(fragment);
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initContent();
    }

    private void initContent() {
        //設定預選的選項
        navView.setSelectedItemId(R.id.navigation_home);
    }
    
    private void changeFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.commit();
    }
}
