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
    private EditText lastName;
    private EditText emailAddress;
    private EditText password;
    private EditText confirmPassword;

    //Creates instance of the database
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Creates button to update database in real-time
        register = (Button) findViewById(R.id.Register);

        //creates link reference to database
        mDatabase = FirebaseDatabase.getInstance().getReference();

        //Creates local variable for user input on each field
        firstName = (EditText) findViewById(R.id.first_name);
        lastName = (EditText) findViewById(R.id.last_name);
        emailAddress = (EditText) findViewById(R.id.email_address);
        confirmPassword = (EditText) findViewById(R.id.confirm_password);

        //On Click Listener
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = firstName.getText().toString().trim();
                String lName = lastName.getText().toString().trim();

                // 1 - create a child in root of the database
                mDatabase.child("First Name").setValue(name);
                mDatabase.child("Last Name").setValue(lName);
                mDatabase.child("Email Address");
                mDatabase.child("Password");
                mDatabase.child("Confirm Password");

                // 2- Assign value to the child

            }
        });

    }

}
