package com.singh.daman.quizapp.ui.main;

import com.singh.daman.quizapp.ui.base.BaseMvpView;

import java.util.List;

/**
 * Created by Daman on 11/4/2017.
 */

public interface MainView extends BaseMvpView{

    void showLoading();

    void loadSuccess(List<?> list);

    void loadFailure(String error);

}
