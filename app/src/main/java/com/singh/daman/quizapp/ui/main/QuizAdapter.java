package com.singh.daman.quizapp.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.singh.daman.quizapp.R;
import com.singh.daman.quizapp.data.model.QuizResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daman on 11/5/2017.
 */

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.MyViewHolder> {

    private List<QuizResponse> list;
    private Context context;
    private Callback callback;

    public QuizAdapter(List<QuizResponse> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.questions_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txtQuestions.setText(list.get(holder.getAdapterPosition()).getQuestion());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.questions)
        TextView txtQuestions;

        public MyViewHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    callback.onClick();
                }
            });

        }
    }

    public interface Callback {
        void onClick();
    }
}
