package com.singh.daman.quizapp.di.module;

import android.content.Context;

import dagger.Module;

/**
 * Created by Daman on 11/3/2017.
 */

@Module
public class NetModule {

    private final Context context;

    public NetModule(final Context context) {
        this.context = context;
    }
}
