package com.softsquared.ablyeden.src.main.models;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DetailResponse {

    public class Result {


        @SerializedName("productIdx")
        private int productIdx;

        @SerializedName("thumbnailUrl")
        private Array thumbnailUrl;

        @SerializedName("discountRatio")
        private String discountRatio;

        @SerializedName("displayedPrice")
        private String displayedPrice;

        @SerializedName("price")
        private String price;

        @SerializedName("productCode")
        private String productCode;

        @SerializedName("contents")
        private String contents;

        @SerializedName("imgUrlList")
        private Array imgUrlList;

        @SerializedName("isMyHeart")
        private String isMyHeart;

        @SerializedName("isHotDeal")
        private String isHotDeal;

        @SerializedName("isNew")
        private String isNew;

        @SerializedName("productName")
        private String productName;

        @SerializedName("purchaseCnt")
        private String purchaseCnt;


    }

    public class MarketInfo {

        @SerializedName("marketIdx")
        private int marketIdx;

        @SerializedName("marketName")
        private String marketName;

        @SerializedName("marketHashTags")
        private String marketHashTags;

        @SerializedName("marketThumbnailUrl")
        private String marketThumbnailUrl;

    }

    @SerializedName("result")
    private ArrayList<Result> result;

    @SerializedName("MarketInfo")
    private ArrayList<MarketInfo> marketInfo;


    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    public ArrayList<Result> getResult() {
        return result;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }
}
