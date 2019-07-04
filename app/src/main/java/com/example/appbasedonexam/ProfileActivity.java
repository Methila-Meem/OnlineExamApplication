package com.example.appbasedonexam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        try {
            String total = sharedPref.getData("total");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try {
            String correct=sharedPref.getData("correct");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try {
            String wrong=sharedPref.getData("wrong");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
