package com.softsquared.ablyeden.src.main.home.tab_fragment_today;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.ablyeden.R;

class BannerRecyclerViewAdapter extends RecyclerView.Adapter<BannerRecyclerViewAdapter.MyBannerHolder> {

    Context context;

    public BannerRecyclerViewAdapter(Context context) {
        super();
        this.context = context;
    }


    public class MyBannerHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public MyBannerHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.tab_today_recycler_image);
        }
    }

    @NonNull
    @Override
    public MyBannerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tab_today_banner, parent,false);
        return new MyBannerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerRecyclerViewAdapter.MyBannerHolder holder, int position) {
        switch (position){
            case 0:

        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
