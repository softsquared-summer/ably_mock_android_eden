package com.softsquared.ablyeden.src.main.home.tab_fragment_today.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TabTodayResponse {

    public class Result {


        @SerializedName("productIdx")
        private int productIdx;

        @SerializedName("thumbnailUrl")
        private String thumbnailUrl;

        @SerializedName("discountRatio")
        private String discountRatio;

        @SerializedName("displayedPrice")
        private String displayedPrice;

        @SerializedName("marketIdx")
        private int marketIdx;

        @SerializedName("marketName")
        private String marketName;

        @SerializedName("productName")
        private String productName;

        @SerializedName("purchaseCnt")
        private String purchaseCnt;

        @SerializedName("isMyHeart")
        private String isMyHeart;

        @SerializedName("isHotDeal")
        private String isHotDeal;

        @SerializedName("isNew")
        private String isNew;

        public int getProductIdx() {
            return productIdx;
        }

        public String getThumbnailUrl() {
            return thumbnailUrl;
        }

        public String getDiscountRatio() {
            return discountRatio;
        }

        public String getDisplayedPrice() {
            return displayedPrice;
        }

        public int getMarketIdx() {
            return marketIdx;
        }

        public String getMarketName() {
            return marketName;
        }

        public String getProductName() {
            return productName;
        }

        public String getPurchaseCnt() {
            return purchaseCnt;
        }

        public String getIsMyHeart() {
            return isMyHeart;
        }

        public String getIsHotDeal() {
            return isHotDeal;
        }

        public String getIsNew() {
            return isNew;
        }


    }


    @SerializedName("result")
    private ArrayList<Result> result;


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
