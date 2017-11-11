package com.singh.daman.quizapp.ui.question;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.singh.daman.gentletoast.GentleToast;
import com.singh.daman.quizapp.R;
import com.singh.daman.quizapp.data.model.QuizResponse;
import com.singh.daman.quizapp.di.component.ActivityComponent;
import com.singh.daman.quizapp.ui.base.BaseFragment;
import com.singh.daman.quizapp.ui.main.MainActivity;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.singh.daman.quizapp.util.Constants.ARG_QUESTION;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends BaseFragment implements QuestionView, View.OnClickListener{

    @Inject
    QuestionPresenterImpl<QuestionView> questionPresenter;

    @BindView(R.id.question)
    TextView textQuestion;

    @BindView(R.id.card_option1)
    CardView cardOption1;

    @BindView(R.id.card_option2)
    CardView cardOption2;

    @BindView(R.id.card_option3)
    CardView cardOption3;

    @BindView(R.id.card_option4)
    CardView cardOption4;

    @BindView(R.id.txt_option1)
    TextView tvOption1;

    @BindView(R.id.txt_option2)
    TextView tvOption2;

    @BindView(R.id.txt_option3)
    TextView tvOption3;

    @BindView(R.id.txt_option4)
    TextView tvOption4;

    @BindView(R.id.btn_submit)
    Button btnSubmit;

    private QuizResponse quizResponse;
    private int selectedOption = 0;

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
        if(quizResponse != null) {
            textQuestion.setText(quizResponse.getQuestion());
            tvOption1.setText(quizResponse.getOption1());
            tvOption2.setText(quizResponse.getOption2());
            tvOption3.setText(quizResponse.getOption3());
            tvOption4.setText(quizResponse.getOption4());
        }
        cardOption1.setOnClickListener(this);
        cardOption2.setOnClickListener(this);
        cardOption3.setOnClickListener(this);
        cardOption4.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);

        defaultColors();

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.card_option1:
                changeCardColor(cardOption1, tvOption1);
                selectedOption = 1;
                break;
            case R.id.card_option2:
                changeCardColor(cardOption2, tvOption2);
                selectedOption = 2;
                break;
            case R.id.card_option3:
                changeCardColor(cardOption3, tvOption3);
                selectedOption = 3;
                break;
            case R.id.card_option4:
                changeCardColor(cardOption4, tvOption4);
                selectedOption = 4;
                break;
            case R.id.btn_submit:
                submitAnswer();
                break;
        }
    }

    private void submitAnswer(){
        if(selectedOption == 0) {
            GentleToast.with(getContext())
                    .shortToast("Select an option!")
                    .show();
        }
        else if(selectedOption == quizResponse.getAnswers()){
            GentleToast.with(getContext())
                    .shortToast("You are amazing!")
                    .show();
            startDelay();
        }
        else {
            GentleToast.with(getContext())
                    .shortToast("Right answer is: " + quizResponse.getAnswers())
                    .show();
            startDelay();
        }
    }

    private void startDelay(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                moveToNextPage();
            }
        }, 1000);   //5 seconds
    }

    private void moveToNextPage(){
        int result = ((QuestionActivity)getActivity()).moveToNextPage();
        if(result == 0){
            btnSubmit.setText("Next");
        } else if(result == 1) {
            btnSubmit.setText("Submit");
        } else {
            MainActivity.getStartIntent(getContext());
            getActivity().finish();
        }
    }

    private void changeCardColor(CardView cardView, TextView textView){
        defaultColors();
        cardView.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        textView.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
    }

    private void defaultColors(){
        cardOption1.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
        cardOption2.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
        cardOption3.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
        cardOption4.setCardBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
        tvOption1.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
        tvOption2.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
        tvOption3.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
        tvOption4.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
    }

    @Override
    public void onDestroyView() {
        questionPresenter.onDetach();
        super.onDestroyView();
    }
}
