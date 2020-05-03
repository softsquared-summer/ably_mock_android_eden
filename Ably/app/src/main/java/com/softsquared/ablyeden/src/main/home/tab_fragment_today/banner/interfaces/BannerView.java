package com.softsquared.ablyeden.src.main.home.tab_fragment_today.interfaces;

import com.softsquared.ablyeden.src.main.home.tab_fragment_today.models.TabTodayResponse;

public interface TabTodayFragmentView {

    void validateSuccess(TabTodayResponse tabTodayResponse);

    void validateFailure(String message);

}
