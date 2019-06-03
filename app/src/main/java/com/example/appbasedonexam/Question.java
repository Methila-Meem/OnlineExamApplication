package com.example.appbasedonexam;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Question {

    private String questions,option1,option2,option3,option4,answer;

    public Question(String question, String option1, String option2, String option3, String option4, String answer) {
        this.questions = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
    }

    public Question(){}

    public String getQuestion() {
        return questions;
    }

    public void setQuestion(String question) {
        this.questions = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public static class QuizQuestionActivity extends AppCompatActivity {


        Button b1, b2, b3, b4;
        TextView timerTxt, t1_question;
        DatabaseReference reference;
        int total = 0;
        int correct = 0;
        int wrong = 0;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_quiz_question);


            b1 = (Button) findViewById(R.id.firstBtn);
            b2 = (Button) findViewById(R.id.secondBtn);
            b3 = (Button) findViewById(R.id.thirdBtn);
            b4 = (Button) findViewById(R.id.fourthBtn);


            timerTxt = (TextView) findViewById(R.id.timerText);
            t1_question = (TextView) findViewById(R.id.questions);

            updateQuestion();
            reverseTimer(30,timerTxt);


        }

        private void updateQuestion() {
            total++;
            System.out.println(total);
            if (total > 10) {
                Intent i=new Intent(QuizQuestionActivity.this,ResultActivity.class);
                i.putExtra("total",String.valueOf(total));
                i.putExtra("correct",String.valueOf(correct));
                i.putExtra("incorrect",String.valueOf(wrong));
                startActivity(i);

            }
            else {
                reference = FirebaseDatabase.getInstance().getReference().child("Sheet1").child(String.valueOf(total));
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        final Question question = dataSnapshot.getValue(Question.class);
                        if(question != null) {
                            t1_question.setText(question.getQuestion());
                            b1.setText(question.getOption1());
                            b2.setText(question.getOption2());
                            b3.setText(question.getOption3());
                            b4.setText(question.getOption4());
                        } else {
                            System.out.println("total=" + total);
                        }

                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (b1.getText().toString().equals(question.getAnswer()))
                                {
                                    b1.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            b1.setBackgroundColor(Color.parseColor("#99b0cc83"));
                                            updateQuestion();


                                        }
                                    }, 1000);

                                }
                                else
                                {
                                    wrong++;
                                    b1.setBackgroundColor(Color.RED);
                                    if (b2.getText().toString().equals(question.getAnswer())) {
                                        b2.setBackgroundColor(Color.GREEN);
                                    } else if (b3.getText().toString().equals(question.getAnswer())) {
                                        b3.setBackgroundColor(Color.GREEN);
                                    } else if (b4.getText().toString().equals(question.getAnswer())) {
                                        b4.setBackgroundColor(Color.GREEN);
                                    }
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b1.setBackgroundColor(Color.parseColor("#99b0cc83"));
                                            b2.setBackgroundColor(Color.parseColor("#99b0cc83"));
                                            b3.setBackgroundColor(Color.parseColor("#99b0cc83"));
                                            b4.setBackgroundColor(Color.parseColor("#99b0cc83"));
                                            updateQuestion();
                                        }
                                    }, 1000);


                                }

                            }
                        });

                        b2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (b2.getText().toString().equals(question.getAnswer()))
                                {
                                    b2.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            b2.setBackgroundColor(Color.parseColor("#99b0cc83"));
                                            updateQuestion();

                                        }
                                    }, 1000);
                                }
                                else{
                                    wrong++;
                                    b2.setBackgroundColor(Color.RED);
                                    if (b1.getText().toString().equals(question.getAnswer())) {
                                        b1.setBackgroundColor(Color.GREEN);
                                    } else if (b3.getText().toString().equals(question.getAnswer())) {
                                        b3.setBackgroundColor(Color.GREEN);
                                    } else if (b4.getText().toString().equals(question.getAnswer())) {
                                        b4.setBackgroundColor(Color.GREEN);
                                    }
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b1.setBackgroundColor(Color.parseColor("#99b0cc83"));
                                            b2.setBackgroundColor(Color.parseColor("#99b0cc83"));
                                            b3.setBackgroundColor(Color.parseColor("#99b0cc83"));
                                            b4.setBackgroundColor(Color.parseColor("#99b0cc83"));
                                            updateQuestion();
                                        }
                                    }, 1000);

                                }

                            }
                        });

                        b3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (b3.getText().toString().equals(question.getAnswer()))
                                {
                                    b3.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            b3.setBackgroundColor(Color.parseColor("#99b0cc83"));
                                            updateQuestion();

                                        }
                                    }, 1000);
                                }
                                else{
                                    wrong++;
                                    b3.setBackgroundColor(Color.RED);
                                    if (b2.getText().toString().equals(question.getAnswer())) {
                                        b2.setBackgroundColor(Color.GREEN);
                                    } else if (b1.getText().toString().equals(question.getAnswer())) {
                                        b1.setBackgroundColor(Color.GREEN);
                                    } else if (b4.getText().toString().equals(question.getAnswer())) {
                                        b4.setBackgroundColor(Color.GREEN);
                                    }
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b1.setBackgroundColor(Color.parseColor("#99b0cc83"));
                                            b2.setBackgroundColor(Color.parseColor("#99b0cc83"));
                                            b3.setBackgroundColor(Color.parseColor("#99b0cc83"));
                                            b4.setBackgroundColor(Color.parseColor("#99b0cc83"));
                                            updateQuestion();
                                        }
                                    }, 1000);

                                }
                            }
                        });

                        b4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (b4.getText().toString().equals(question.getAnswer()))
                                {
                                    b4.setBackgroundColor(Color.GREEN);
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            correct++;
                                            b4.setBackgroundColor(Color.parseColor("#99b0cc83"));
                                            updateQuestion();

                                        }
                                    }, 1000);
                                }
                                else{
                                    wrong++;
                                    b4.setBackgroundColor(Color.RED);
                                    if (b2.getText().toString().equals(question.getAnswer())) {
                                        b2.setBackgroundColor(Color.GREEN);
                                    } else if (b3.getText().toString().equals(question.getAnswer())) {
                                        b3.setBackgroundColor(Color.GREEN);
                                    } else if (b1.getText().toString().equals(question.getAnswer())) {
                                        b1.setBackgroundColor(Color.GREEN);
                                    }
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            b1.setBackgroundColor(Color.parseColor("#99b0cc83"));
                                            b2.setBackgroundColor(Color.parseColor("#99b0cc83"));
                                            b3.setBackgroundColor(Color.parseColor("#99b0cc83"));
                                            b4.setBackgroundColor(Color.parseColor("#99b0cc83"));
                                            updateQuestion();
                                        }
                                    }, 1000);

                                }
                            }
                        });
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                    ;
                });

            }
        }
        public void reverseTimer(int seconds, final TextView tv)
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
                    Intent myintent=new Intent(QuizQuestionActivity.this,ResultActivity.class);
                    myintent.putExtra("total",String.valueOf(total));
                    myintent.putExtra("correct",String .valueOf(correct));
                    myintent.putExtra("wrong",String.valueOf(wrong));
                    startActivity(myintent);

                }
            }.start();
        }

    }
}
