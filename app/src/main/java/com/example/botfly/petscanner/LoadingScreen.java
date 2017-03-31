package com.example.botfly.petscanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoadingScreen extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);

        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(3000); //delay
                } catch (Exception e) {

                } finally {

                    Intent i = new Intent(LoadingScreen.this,
                            LogIn.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        welcomeThread.start();
    }

    public void redirectToLogIn(View view){
        setContentView(R.layout.activity_log_in);
    }

}
