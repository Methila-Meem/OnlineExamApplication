package com.example.appbasedonexam;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.akaita.android.circularseekbar.CircularSeekBar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;

public class AttendenceAcivity extends AppCompatActivity {
    TextView text,percentage;
    EditText roll;
    Button btn;
    DatabaseReference ref;
    CircularSeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence_acivity);

        text=findViewById(R.id.textView);
        percentage=findViewById(R.id.percentage);
        btn=findViewById(R.id.btn);
        seekBar=findViewById(R.id.seekbar);
        roll=findViewById(R.id.roll);

        seekBar.setProgressTextFormat(new DecimalFormat("###,###,###,##0.00"));
        seekBar.setProgress(0);
        seekBar.setRingColor(Color.GREEN);
       seekBar.setOnCenterClickedListener(new CircularSeekBar.OnCenterClickedListener() {
           @Override
           public void onCenterClicked(CircularSeekBar seekBar, float progress) {
               Snackbar.make(seekBar,"Reset",Snackbar.LENGTH_SHORT).show();
               seekBar.setProgress(0);

           }
       });

       seekBar.setOnCircularSeekBarChangeListener(new CircularSeekBar.OnCircularSeekBarChangeListener() {
           @Override
           public void onProgressChanged(CircularSeekBar seekBar, float progress, boolean fromUser) {
               if (fromUser) return;
               if(progress<20){
                   seekBar.setRingColor(Color.GREEN);
               }

               else if (progress<40)
               {
                   seekBar.setRingColor(Color.YELLOW);
               }
               else {
                   seekBar.setRingColor(Color.RED);
               }
           }

           @Override
           public void onStartTrackingTouch(CircularSeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(CircularSeekBar seekBar) {

           }
       });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rollNo = roll.getText().toString();
                ref= FirebaseDatabase.getInstance().getReference().child("Attendence").child("Sheet1").child(rollNo);
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String name=dataSnapshot.child("present%").getValue().toString();
                        percentage.setText(name);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
