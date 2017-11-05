package com.singh.daman.quizapp.ui.main;

import com.singh.daman.quizapp.di.annotations.PerActivity;
import com.singh.daman.quizapp.ui.base.BaseMvpPresenter;

/**
 * Created by Daman on 11/4/2017.
 */

@PerActivity
public interface MainPresenter<V extends  MainView> extends BaseMvpPresenter<V>{

    void getQuizData(int page, int limit);

}
