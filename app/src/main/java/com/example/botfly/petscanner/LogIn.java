package com.example.botfly.petscanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class LogIn extends AppCompatActivity {

    //Creates instance of the database
    private DatabaseReference mDatabase;

    private TextView dEmail;
    private TextView dPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Email");
        dEmail = (TextView) findViewById(R.id.email_view);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Password");
        dPass = (TextView) findViewById(R.id.pass_view);

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

    public void loginClicked(View view) { //redirect to the xml page after user logs in
        setContentView(R.layout.activity_log_in);
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
