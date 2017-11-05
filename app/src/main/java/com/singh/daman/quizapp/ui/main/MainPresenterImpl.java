package com.singh.daman.quizapp.ui.main;

import android.util.Log;

import com.singh.daman.quizapp.data.DataManager;
import com.singh.daman.quizapp.data.model.QuizResponse;
import com.singh.daman.quizapp.ui.base.BasePresenterImpl;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by Daman on 11/4/2017.
 */

public class MainPresenterImpl<V extends MainView> extends BasePresenterImpl<V>
        implements MainPresenter<V> {

    private DataManager dataManager;
    String question;

    @Inject
    public MainPresenterImpl(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void getQuizData(int page, int limit) {
        getView().showLoading();
        dataManager.getQuizApiCall(page, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .retry(3)
                .subscribe(new Observer<List<QuizResponse>>() {
                    Disposable d;

                    @Override
                    public void onSubscribe(Disposable d) {
                        this.d = d;
                    }

                    @Override
                    public void onNext(List<QuizResponse> quizResponse) {
                        if (quizResponse != null && quizResponse.size() > 0)
                            getView().loadSuccess(quizResponse);
                        else
                            getView().loadFailure("No more questions");

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("daman", e.toString());
                        getView().loadFailure(e.getMessage());
                        if (!d.isDisposed())
                            d.dispose();
                    }

                    @Override
                    public void onComplete() {
                        if (!d.isDisposed())
                            d.dispose();
                    }
                });
    }
}
