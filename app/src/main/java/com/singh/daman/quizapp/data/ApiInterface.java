package com.singh.daman.quizapp.data;

import com.singh.daman.quizapp.data.model.QuizResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Daman on 11/4/2017.
 */

public interface ApiInterface {

    @GET("questions")
    Observable<List<QuizResponse>> getQuizData(@Query("page") int page, @Query("limit") int limit);

}
