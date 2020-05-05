package com.softsquared.ablyeden.src.main.home.tab_fragment_today;

public class Banner {

    public int bannerIdx;
    public String bannerUrl;

    public Banner (int bannerIdx, String bannerUrl){
        this.bannerIdx = bannerIdx;
        this.bannerUrl = bannerUrl;
    }

    public int getBannerIdx() {
        return bannerIdx;
    }

    public void setBannerIdx(int bannerIdx) {
        this.bannerIdx = bannerIdx;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }


}
