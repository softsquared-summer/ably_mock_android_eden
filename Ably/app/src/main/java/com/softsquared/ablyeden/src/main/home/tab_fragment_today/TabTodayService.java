package com.softsquared.ablyeden.src.main.home.tab_fragment_today;

import com.softsquared.ablyeden.src.main.home.tab_fragment_today.interfaces.TabTodayActivityView;
import com.softsquared.ablyeden.src.main.home.tab_fragment_today.interfaces.TabTodayRetrofitInterface;
import com.softsquared.ablyeden.src.main.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.ablyeden.src.ApplicationClass.getRetrofit;


class TabTodayService {
    private final TabTodayActivityView mTodayActivityView;

    TabTodayService(final TabTodayActivityView mTodayActivityView) {
        this.mTodayActivityView = mTodayActivityView;
    }

    void getTest() {
        final TabTodayRetrofitInterface todayRetrofitInterface = getRetrofit().create(TabTodayRetrofitInterface.class);
        todayRetrofitInterface.getTest().enqueue(new Callback<DefaultResponse>() {
            //비동기 호출. 어떠한 상태일 때 돈다.

            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                //response.body로 초기화.
                final DefaultResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                    mTodayActivityView.validateFailure(null);
                    return;
                }

                mTodayActivityView.validateSuccess(defaultResponse.getMessage());
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                mTodayActivityView.validateFailure(null);
            }
        });
    }
}
