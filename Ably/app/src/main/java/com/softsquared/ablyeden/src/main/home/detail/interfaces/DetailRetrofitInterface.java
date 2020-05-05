package com.softsquared.ablyeden.src.main.home.interfaces;



import com.softsquared.ablyeden.src.main.home.detail.models.DetailResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DetailRetrofitInterface {

    @GET("/products/{productIdx}")
    Call<DetailResponse> getDetail(
            @Path("productIdx") int productIdx
    );

}
