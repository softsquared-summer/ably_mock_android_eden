package com.softsquared.ablyeden.src.main.home;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.softsquared.ablyeden.R;
import com.softsquared.ablyeden.src.BaseActivity;
import com.softsquared.ablyeden.src.main.home.interfaces.DetailActivityView;
import com.softsquared.ablyeden.src.main.home.models.DetailResponse;

public class DetailItemActivity extends BaseActivity implements DetailActivityView {

    public int productIdx;
    public TextView tvItemDisplayedPrice, tvItemPrice, tvMarketName, tvItemName, tvItemDiscountRatio, tvMarketHashTag, tvProductCode;
    public ImageView ivMarketThumbnail;
    private DetailService mDetailService;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);

        mDetailService = new DetailService(this);


        tvItemPrice = findViewById(R.id.detail_tv_item_price);
        tvMarketName = findViewById(R.id.detail_market_tv_name);
        tvItemName = findViewById(R.id.detail_market_tv_name);
        tvItemDiscountRatio = findViewById(R.id.detail_tv_item_discountRatio);
        tvItemDisplayedPrice = findViewById(R.id.detail_tv_displayed_price);
        tvProductCode = findViewById(R.id.detail_tv_item_code);

        tvMarketName = findViewById(R.id.detail_market_tv_name);
        tvMarketHashTag = findViewById(R.id.detail_market_tv_tag);
        ivMarketThumbnail = findViewById(R.id.detail_market_img);

        mTabLayout = findViewById(R.id.detail_tabLayout);



        Intent intent = getIntent();
        productIdx = intent.getIntExtra("productIdx",0);

        mDetailService.getDetail(productIdx);

        //레이아웃 수정 후 추가
        //tvItemPurchaseCount = findViewById(R.id.detail_tv_)


        tvItemPrice = findViewById(R.id.detail_tv_item_price);
        tvItemPrice.setPaintFlags(tvItemPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

    }

    @Override
    public void validateSuccess(DetailResponse detailResponse) {

        hideProgressDialog();

        int code = detailResponse.getCode();

        System.out.println("validateSuccess");
        if (code == 100) {


            int productIdx = detailResponse.getResult().getProductIdx();
            String productName = detailResponse.getResult().getProductName();
            String discountRatio = detailResponse.getResult().getDiscountRatio();
            String displayedPrice = detailResponse.getResult().getDisplayedPrice();
            String price = detailResponse.getResult().getPrice();
            String productCode = detailResponse.getResult().getProductCode();
            //String contents = detailResponse.getResult().getContents();
            String isMyHeart = detailResponse.getResult().getIsMyHeart();

            int marketIdx = detailResponse.getResult().getMarketIdx();
            String marketName = detailResponse.getResult().getMarketName();
            String marketHashTags = detailResponse.getResult().getMarketHashTags();
            String marketThumbnailUrl = detailResponse.getResult().getMarketThumbnailUrl();
            //ArrayList<> mainImgUrlList = detailResponse.getResult().getMainImgUrlList();
            //ArrayList<> normalImgUrlList = detailResponse.getResult().getNormalImgUrlList();

            tvItemName.setText(productName);
            tvItemDiscountRatio.setText(discountRatio);
            tvItemDisplayedPrice.setText(displayedPrice);
            tvItemPrice.setText(price);
            tvProductCode.setText(productCode);
            tvMarketName.setText(marketName);
            tvMarketHashTag.setText(marketHashTags);
            Glide.with(this).load(marketThumbnailUrl).fitCenter().into(ivMarketThumbnail);

        }
    }

    @Override
    public void validateFailure(String message) {
        System.out.println("validateFailure");
    }
}
