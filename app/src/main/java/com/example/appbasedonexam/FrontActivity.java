package com.example.appbasedonexam;

import android.content.Intent;
import android.sax.StartElementListener;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class FrontActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);

        CardView writtenCardView = findViewById(R.id.writtenCardViewID);
        CardView coursesCardView = findViewById(R.id.coursesCardViewID);
        CardView quizBankCardView = findViewById(R.id.quizBankCardViewID);
        CardView instructionsCardView = findViewById(R.id.instructionsCardViewID);

        writtenCardView.setOnClickListener(this);
        coursesCardView.setOnClickListener(this);
        quizBankCardView.setOnClickListener(this);
        instructionsCardView.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==R.id.signOutId){
            FirebaseAuth.getInstance().signOut();
            finish();

            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.writtenCardViewID ) {
            Intent intent = new Intent(FrontActivity.this, EnterWritten.class);
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
