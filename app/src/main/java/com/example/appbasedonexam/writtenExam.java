package com.example.appbasedonexam;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class writtenExam extends AppCompatActivity {

    TextView question, timer;
    EditText answer;
    Button submit;
    DatabaseReference databaseReference;
    int total = 0;
    private Object student;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_written_exam);


        databaseReference = FirebaseDatabase.getInstance().getReference();

        question = findViewById(R.id.question1);
        timer = findViewById(R.id.timerText);
        answer = findViewById(R.id.answer);
        submit = findViewById(R.id.submit1);

        updateQuestion();
        ReverseTimer(30, timer);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

    }

    public void saveData() {

        String name = answer.getText().toString().trim();


        String key = databaseReference.push().getKey();
        student student = new student(answer);
        databaseReference.child(key).setValue(student);
    }


    public void updateQuestion() {

        total++;
        System.out.println(total);
        if (total > 5) {
            Intent i = new Intent(writtenExam.this, ResultActivity.class);

            startActivity(i);
        } else {
            databaseReference = FirebaseDatabase.getInstance().getReference().child("Sheet1").child(String.valueOf(total));
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final student question = dataSnapshot.getValue(student.class);
                    if (question!= null) {
                         question.setText(question.getQues());


                    } else {
                        System.out.println("total=" + total);
                    }


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }

                public void ReverseTimer(int seconds, final TextView tv)
                {
                    new CountDownTimer(seconds* 1000 + 1000,1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            int seconds=(int) (millisUntilFinished/1000);
                            int minutes= seconds%60;
                            tv.setText(String.format("%02d",minutes)
                                    + ":" + String.format("%02d",seconds));
                        }

                        @Override
                        public void onFinish() {
                            tv.setText("completed");
                            Intent myintent = new Intent(writtenExam.this, ResultActivity.class);
                            myintent.putExtra("total", String.valueOf(total));
                            startActivity(myintent);

                        }
                    }.start();

                }


            });
        }
    }

}