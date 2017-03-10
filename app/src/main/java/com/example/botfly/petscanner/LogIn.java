package com.example.botfly.petscanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void loginClicked(View view) {
        System.out.println("kijhdfskjh");
    }//j

    //TextView textViewSignIn = (TextView) findViewById(R.id.textView_signUp);
    //textViewSignIn.setMovementMethod(LinkMovementMethod.getInstance());
}
