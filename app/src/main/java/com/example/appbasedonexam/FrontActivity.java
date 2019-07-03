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

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class FrontActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        mAuth=FirebaseAuth.getInstance();

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation_view);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        CardView profileCardView = findViewById(R.id.profileCardViewID);
        CardView coursesCardView = findViewById(R.id.coursesCardViewID);
        CardView quizBankCardView = findViewById(R.id.quizBankCardViewID);
        CardView instructionsCardView = findViewById(R.id.instructionsCardViewID);

        profileCardView.setOnClickListener(this);
        coursesCardView.setOnClickListener(this);
        quizBankCardView.setOnClickListener(this);
        instructionsCardView.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
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
        if (v.getId() == R.id.profileCardViewID) {
            Intent intent = new Intent(FrontActivity.this, writtenExam.class);
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
