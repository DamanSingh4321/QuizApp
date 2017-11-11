package com.singh.daman.quizapp.ui.question;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.singh.daman.quizapp.R;
import com.singh.daman.quizapp.data.model.QuizResponse;
import com.singh.daman.quizapp.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.singh.daman.quizapp.util.Constants.ARG_LIST;
import static com.singh.daman.quizapp.util.Constants.ARG_QUESTION;

public class QuestionActivity extends BaseActivity {

    @BindView(R.id.question_view_pager)
    ViewPager mViewPager;

    private QuestionPagerAdapter pagerAdapter;
    private ArrayList<QuizResponse> list;

    public static Intent getStartIntent(Context context, ArrayList<QuizResponse> responses) {
        Intent intent = new Intent(context, QuestionActivity.class);
        if(responses != null && responses.size() > 0) {
            intent.putParcelableArrayListExtra(ARG_LIST, responses);
        }
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        activityComponent().inject(this);
        ButterKnife.bind(this);
        list = getIntent().getParcelableArrayListExtra(ARG_LIST);
        pagerAdapter = new QuestionPagerAdapter(getSupportFragmentManager(), list);
        mViewPager.setAdapter(pagerAdapter);
    }

    public int moveToNextPage(){
        if(mViewPager.getCurrentItem() <= list.size() - 2) {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
            return 0;
        } else if(mViewPager.getCurrentItem() != list.size() - 1) {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
            return 1;
        } else{
            return 2;
        }
    }

}
