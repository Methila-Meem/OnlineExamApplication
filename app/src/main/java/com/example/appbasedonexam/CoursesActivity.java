package com.example.appbasedonexam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;



public class CoursesActivity extends AppCompatActivity {

  private ListView listView;
  private String coursenames[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        coursenames = getResources().getStringArray(R.array.Course_names);
        listView = (ListView) findViewById(R.id.ListViewID);
        CustomAdapter adapter = new CustomAdapter(this,coursenames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = coursenames[position];
                Toast.makeText(CoursesActivity.this, value, Toast.LENGTH_SHORT).show();

                if (position==0) {
                    Intent intent = new Intent(view.getContext(), Question.QuizQuestionActivity.class);
                    startActivityForResult(intent,0);

                }
                if (position==1) {
                    Intent intent = new Intent(view.getContext(), Question.QuizQuestionActivity.class);
                    startActivityForResult(intent,1);

                }
                if (position==2) {
                    Intent intent = new Intent(view.getContext(), Question.QuizQuestionActivity.class);
                    startActivityForResult(intent,2);

                }
                if (position==3) {
                    Intent intent = new Intent(view.getContext(),HelperActivity.class);
                    startActivityForResult(intent,3);

                }

            }
        });

    }
}

