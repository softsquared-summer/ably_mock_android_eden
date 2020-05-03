package com.softsquared.ablyeden.src.main.home.tab_fragment_today;

import com.softsquared.ablyeden.src.main.home.tab_fragment_today.interfaces.TabTodayFragmentView;
import com.softsquared.ablyeden.src.main.home.tab_fragment_today.interfaces.TabTodayRetrofitInterface;
import com.softsquared.ablyeden.src.main.home.tab_fragment_today.models.TabTodayResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.ablyeden.src.ApplicationClass.getRetrofit;


class TabTodayService {
    private final TabTodayFragmentView mTodayActivityView;

    TabTodayService(final TabTodayFragmentView mTodayActivityView) {
        this.mTodayActivityView = mTodayActivityView;
    }

    void getRecommendProduct() {
        final TabTodayRetrofitInterface todayRetrofitInterface = getRetrofit().create(TabTodayRetrofitInterface.class);
        todayRetrofitInterface.getRecommend().enqueue(new Callback<TabTodayResponse>() {
            //비동기 호출. 어떠한 상태일 때 돈다.

            @Override
            public void onResponse(Call<TabTodayResponse> call, Response<TabTodayResponse> response) {
                //response.body로 초기화.
                final TabTodayResponse tabTodayResponse = response.body();
                if (tabTodayResponse == null) {
                    mTodayActivityView.validateFailure(null);
                    return;
                }

                mTodayActivityView.validateSuccess(tabTodayResponse);
            }

            @Override
            public void onFailure(Call<TabTodayResponse> call, Throwable t) {
                mTodayActivityView.validateFailure(null);
            }
        });
    }
}
