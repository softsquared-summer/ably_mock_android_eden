package com.softsquared.ablyeden.src.main.home.tab_fragment_today;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.softsquared.ablyeden.R;


import java.util.ArrayList;

public class AutoScrollAdapter extends PagerAdapter {

    Context context;
    ArrayList<String> banner;
    ImageView mIvBanner;
    public AutoScrollAdapter(Context context, ArrayList<String> banner){
        this.context = context;
        this.banner = banner;
    }

    @NonNull
    //position값을 받아 주어진 위치에 페이지 생성
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.today_banner, null);
        mIvBanner = view.findViewById(R.id.image_container);
        Glide.with(context).load(banner.get(position)).into(mIvBanner);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return banner.size();
    }

    //페이지 뷰가 생성된 페이지의 object key와 같은지 확인
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
}
