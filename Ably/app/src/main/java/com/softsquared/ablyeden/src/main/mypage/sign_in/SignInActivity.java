package com.softsquared.ablyeden.src.main.mypage.sign_in;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.softsquared.ablyeden.R;
import com.softsquared.ablyeden.src.ApplicationClass;
import com.softsquared.ablyeden.src.BaseActivity;
import com.softsquared.ablyeden.src.main.mypage.MyPageFragment;
import com.softsquared.ablyeden.src.main.mypage.sign_in.interfaces.SignInView;
import com.softsquared.ablyeden.src.main.mypage.sign_in.models.SignInDefaultRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.RequestBody;

import static com.softsquared.ablyeden.src.ApplicationClass.MEDIA_TYPE_JSON;

public class SignIn extends BaseActivity implements SignInView {

    private ImageButton mImgBtnUndo;
    private EditText mEtEmail, mEtPassword;
    private Button mBtnSignIn;
    private TextView mTvEmailError;

    private String userType;
    private String userId;
    private String userPassword;
    private boolean check;

    private SignInService mSignInService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page_sign_in);

        mImgBtnUndo = findViewById(R.id.my_page_sign_in_back);
        mBtnSignIn = findViewById(R.id.my_page_sign_in_btn);
        mEtEmail = findViewById(R.id.my_page_email_edit);
        mEtPassword = findViewById(R.id.my_page_password_edit);
        mTvEmailError = findViewById(R.id.my_page_sign_in_error);

        mImgBtnUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userId = mEtEmail.getText().toString();
                userPassword = mEtPassword.getText().toString();

                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("userType", "NORMAL");
                    jsonObject.put("email", userId);
                    jsonObject.put("password", userPassword);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                RequestBody requestBody = RequestBody.create(MEDIA_TYPE_JSON, jsonObject.toString());

                trySignIn(requestBody);
            }
        });
        mEtEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    Pattern pattern = Pattern.compile("^[a-zA-X0-9]@[a-zA-Z0-9].[a-zA-Z0-9]");
                    Matcher matcher = pattern.matcher(mEtEmail.getText());

                    if (!matcher.matches()) {
                        mTvEmailError.setVisibility(View.INVISIBLE);
                    } else {
                        mTvEmailError.setText("잘못된 이메일 형식입니다");
                    }
                }
            }
        });
    }

    private void trySignIn(RequestBody requestBody) {
        showProgressDialog();
        mSignInService.getSignIn(requestBody);
    }


    @Override
    public void validateSuccess(SignD check) {
        hideProgressDialog();
        int code = response.getCode();
        String message = response.getMessage();

        if (code == 100) {
            showCustomToast(message);

            SignInResponse.Result result = response.getResult();
            String userName = result.getUserName();
            String jwt = result.getJwt();
            sSharedPreferences.edit().putString("jwt", jwt);

            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("LOG_IN", true);
            intent.putExtra("NAME", userName);
            startActivity(intent);
            finish();
        }
        else {
            showCustomToast(message);
        }
    }

    @Override
    public void validateFailure(String message) {
        message="fail";
        Log.d("메세지 실패", "메세지 실패");

    }

}
