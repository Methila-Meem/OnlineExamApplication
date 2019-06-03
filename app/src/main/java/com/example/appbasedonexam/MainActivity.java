package com.example.appbasedonexam;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

   private EditText signInEmail,signInPassword;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        this.setTitle("Sign in");

        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(MainActivity.this, FrontActivity.class));
            finish();
        }

        signInEmail = findViewById(R.id.SignInEmailEditTextId);
        signInPassword = findViewById(R.id.SignInPasswordEditTextId);
        Button signInButton = findViewById(R.id.SignInButtonId);
        TextView signInTextview = findViewById(R.id.SignUpTextViewId);
        progressBar = findViewById(R.id.progressbarId);

        signInTextview.setOnClickListener(this);
        signInButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.SignInButtonId:
                userLogin();
                break;
            case  R.id.SignUpTextViewId:
                Intent intent=new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void userLogin() {

        String email=signInEmail.getText().toString().trim();
        final String password=signInPassword.getText().toString().trim();

        //checking email validity
        if (email.isEmpty())
        {
            signInEmail.setError("Enter an email");
            signInEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signInEmail.setError("Enter a valid email address");
            signInEmail.requestFocus();
            return;
        }

        //checking password validity
        if (password.isEmpty()) {
            signInPassword.setError("Enter a password");
            signInPassword.requestFocus();
            return;
        }

        if (password.length()<6) {
            signInPassword.setError("Minimum length of password should be 6");
            signInPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

           progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()){
                    Intent intent=new Intent(getApplicationContext(),FrontActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"Login unsuccessfull",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
