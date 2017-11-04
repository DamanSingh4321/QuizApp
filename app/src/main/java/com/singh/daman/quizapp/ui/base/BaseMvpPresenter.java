package com.singh.daman.quizapp.ui.base;

/**
 * Created by Daman on 11/4/2017.
 */

public interface BaseMvpPresenter<V extends BaseMvpView> {

    void onAttach(V mvpView);

    void onDetach();
}
