package com.singh.daman.quizapp.di.module;

import android.app.Activity;
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

    private Activity appCompatActivity;

    public ActivityModule(Activity appCompatActivity){
        this.appCompatActivity = appCompatActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return appCompatActivity;
    }

    @Provides
    Activity provideActivity() {
        return appCompatActivity;
    }

}
