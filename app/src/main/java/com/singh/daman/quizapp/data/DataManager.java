package com.singh.daman.quizapp.data;

import android.content.Context;

import com.singh.daman.quizapp.data.model.QuizResponse;
import com.singh.daman.quizapp.di.annotations.ApplicationContext;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import retrofit2.Response;

/**
 * Created by Daman on 11/4/2017.
 */

@Singleton
public class DataManager {

    private Context context;
    private AppApiHelper apiHelper;

    @Inject
    public DataManager(@ApplicationContext Context context,
                       AppApiHelper apiHelper) {
        this.context = context;
        this.apiHelper = apiHelper;
    }

    public Observable<List<QuizResponse>> getQuizApiCall(int page, int limit) {
        return apiHelper.getQuizApiCall(page, limit);
    }
}
