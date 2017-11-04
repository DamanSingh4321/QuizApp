package com.singh.daman.quizapp.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.singh.daman.quizapp.di.annotations.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Daman on 11/4/2017.
 */

@Module
public class ActivityModule {

    private AppCompatActivity appCompatActivity;

    public ActivityModule(AppCompatActivity appCompatActivity){
        this.appCompatActivity = appCompatActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return appCompatActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return appCompatActivity;
    }

}
