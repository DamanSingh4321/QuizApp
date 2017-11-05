package com.singh.daman.quizapp.ui.question;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.singh.daman.quizapp.data.model.QuizResponse;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Daman on 11/5/2017.
 */

public class QuestionPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<QuizResponse> list = new ArrayList<>();

    public QuestionPagerAdapter(FragmentManager fm, ArrayList<QuizResponse> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return QuestionFragment.newInstance(list.get(position));
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
