package com.singh.daman.quizapp.ui.main;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.singh.daman.gentletoast.GentleToast;
import com.singh.daman.proprogressviews.DotsZoomProgress;
import com.singh.daman.quizapp.R;
import com.singh.daman.quizapp.data.model.QuizResponse;
import com.singh.daman.quizapp.ui.base.BaseActivity;
import com.singh.daman.quizapp.ui.question.QuestionActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView, QuizAdapter.Callback{

    @Inject
    MainPresenterImpl<MainView> presenter;

    @BindView(R.id.main_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.main_progress)
    DotsZoomProgress dotsZoomProgress;

    private ArrayList<QuizResponse> list = new ArrayList<>();
    private QuizAdapter quizAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter.onAttach(this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        quizAdapter = new QuizAdapter(list, this);
        recyclerView.setAdapter(quizAdapter);
        presenter.getQuizData(0, 10);
        quizAdapter.setCallback(this);

    }

    @Override
    public void showLoading() {
        dotsZoomProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void loadSuccess(List<?> responseList) {
        dotsZoomProgress.setVisibility(View.GONE);
        list.addAll((List<QuizResponse>)responseList);
        quizAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadFailure(String error) {
        dotsZoomProgress.setVisibility(View.GONE);
        GentleToast.with(this)
                .shortToast(error)
                .show();
    }

    @Override
    public void onClick() {
        startActivity(QuestionActivity.getStartIntent(this, list));
    }
}
