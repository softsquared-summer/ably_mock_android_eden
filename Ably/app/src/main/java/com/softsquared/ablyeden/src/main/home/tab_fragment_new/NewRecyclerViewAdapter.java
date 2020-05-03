package com.softsquared.ablyeden.src.main.home.tab_fragment_today;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.softsquared.ablyeden.R;

import java.util.ArrayList;

class TodayRecyclerViewAdapter extends RecyclerView.Adapter<TodayRecyclerViewAdapter.RecommendRecyclerViewHolders> {

    private ArrayList<Product> mProductList;
    private Context mContext;
    public static int sCorner = 8;
    public static int sMargin = 0;


    public static class RecommendRecyclerViewHolders extends RecyclerView.ViewHolder {
        public TextView tvItemPrice, tvItemShopName, tvItemExplain, tvItemDiscount, tvItemSales, tvItemHotDeal;
        public ImageView ivItemImg;


        public RecommendRecyclerViewHolders(@NonNull View itemView) {
            super(itemView);
            tvItemPrice = itemView.findViewById(R.id.today_item_price);
            tvItemShopName = itemView.findViewById(R.id.today_shop_name);
            tvItemExplain = itemView.findViewById(R.id.today_item_name_explain);
            tvItemDiscount = itemView.findViewById(R.id.today_item_discount);
            tvItemSales = itemView.findViewById(R.id.today_item_sell);
            tvItemHotDeal = itemView.findViewById(R.id.today_item_hot_deal);
            ivItemImg = itemView.findViewById(R.id.today_item_img);
        }
    }

    public TodayRecyclerViewAdapter(ArrayList<Product> mProductList, Context mContext) {
        this.mContext = mContext;
        this.mProductList = mProductList;
    }


    @NonNull
    @Override
    public RecommendRecyclerViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.today_item, parent, false);
        RecommendRecyclerViewHolders viewHolder = new RecommendRecyclerViewHolders(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendRecyclerViewHolders holder, int position) {
        holder.tvItemPrice.setText(mProductList.get(position).getDisplayedPrice());
        holder.tvItemShopName.setText(mProductList.get(position).getMarketName());
        holder.tvItemExplain.setText(mProductList.get(position).getProductName());
        holder.tvItemDiscount.setText(mProductList.get(position).getDiscountRatio());
        holder.tvItemSales.setText(mProductList.get(position).getPurchaseCnt());

        if (!(mProductList.get(position).getDiscountRatio().equals("0%"))) {
            holder.tvItemDiscount.setText(mProductList.get(position).getPurchaseCnt());
            holder.tvItemDiscount.setVisibility(View.VISIBLE);
        }else{
            holder.tvItemDiscount.setVisibility(View.GONE);
        }

        if (mProductList.get(position).getIsHotDeal().equals("N")) {
            holder.tvItemHotDeal.setVisibility(View.GONE);
        }

        Glide.with(mContext).load(mProductList.get(position).getThumbnailUrl()).bitmapTransform(new RoundedCornersTransformation(mContext,sCorner,sMargin)).into(holder.ivItemImg);
    }



    @Override
    public int getItemCount() {
        return this.mProductList.size();
    }


}
