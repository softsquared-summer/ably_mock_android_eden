package com.example.ably_eden.src;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ably_eden.R;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {
    public ProgressDialog mProgressDialog;

    //토스트 메시지 띄우기
    public void showCustomToast(final String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    //로딩화면 띄우기
    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgressDialog();
    }
}

