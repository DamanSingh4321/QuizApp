package com.singh.daman.quizapp.di.module;

import android.app.Application;
import android.content.Context;

import com.singh.daman.quizapp.di.annotations.ApplicationContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Daman on 11/3/2017.
 */

@Module
public class AppModule {

    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }
}
