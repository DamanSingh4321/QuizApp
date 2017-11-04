package com.singh.daman.quizapp.ui.base;

import android.view.View;

/**
 * Created by Daman on 11/4/2017.
 */

public class BasePresenterImpl<V extends BaseMvpView> implements BaseMvpPresenter<V> {

    private V view;

    @Override
    public void onAttach(V mvpView) {
        view = mvpView;
    }

    @Override
    public void onDetach() {
        view = null;
    }

    public boolean isViewAttached() {
        return view != null;
    }

    public V getView() {
        return view;
    }

}
