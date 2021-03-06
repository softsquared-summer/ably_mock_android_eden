package com.softsquared.ablyeden.src.main;


import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;

import com.softsquared.ablyeden.R;
import com.softsquared.ablyeden.src.BaseActivity;
import com.softsquared.ablyeden.src.main.home.HomeFragment;
import com.softsquared.ablyeden.src.main.like.LikeFragment;
import com.softsquared.ablyeden.src.main.market.MarketFragment;
import com.softsquared.ablyeden.src.main.mypage.MyPageFragment;
import com.softsquared.ablyeden.src.main.style.StyleFragment;
import com.softsquared.ablyeden.src.main.interfaces.MainActivityView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends BaseActivity implements MainActivityView {
    //private FragmentManager fragmentManager = getSupportFragmentManager();
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment;
    LikeFragment likeFragment;
    MarketFragment marketFragment;
    MyPageFragment myPageFragment;
    StyleFragment styleFragment;
    RelativeLayout relativeLayout_home, relativeLayout_except;
    TextView mTvTopText;
    ImageButton mBtnCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        //bottomNavigationView.setItemIconTintList(null);

        relativeLayout_except = findViewById(R.id.except_home_search);
        relativeLayout_home = findViewById(R.id.home_search);
        mTvTopText = findViewById(R.id.main_top_text);
        mBtnCategory = findViewById(R.id.btn_main_category);

        //제일 처음 띄워줄 뷰 세팅
        homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, homeFragment).commitAllowingStateLoss();
        //bottom_navigation_view 의 아이콘을 선택 했을때 원하는 프래그먼트가 띄워질 수 있도록 리스너를 추가
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_home: {
                        homeFragment = new HomeFragment();
                        relativeLayout_home.setVisibility(View.VISIBLE);
                        relativeLayout_except.setVisibility(View.INVISIBLE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, homeFragment).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.bottom_style: {
                        styleFragment = new StyleFragment();
                        relativeLayout_except.setVisibility(View.VISIBLE);
                        relativeLayout_home.setVisibility(View.INVISIBLE);
                        mTvTopText.setText("스타일");
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, styleFragment).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.bottom_market: {
                        marketFragment = new MarketFragment();
                        relativeLayout_except.setVisibility(View.VISIBLE);
                        relativeLayout_home.setVisibility(View.INVISIBLE);
                        mTvTopText.setText("마켓");
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, marketFragment).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.bottom_like: {
                        likeFragment = new LikeFragment();
                        relativeLayout_except.setVisibility(View.VISIBLE);
                        relativeLayout_home.setVisibility(View.INVISIBLE);
                        mTvTopText.setText("찜");
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, likeFragment).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.bottom_my_page: {
                        myPageFragment = new MyPageFragment();
                        relativeLayout_except.setVisibility(View.VISIBLE);
                        relativeLayout_home.setVisibility(View.INVISIBLE);
                        mTvTopText.setText("마이페이지");
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, myPageFragment).commitAllowingStateLoss();
                        return true;
                    }

                    default:
                        return false;
                }


            }
        });

    }

    private void tryGetTest() {
        showProgressDialog();
        //통신 시작

        final MainService mainService = new MainService(this);
        //this는 자신을 의미
        //서비스 생성

        mainService.getTest();
    }

    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();
    }

    @Override
    public void validateFailure(@Nullable String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    public void customOnClick(View view) {
//        switch (view.getId()) {
//            case R.id.main_btn_hello_world:
//                tryGetTest();
//                break;
//            default:
//                break;
//        }
    }
}
