package com.example.botfly.petscanner;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.Result;

import java.util.ArrayList;
import java.util.HashMap;

import static android.R.attr.key;

public class LogIn extends AppCompatActivity {


    //Pet List View Variable
    private ListView mPetList;
    private ArrayList<String> mPetAList = new ArrayList<>();

    //Register button to store to database
    private Button register;
    private EditText firstName;
    private EditText lastName;
    private EditText emailAddress;
    private EditText password;
    private EditText confirmPassword;

    //Creates instance of the database
    private DatabaseReference mDatabase;

    private EditText dEmail;
    private EditText dPass;

    //Retrive data from database and store read values and populate the
    //the login and password fields so you can login easily.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        setTypeFace();

        /**
        mDatabase = FirebaseDatabase.getInstance().getReference().child("KigkhxVrWkZ2CI1AHEH");
        mPetList = ((ListView) findViewById(R.id.pet_list_view));

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, mPetAList);
        mPetList.setAdapter(arrayAdapter);
        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.getValue(String.class);
                mPetAList.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
         **/

        //Retrive data from database and store read values and populate the
        //the login and password fields so you can login easily.
        /**
        mDatabase = FirebaseDatabase.getInstance().getReference().child("KigjAAg2t8OvSuIJVqK");
        dEmail = (EditText) findViewById(R.id.email_view);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("KigjAAg2t8OvSuIJVqK");
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
         **/
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

    //Refreshes the Registered-Pet-List on the Pet-List page
    //Maps the button to refresh the page
    public void refreshListClicked(View view){

        mDatabase = FirebaseDatabase.getInstance().getReference();
        // This line creates a child DatabaseReference, but you don't assign
        // the child to a variable
        mDatabase.child("-KigkhxVrWkZ2CI1AHEH").child("Owner Name");

        mPetList = ((ListView) findViewById(R.id.pet_list_view));

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, mPetAList);
        mPetList.setAdapter(arrayAdapter);
        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.child("-KigkhxVrWkZ2CI1AHEH").child("Owner Name").getValue(String.class);
                mPetAList.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        setContentView(R.layout.activity_pet_list);
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
                    Toast.makeText(LogIn.this, "Registered!", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(LogIn.this, "Try Again", Toast.LENGTH_LONG).show();
                }
            }
        });
        setContentView(R.layout.activity_log_in);
        setTypeFace();
    }

    //Stores data that the user inputted from the User-Info page and stores it
    //in the database
    public void SubmitClicked(View view) {
        //creates link reference to root of database
        mDatabase = FirebaseDatabase.getInstance().getReference();

        //Creates local variable for user input on each field
        String ownerName = ((EditText) findViewById(R.id.userInfoPageOwnerName)).getText().toString().trim();
        String phoneNumber = ((EditText) findViewById(R.id.userInfoPageOwnerPhoneNumber)).getText().toString().trim();
        String altPhoneNumber = ((EditText) findViewById(R.id.userInfoPageOwnerAlternatePhoneNumber)).getText().toString().trim();
        String email = ((EditText) findViewById(R.id.userInfoPageOwnerEmailAddress)).getText().toString().trim();
        String postal = ((EditText) findViewById(R.id.userInfoPageOwnerPostalAddress)).getText().toString().trim();
        String emergencyName = ((EditText) findViewById(R.id.userInfoPageEmergencyContactName)).getText().toString().trim();
        String emergencyPhone = ((EditText) findViewById(R.id.userInfoPageEmergencyContactPhoneNumber)).getText().toString().trim();
        String emergencyEmail = ((EditText) findViewById(R.id.userInfoPageEmergencyContactEmailAddress)).getText().toString().trim();
        String petName = ((EditText) findViewById(R.id.userInfoPagePetName)).getText().toString().trim();
        String petBreed = ((EditText) findViewById(R.id.userInfoPagePetBreed)).getText().toString().trim();
        String petFood = ((EditText) findViewById(R.id.userInfoPagePetFoodAndDrink)).getText().toString().trim();
        String petMedications = ((EditText) findViewById(R.id.userInfoPagePetMedicationsAndAllergies)).getText().toString().trim();
        String petCommands = ((EditText) findViewById(R.id.userInfoPagePetKnownCommands)).getText().toString().trim();
        String petIrritate = ((EditText) findViewById(R.id.userInfoPagePetIrritations)).getText().toString().trim();

        HashMap<String, String> dataMap = new HashMap<String, String>();
        dataMap.put("Owner Name", ownerName);
        dataMap.put("Owner Phone", phoneNumber);
        dataMap.put("Owner Alt Phone", altPhoneNumber);
        dataMap.put("Owner Email", email);
        dataMap.put("Owner Postal", postal);
        dataMap.put("Emergency Name", emergencyName);
        dataMap.put("Emergency Email", emergencyEmail);
        dataMap.put("Emergency Phone", emergencyPhone);
        dataMap.put("Pet Name", petName);
        dataMap.put("Pet Breed", petBreed);
        dataMap.put("Pet Food", petFood);
        dataMap.put("Pet Medications", petMedications);
        dataMap.put("Pet Commands", petCommands);
        dataMap.put("Pet Irritate", petIrritate);

        //Push Hash Object to root of Database
        //The on-complete listener makes sure the information was pushed
        //successfully to the database.
        mDatabase.push().setValue(dataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(LogIn.this, "Registered!", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(LogIn.this, "Try Again", Toast.LENGTH_LONG).show();
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

    public void loginScannerClicked (View view) {
        setContentView(R.layout.content_scanner);
    }

    public void InfoPageSubmitButton (View view) {
        setContentView(R.layout.activity_buy_collar);
    }

    public void scannerLogInButton(View view) {
        setContentView(R.layout.activity_log_in);
        setTypeFace();
    }

    public void scannerOnClick(View view) {

    }

    public void onPause() {

    }


    public void handleResult(Result result) {

    }

    public void scannerRegisterButton(View view) {
        setContentView(R.layout.activity_register);
    }

}
