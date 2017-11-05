package com.singh.daman.quizapp.di.component;

import com.singh.daman.quizapp.di.annotations.PerActivity;
import com.singh.daman.quizapp.di.module.ActivityModule;
import com.singh.daman.quizapp.ui.main.MainActivity;
import com.singh.daman.quizapp.ui.question.QuestionActivity;
import com.singh.daman.quizapp.ui.question.QuestionFragment;

import dagger.Component;

/**
 * Created by Daman on 11/3/2017.
 */

@PerActivity
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(QuestionActivity questionActivity);

    void inject(QuestionFragment questionFragment);

}
