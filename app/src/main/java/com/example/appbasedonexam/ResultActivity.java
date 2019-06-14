package com.example.appbasedonexam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView t1,t2,t3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        t1= findViewById(R.id.textView4);
        t2= findViewById(R.id.textView5);
        t3= findViewById(R.id.textView6);


        Intent i=getIntent();
        String questions=i.getStringExtra("total");
        String correct=i.getStringExtra("correct");
        String wrong=i.getStringExtra("wrong");

        t1.setText(questions);
        t2.setText(correct);
        t3.setText(wrong);









    }
}
