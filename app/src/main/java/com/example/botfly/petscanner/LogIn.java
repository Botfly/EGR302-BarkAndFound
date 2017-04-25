package com.example.botfly.petscanner;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.HashMap;

public class LogIn extends AppCompatActivity {


    private Button register;
    private EditText firstName;
    private EditText lastName;
    private EditText emailAddress;
    private EditText password;
    private EditText confirmPassword;

    //Creates instance of the database
    //private DatabaseReference mDatabase;


    //Creates instance of the database
    private DatabaseReference mDatabase;

    private EditText dEmail;
    private EditText dPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        setTypeFace();

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Email");
        dEmail = (EditText) findViewById(R.id.email_view);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Password");
        dPass = (EditText) findViewById(R.id.pass_view);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String email = dataSnapshot.getValue().toString();
                String pass = dataSnapshot.getValue().toString();

                dEmail.setText(email);
                dPass.setText(pass);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void setTypeFace() {
        Typeface segoe = Typeface.createFromAsset(getAssets(), "fonts/Segoe_Print.ttf");
        TextView tv = (TextView) findViewById(R.id.textView_appNameLogInScreen);
        TextView tv2 = (TextView) findViewById(R.id.email_view);
        TextView tv3 = (TextView) findViewById(R.id.pass_view);
        tv.setTypeface(segoe);
//        tv2.setTypeface(segoe);
//        tv3.setTypeface(segoe);
    }


    public void loginClicked(View view) { //redirect to the xml page after user logs in
        setContentView(R.layout.activity_pet_list);
        System.out.println("log in clicked");
    }

    public void signUpClicked(View view) { //redirect to Sign Up xml page
        setContentView(R.layout.activity_register);
        System.out.println("sign up clicked");
    }

    public void forgotPasswordClicked(View view) { //redirect to Forgot Password xml page
        setContentView(R.layout.activity_forgot_password);
        System.out.println("forgot password clicked");
    }

    public void cancelClicked(View view) {
        setContentView(R.layout.activity_log_in);
        setTypeFace();
        System.out.println("Cancel clicked.");
    }

    public void sendEmailClicked(View view) {
        EditText emailEditText = (EditText) findViewById(R.id.editText_enterEmail);
        if (!emailEditText.getText().toString().matches("")) {
            setContentView(R.layout.activity_email_sent);
            //TODO: send email to the email entered
        }
    }

    public void backToLoginClicked(View view) {
        setContentView(R.layout.activity_log_in);
        setTypeFace();
    }

    public void cancelForgotPasswordClicked(View view) {
        setContentView(R.layout.activity_log_in);
        setTypeFace();
    }

    public void registerClicked(View view) {
        //creates link reference to root of database
        mDatabase = FirebaseDatabase.getInstance().getReference();
        //Creates link reference to root of a specific user
        //mDatabase = FirebaseDatabase.getInstance().getReference().getchild("User_01");

        //Creates local variable for user input on each field
        String name = ((EditText) findViewById(R.id.first_name)).getText().toString().trim();
        String lName = ((EditText) findViewById(R.id.last_name)).getText().toString().trim();
        String mail = ((EditText) findViewById(R.id.email_address)).getText().toString().trim();
        String pass = ((EditText) findViewById(R.id.confirm_password)).getText().toString().trim();

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
                    //Toast.makeText(Register.this, "Stored..", Toast.LENGTH_LONG).show();
                }else {
                    //Toast.makeText(Register.this, "", Toast.LENGTH_SHORT).show();
                }
            }
        });
        setContentView(R.layout.activity_log_in);
        setTypeFace();
    }

    public void petlistToInfoButton(View view) {
        setContentView(R.layout.activity_user_info2);
    }

    public void petlistBackButton(View view) {
        setContentView(R.layout.activity_log_in);
        setTypeFace();
    }

    public void infoPageBackButton(View view) {
        setContentView(R.layout.activity_pet_list);
    }

    public void loginScannerClicked(View view) {
        setContentView(R.layout.content_scanner);
    }

    public void scannerLogInButton(View view) {
        setContentView(R.layout.activity_log_in);
        setTypeFace();
    }

    public void scannerQRscanClicked(View view) {
        //todo: Do something when the scan QR code button is pressed
        // (scan the QR code then store it etc)
    }

    public void scannerRegisterButton(View view) {
        setContentView(R.layout.activity_register);
    }

}
