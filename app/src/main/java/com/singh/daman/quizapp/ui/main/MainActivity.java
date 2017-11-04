package com.singh.daman.quizapp.ui.main;

import android.os.Bundle;

import com.singh.daman.quizapp.R;
import com.singh.daman.quizapp.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public boolean isNetworkAvailable() {
        return false;
    }
}
