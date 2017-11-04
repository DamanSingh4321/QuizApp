package com.singh.daman.quizapp.di.component;

import com.singh.daman.quizapp.di.annotations.PerActivity;
import com.singh.daman.quizapp.di.module.ActivityModule;
import com.singh.daman.quizapp.ui.main.MainActivity;

import dagger.Component;

/**
 * Created by Daman on 11/3/2017.
 */

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);
}
