package com.example.ably_eden.src.main;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.ably_eden.R;
import com.example.ably_eden.src.BaseActivity;
import com.example.ably_eden.src.main.interfaces.MainActivityView;

public class MainActivity extends BaseActivity implements MainActivityView {
    private TextView mTvHelloWorld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void tryGetTest() {
        showProgressDialog();
        //통신 시작

        final MainService mainService = new MainService(this);
        //this는 자신을 의미
        //서비스 생성

        mainService.getTest();
    }

    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();
        mTvHelloWorld.setText(text);
    }

    @Override
    public void validateFailure(@Nullable String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    public void customOnClick(View view) {
//        switch (view.getId()) {
//            case R.id.main_btn_hello_world:
//                tryGetTest();
//                break;
//            default:
//                break;
//        }
    }
}
