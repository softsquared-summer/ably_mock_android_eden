package com.softsquared.ablyeden.src.main.home.tab_fragment_today.interfaces;



import com.softsquared.ablyeden.src.main.home.tab_fragment_today.models.BannerResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BannerRetrofitInterface {

    @GET("/banner")
    Call<BannerResponse> getRecommend();
    //리스폰스 타입을 알려준다.

}
