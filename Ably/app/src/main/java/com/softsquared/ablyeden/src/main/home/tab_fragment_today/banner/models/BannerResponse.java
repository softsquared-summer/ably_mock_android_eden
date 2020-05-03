package com.softsquared.ablyeden.src.main.home.tab_fragment_today.models;

import com.google.gson.annotations.SerializedName;

class BannerResponse {

    public class Result {
        @SerializedName("bannerIdx")
        private int bannerIdx;

        @SerializedName("bannerName")
        private String bannerName;

        @SerializedName("discountRatio")
        private String discountRatio;

    }
}
