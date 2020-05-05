package com.softsquared.ablyeden.src.main.home.interfaces;

import com.softsquared.ablyeden.src.main.home.detail.models.DetailResponse;

public interface DetailActivityView {

    void validateSuccess(DetailResponse detailResponse);

    void validateFailure(String message);

}
