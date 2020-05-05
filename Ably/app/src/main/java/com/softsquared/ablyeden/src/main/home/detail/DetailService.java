package com.softsquared.ablyeden.src.main.home;

import com.softsquared.ablyeden.src.main.home.interfaces.DetailActivityView;
import com.softsquared.ablyeden.src.main.home.interfaces.DetailRetrofitInterface;
import com.softsquared.ablyeden.src.main.home.models.DetailResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.ablyeden.src.ApplicationClass.getRetrofit;


class DetailService {
    private final DetailActivityView mDetailActivityView;

    DetailService(final DetailActivityView mDetailActivityView) {
        this.mDetailActivityView = mDetailActivityView;
    }

    void getDetail(int productIdx) {
        final DetailRetrofitInterface detailRetrofitInterface = getRetrofit().create(DetailRetrofitInterface.class);
        detailRetrofitInterface.getDetail(productIdx).enqueue(new Callback<DetailResponse>() {
            //비동기 호출. 어떠한 상태일 때 돈다.

            @Override
            public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {
                //response.body로 초기화.
                final DetailResponse detailResponse = response.body();
                if (detailResponse == null) {
                    System.out.println("detailResponse is null");
                    mDetailActivityView.validateFailure(null);
                    return;
                }

                mDetailActivityView.validateSuccess(detailResponse);
            }

            @Override
            public void onFailure(Call<DetailResponse> call, Throwable t) {
                System.out.println("OnFailure");
                mDetailActivityView.validateFailure(null);
            }
        });
    }
}
