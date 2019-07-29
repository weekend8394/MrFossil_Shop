package com.example.mrfossil_shop.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.MenuItem;

import com.example.mrfossil_shop.R;
import com.example.mrfossil_shop.fragments.HomeFragment;
import com.example.mrfossil_shop.fragments.NewsFragment;
import com.example.mrfossil_shop.views.BottomNavigationViewExtension;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private BottomNavigationViewExtension navView;
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
                    fragment = new NewsFragment();
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
        navView.setItemIconTintList(null);
//        navView.setItemIconSize(60);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float density = displayMetrics.density;

        navView.enableAnimation(false);
        navView.enableShiftingMode(false);
        navView.enableItemShiftingMode(false);
        navView.setTextSize(10);
        navView.setIconsMarginTop((int) (6 * density));
        navView.setIconSize(20, 20);
        navView.setItemHeight((int) (50 * density));
        navView.setOnNavigationItemSelectedListener(this);
        navView.setSelectedItemId(R.id.navigation_home);

        navView.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.gray_67717b));
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;

            case R.id.navigation_dashboard:
                fragment = new NewsFragment();
                break;
        }
        menuItem.setChecked(true);
        changeFragment(fragment);
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
