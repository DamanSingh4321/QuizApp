package com.singh.daman.quizapp.data;

import com.singh.daman.quizapp.data.model.QuizResponse;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import retrofit2.Response;

/**
 * Created by Daman on 11/4/2017.
 */

@Singleton
public class AppApiHelper {

    private ApiInterface apiInterface;

    @Inject
    public AppApiHelper(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    public Observable<List<QuizResponse>> getQuizApiCall(int page, int limit) {
        return apiInterface.getQuizData(page, limit);
    }
}
