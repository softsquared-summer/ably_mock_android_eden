package com.softsquared.ablyeden.src.main.home.models;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DetailResponse {


    public class Result {

        @SerializedName("productIdx")
        private int productIdx;

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

        @SerializedName("productName")
        private String productName;

        @SerializedName("purchaseCnt")
        private String purchaseCnt;

        @SerializedName("marketIdx")
        private int marketIdx;

        @SerializedName("marketName")
        private String marketName;

        @SerializedName("marketHashTags")
        private String marketHashTags;

        @SerializedName("marketThumbnailUrl")
        private String marketThumbnailUrl;

        @SerializedName("normalImgUrlList")
        private String normalImgUrlList;

        @SerializedName("mainImgUrlList")
        private String mainImgUrlList;

        public String getMainImgUrlList() {
            return mainImgUrlList;
        }

        public int getProductIdx() {
            return productIdx;
        }

        public String getDiscountRatio() {
            return discountRatio;
        }

        public String getDisplayedPrice() {
            return displayedPrice;
        }

        public String getPrice() {
            return price;
        }

        public String getProductCode() {
            return productCode;
        }

        public String getContents() {
            return contents;
        }

        public Array getImgUrlList() {
            return imgUrlList;
        }

        public String getIsMyHeart() {
            return isMyHeart;
        }


        public String getProductName() {
            return productName;
        }

        public String getPurchaseCnt() {
            return purchaseCnt;
        }

        public int getMarketIdx() {
            return marketIdx;
        }

        public String getMarketName() {
            return marketName;
        }

        public String getMarketHashTags() {
            return marketHashTags;
        }

        public String getMarketThumbnailUrl() {
            return marketThumbnailUrl;
        }
    }


    @SerializedName("result")
    private Result result;


    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    public Result getResult() {
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
