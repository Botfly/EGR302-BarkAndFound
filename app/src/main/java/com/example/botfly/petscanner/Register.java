package com.example.botfly.petscanner;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

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

        //creates link reference to root of database
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

                // 1 - create a child in root of the database
                // 2- Assign value to the child


                /*
                String name = firstName.getText().toString().trim();
                String lName = lastName.getText().toString().trim();
                String mail = emailAddress.getText().toString().trim();
                String pass = confirmPassword.getText().toString().trim();

                //Create Hash-map to make object with all the fields
                HashMap<String, String> dataMap = new HashMap<String, String>();
                dataMap.put("Name", name);
                dataMap.put("Last Name", lName);
                dataMap.put("Email", mail);
                dataMap.put("Password", pass);

                //Push Hash Object to root of Database
                //The on-complete listener makes sure the information was pushed
                //successfully to the database.
                mDatabase.push().setValue(dataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this, "Stored..", Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(Register.this, "", Toast.LENGTH_SHORT).show();
                        }
                    }
                });*/

            }
        });

    }
/*
    public void registerClicked(View view) {
        register = (Button) findViewById(R.id.Register);

        //creates link reference to root of database
        mDatabase = FirebaseDatabase.getInstance().getReference();
        //Creates link reference to root of a specific user
        //mDatabase = FirebaseDatabase.getInstance().getReference().getchild("User_01");

        //Creates local variable for user input on each field
        firstName = (EditText) findViewById(R.id.first_name);
        lastName = (EditText) findViewById(R.id.last_name);
        emailAddress = (EditText) findViewById(R.id.email_address);
        confirmPassword = (EditText) findViewById(R.id.confirm_password);

        //On Click Listener
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 1 - create a child in root of the database
                // 2- Assign value to the child

                String name = firstName.getText().toString().trim();
                String lName = lastName.getText().toString().trim();
                String mail = emailAddress.getText().toString().trim();
                String pass = confirmPassword.getText().toString().trim();

                //Create Hash-map to make object with all the fields
                HashMap<String, String> dataMap = new HashMap<String, String>();
                dataMap.put("Name", name);
                dataMap.put("Last Name", lName);
                dataMap.put("Email", mail);
                dataMap.put("Password", pass);

                //Push Hash Object to root of Database
                //The on-complete listener makes sure the information was pushed
                //successfully to the database.
                mDatabase.push().setValue(dataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this, "Stored..", Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(Register.this, "", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
    */
}















