package com.singh.daman.quizapp.ui.main;

import android.os.Bundle;

import com.singh.daman.quizapp.R;
import com.singh.daman.quizapp.ui.base.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainView{

    @Inject
    MainPresenterImpl<MainView> presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setContentView(R.layout.activity_main);
        presenter.onAttach(this);

        presenter.getQuizData(0, 10);

    }

}
