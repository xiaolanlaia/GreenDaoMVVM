package com.example.liberarylearning.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.liberarylearning.R;
import com.example.liberarylearning.databinding.ActivityQuestionListBinding;

public class QuestionListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityQuestionListBinding activityQuestionListBinding = DataBindingUtil.setContentView(this,R.layout.activity_question_list);
    }
}
