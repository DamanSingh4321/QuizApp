package com.singh.daman.quizapp.ui.base;

/**
 * Created by Daman on 11/3/2017.
 */

public interface BaseMvpView {

    void showError(String error);

    void showLoading();

    void hideLoading();

    boolean isNetworkAvailable();
}
