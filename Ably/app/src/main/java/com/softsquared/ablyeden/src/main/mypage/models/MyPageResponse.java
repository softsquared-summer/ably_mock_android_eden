package com.softsquared.ablyeden.src.main.mypage.models;

import com.google.gson.annotations.SerializedName;

public class DefaultResponse {
    @SerializedName("result")
    private int result;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("code")
    private int code;

    public int getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public int getCode(){
        return code;
    }
}
