package com.softsquared.ablyeden.src.main.home.tab_fragment_today.interfaces;



import com.softsquared.ablyeden.src.main.home.tab_fragment_today.models.TabTodayResponse;
import com.softsquared.ablyeden.src.main.models.DefaultResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TabTodayRetrofitInterface {

    @GET("/recommended-products")
    Call<TabTodayResponse> getRecommend();
    //리스폰스 타입을 알려준다.

    @GET("/test/{number}")
    Call<TabTodayResponse> getTestPathAndQuery(
            @Path("number") int number,
            @Query("content") final String content
    );

}
