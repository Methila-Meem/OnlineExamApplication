package com.example.appbasedonexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class FrontActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView profileCardView, coursesCardView, quizBankCardView, instructionsCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);

        profileCardView = findViewById(R.id.profileCardViewID);
        coursesCardView = findViewById(R.id.coursesCardViewID);
        quizBankCardView = findViewById(R.id.quizBankCardViewID);
        instructionsCardView = findViewById(R.id.instructionsCardViewID);

        profileCardView.setOnClickListener(this);
        coursesCardView.setOnClickListener(this);
        quizBankCardView.setOnClickListener(this);
        instructionsCardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.profileCardViewID) {
            Intent intent = new Intent(FrontActivity.this, ProfileActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.coursesCardViewID) {
            Intent intent = new Intent(FrontActivity.this, CoursesActivity.class);
            startActivity(intent);

        } else if (v.getId() == R.id.quizBankCardViewID) {
            Intent intent = new Intent(FrontActivity.this,Ques_BankActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.instructionsCardViewID) {
            Intent intent = new Intent(FrontActivity.this, InstructionsActivity.class);
            startActivity(intent);

        }
    }
}
