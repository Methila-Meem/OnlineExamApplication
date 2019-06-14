package com.example.appbasedonexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HelperActivity extends AppCompatActivity {


    TextView name, name1, email, email1, marks, marks1, course, course1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper);

        name = findViewById(R.id.name);
        name1 = findViewById(R.id.name1);
        email = findViewById(R.id.email);
        email1 = findViewById(R.id.email1);
        marks = findViewById(R.id.marks);
        marks1 = findViewById(R.id.marks1);
        course = findViewById(R.id.course_name);
        course1 = findViewById(R.id.course_name1);


        Bundle bundle = getIntent().getExtras();
        if (bundle!=null)
        {
          String value=bundle.getString("marks")  ;
          marks1.setText(value);
        }

    }
}
