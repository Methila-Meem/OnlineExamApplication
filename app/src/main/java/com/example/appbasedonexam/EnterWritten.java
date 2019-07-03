package com.example.appbasedonexam;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

public class EnterWritten extends AppCompatActivity {

    TextView roll,course_no,year,semester,date;
    EditText roll1,course_no1,date1,year1,semester1;
    Button let_start,done_btn;
    DatabaseReference databaseReference;
    private ProgressBar progressBar;

    DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_written);

        databaseReference=FirebaseDatabase.getInstance().getReference("students");

        progressBar = findViewById(R.id.progressbarId);
        roll=findViewById(R.id.roll);
        roll1=findViewById(R.id.edit_roll);
        course_no=findViewById(R.id.course_no);
        course_no1=findViewById(R.id.edit_courseNo);
        date=findViewById(R.id.date);
        date1=findViewById(R.id.edit_date);
        year=findViewById(R.id.Year);
        year1=findViewById(R.id.edit_year);
        semester=findViewById(R.id.semester);
        semester1=findViewById(R.id.edit_semester);
        let_start=findViewById(R.id.ButtonId);
        done_btn=findViewById(R.id.done_btn);

        done_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        let_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.ButtonId)
                {
                    check();
                }
            }

            private void check()

            {

                String roll=roll1.getText().toString().trim();
                String course_no=course_no1.getText().toString().trim();
                String year=year1.getText().toString().trim();
                String semester=semester1.getText().toString().trim();
                String date=date1.getText().toString().trim();

                //roll checking

                if (roll.isEmpty()) {
                   roll1.setError("Enter a roll");
                    roll1.requestFocus();
                    return;
                }

                if (roll.length()<7) {
                    roll1.setError("Valid  length of roll should be 7");
                    roll1.requestFocus();
                    return;
                }

                //check course

                if (course_no.isEmpty()) {
                    course_no1.setError("Enter a course_no");
                    course_no1.requestFocus();
                    return;
                }

                //check year and smester

                if (year.isEmpty()) {
                    date1.setError("Enter a year");
                    date1.requestFocus();
                    return;
                }

                if (semester.isEmpty()) {
                    date1.setError("Enter a semester");
                    date1.requestFocus();
                    return;
                }

                //check date

                if (date.isEmpty()) {
                    date1.setError("Enter a date");
                    date1.requestFocus();
                }

                progressBar.setVisibility(View.VISIBLE);
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePicker datePicker=new DatePicker(EnterWritten.this);
                int currentDay=datePicker.getDayOfMonth();
                int currentMonth=datePicker.getMonth()+1;
                int currentYear=datePicker.getYear();

                datePickerDialog=new DatePickerDialog(EnterWritten.this,

                        new DatePickerDialog.OnDateSetListener(){

                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                                date.setText(String.format(Locale.getDefault(),"Exam_Date:  %d/%d/%d", dayOfMonth, month + 1, year));

                            }
                        },currentYear,currentMonth,currentDay);

                datePickerDialog.show();
            }
        });
    }

    public void saveData() {
        final String roll=roll1.getText().toString().trim();
        final String course_no=course_no1.getText().toString().trim();
        final String date=date1.getText().toString().trim();
        final String year = year1.getText().toString();
        startActivity(new Intent(EnterWritten.this, writtenExam.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK)
                .putExtra("roll", roll)
                .putExtra("year", year)
                .putExtra("courseNo", course_no)
                .putExtra("date", date)
        );
    }
}
