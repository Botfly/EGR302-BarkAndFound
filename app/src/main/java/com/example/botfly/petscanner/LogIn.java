package com.example.botfly.petscanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void loginClicked(View view) { //redirect to the xml page after user logs in
        setContentView(R.layout.activity_log_in);
        System.out.println("log in clicked");
    }

    public void signUpClicked(View view) { //redirect to Sign Up xml page
        setContentView(R.layout.activity_log_in);
        System.out.println("sign up clicked");
    }

    public void forgotPasswordClicked(View view) { //redirect to Forgot Password xml page
        setContentView(R.layout.activity_log_in);
        System.out.println("forgot password clicked");
    }

//    Button btn = (Button)findViewById(R.id.Button_LogIn);
//
//    btn.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            startActivity(new Intent(LogIn.this, SignUpScreen.class));
//        }
//    });

    //TextView textViewSignIn = (TextView) findViewById(R.id.textView_signUp);
    //textViewSignIn.setMovementMethod(LinkMovementMethod.getInstance());
}
