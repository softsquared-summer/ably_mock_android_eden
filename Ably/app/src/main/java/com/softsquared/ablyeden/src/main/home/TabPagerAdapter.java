package com.softsquared.ablyeden.src.main.home;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.softsquared.ablyeden.src.main.home.tab_fragment_hot_deal.TabHotDealFragment;
import com.softsquared.ablyeden.src.main.home.tab_fragment_best.TabBestFragment;
import com.softsquared.ablyeden.src.main.home.tab_fragment_new.TabNewFragment;
import com.softsquared.ablyeden.src.main.home.tab_fragment_today.TabTodayFragment;

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;

    public TabPagerAdapter(@NonNull FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                TabTodayFragment tabTodayFragment = new TabTodayFragment();
                return tabTodayFragment;
            case 1:
                TabNewFragment tabNewFragment = new TabNewFragment();
                return tabNewFragment;

            case 2:
                TabBestFragment tabBestFragment = new TabBestFragment();
                return tabBestFragment;

            case 3:
                TabHotDealFragment tabHotDealFragment = new TabHotDealFragment();
                return tabHotDealFragment;

            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
