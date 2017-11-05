package com.singh.daman.quizapp.ui.question;

import com.singh.daman.quizapp.data.DataManager;
import com.singh.daman.quizapp.ui.base.BaseMvpView;
import com.singh.daman.quizapp.ui.base.BasePresenterImpl;

import javax.inject.Inject;

/**
 * Created by Daman on 11/5/2017.
 */

public class QuestionPresenterImpl<V extends BaseMvpView> extends BasePresenterImpl<V>
        implements QuestionPresenter<V> {

    private DataManager dataManager;

    @Inject
    public QuestionPresenterImpl(DataManager dataManager) {
        this.dataManager = dataManager;
    }
}
