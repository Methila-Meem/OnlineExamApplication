package com.example.appbasedonexam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        String total = sharedPref.getData("total");
        String correct=sharedPref.getData("correct");
        String wrong=sharedPref.getData("wrong");

    }
}
