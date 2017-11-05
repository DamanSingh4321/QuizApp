package com.singh.daman.quizapp.ui.question;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.singh.daman.quizapp.R;
import com.singh.daman.quizapp.data.model.QuizResponse;
import com.singh.daman.quizapp.di.component.ActivityComponent;
import com.singh.daman.quizapp.ui.base.BaseFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.singh.daman.quizapp.util.Constants.ARG_QUESTION;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends BaseFragment implements QuestionView{

    @Inject
    QuestionPresenterImpl<QuestionView> questionPresenter;

    @BindView(R.id.question)
    TextView textQuestion;

    private QuizResponse quizResponse;

    public QuestionFragment() {
        // Required empty public constructor
    }

    public static QuestionFragment newInstance(QuizResponse response) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_QUESTION, response);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question, container, false);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            ButterKnife.bind(this, view);
            questionPresenter.onAttach(this);
        }
        quizResponse = getArguments().getParcelable(ARG_QUESTION);
        textQuestion.setText(quizResponse.getQuestion());

        return view;
    }

    @Override
    public void onDestroyView() {
        questionPresenter.onDetach();
        super.onDestroyView();
    }
}
