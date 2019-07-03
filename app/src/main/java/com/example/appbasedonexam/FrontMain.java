package com.example.appbasedonexam;

import android.content.Intent;
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

import com.google.firebase.auth.FirebaseAuth;

import static android.view.View.*;

public class FrontMain extends AppCompatActivity implements OnClickListener {
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
        CardView attandenceCardView = findViewById(R.id.attandenceCardViewID);
        CardView examCardView = findViewById(R.id.ExaminationCardViewID);
        CardView noteCardView = findViewById(R.id.noteCardViewID);
        CardView cgpaCardView = findViewById(R.id.cgpaCardViewID);


        profileCardView.setOnClickListener(this);
        attandenceCardView.setOnClickListener(this);
        examCardView.setOnClickListener(this);
        noteCardView.setOnClickListener(this);
        cgpaCardView.setOnClickListener(this);

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
            Intent intent = new Intent(FrontMain.this, ProfileActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.attandenceCardViewID) {
            Intent intent = new Intent(FrontMain.this, HelperActivity.class);
            startActivity(intent);

        } else if (v.getId() == R.id.ExaminationCardViewID) {
            Intent intent = new Intent(FrontMain.this,FrontActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.cgpaCardViewID) {
            Intent intent = new Intent(FrontMain.this, CgpaCalcActivity.class);
            startActivity(intent);

        }
        else if (v.getId() == R.id.noteCardViewID) {
            Intent intent = new Intent(FrontMain.this, HelperActivity.class);
            startActivity(intent);

        }
    }
}
