package com.softsquared.ablyeden.src.main.mypage;
import com.softsquared.ablyeden.src.main.mypage.interfaces.MyPageRetrofitInterface;
import com.softsquared.ablyeden.src.main.mypage.interfaces.MyPageView;
import com.softsquared.ablyeden.src.main.mypage.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.ablyeden.src.ApplicationClass.getRetrofit;


class MyPageService {
    private final MyPageView myPageView;

    MyPageService(final MyPageView myPageView) {
        this.myPageView = myPageView;
    }

    void getTest() {
        final MyPageRetrofitInterface myPageRetrofitInterface = getRetrofit().create(MyPageRetrofitInterface.class);
        myPageRetrofitInterface.getTest().enqueue(new Callback<DefaultResponse>() {
            //비동기 호출. 어떠한 상태일 때 돈다.

            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                //response.body로 초기화.
                final DefaultResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                    myPageView.validateFailure(null);
                    return;
                }

                myPageView.validateSuccess(defaultResponse.getMessage());
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                myPageView.validateFailure(null);
            }
        });
    }
}
