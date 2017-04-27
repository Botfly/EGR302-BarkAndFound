package com.example.botfly.petscanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UserInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info2);
    }

    public void InfoPageSubmitButton (View view) {
        setContentView(R.layout.activity_buy_collar);
    }
}
