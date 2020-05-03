package com.softsquared.ablyeden.src.main.home;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.softsquared.ablyeden.R;
import com.softsquared.ablyeden.src.BaseActivity;

public class DetailItemActivity extends BaseActivity {

    public String productIdx;
    public TextView tvItemDisplayedPrice, tvItemPrice, tvItemMarketName, tvItemName, tvItemDiscount, tvItemPurchaseCount;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);

        Intent intent = getIntent();
        productIdx = intent.getStringExtra("productIdx");

        tvItemPrice = findViewById(R.id.detail_tv_item_price);
        tvItemMarketName = findViewById(R.id.detail_market_tv_name);
        tvItemName = findViewById(R.id.detail_market_tv_name);
        tvItemDiscount = findViewById(R.id.detail_tv_item_discount);
        tvItemDisplayedPrice = findViewById(R.id.detail_tv_displayed_price);


        //레이아웃 수정 후 추가
        //tvItemPurchaseCount = findViewById(R.id.detail_tv_)


        tvItemPrice = findViewById(R.id.detail_tv_item_price);
        tvItemPrice.setPaintFlags(tvItemPrice.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);




    }
}
