package com.singh.daman.quizapp;

import android.app.Application;
import android.content.Context;

import com.singh.daman.quizapp.di.component.AppComponent;
import com.singh.daman.quizapp.di.component.DaggerAppComponent;
import com.singh.daman.quizapp.di.module.AppModule;
import com.singh.daman.quizapp.di.module.NetModule;

/**
 * Created by Daman on 11/3/2017.
 */

public class InitApp extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
    }

    public AppComponent getComponent(){
        return appComponent;
    }
}
