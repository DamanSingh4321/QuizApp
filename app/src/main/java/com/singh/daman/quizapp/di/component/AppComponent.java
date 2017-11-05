package com.singh.daman.quizapp.di.component;

import android.app.Application;
import android.content.Context;

import com.singh.daman.quizapp.InitApp;
import com.singh.daman.quizapp.data.DataManager;
import com.singh.daman.quizapp.di.annotations.ApplicationContext;
import com.singh.daman.quizapp.di.module.AppModule;
import com.singh.daman.quizapp.di.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Daman on 11/3/2017.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {

    void inject(InitApp initApp);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();
}
