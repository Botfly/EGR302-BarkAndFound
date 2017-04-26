package com.example.botfly.petscanner;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoadingScreen extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);

        setTypeFace();

        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(3500); //delay
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

    public void setTypeFace() {
        Typeface segoe = Typeface.createFromAsset(getAssets(), "fonts/Segoe_Print.ttf");
        TextView tv2 = (TextView) findViewById(R.id.textView_appNameLoadingScreen);
        tv2.setTypeface(segoe);
    }

    public void redirectToLogIn(View view){
        setContentView(R.layout.activity_log_in);
    }

}
