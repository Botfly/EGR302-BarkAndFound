package com.example.botfly.petscanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private Button register;
    private EditText firstName;
    //Creates instance of the database
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Creates button to update database in real-time
        register = (Button) findViewById(R.id.register);

        //creates link reference to database
        mDatabase = FirebaseDatabase.getInstance().getReference();

        firstName = (EditText) findViewById(R.name_field);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = firstName.getText().toString().trim();
                // 1 - create a child in root of the database
                mDatabase.child("First Name").setValue(name);
                mDatabase.child("Last Name");
                mDatabase.child("Email Address");
                mDatabase.child("Password");
                mDatabase.child("Confirm Password");

                // 2- Assign value to the child

            }
        });

    }

}
