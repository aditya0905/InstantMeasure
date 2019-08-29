package com.example.instantmeasure;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class AcitvitySignup extends AppCompatActivity {

/////////////////////////////////////////////////////////////////
    //Set display name for each user
    ///////////////////////////////////////
        public EditText emailId, passwd;
        Button btnSignUp,signIn;



        FirebaseAuth firebaseAuth;
        TextView err;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_signup);
            firebaseAuth = FirebaseAuth.getInstance();
            emailId = findViewById(R.id.loginemail);
            passwd = findViewById(R.id.loginpswd);
            btnSignUp = findViewById(R.id.btnlogin);
            signIn = findViewById(R.id.btnsignup);
            err = findViewById(R.id.tv_errli);

            btnSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String emailID = emailId.getText().toString();
                    String paswd = passwd.getText().toString();
                    if (emailID.isEmpty()) {
                        emailId.setError("Provide your Email first!");
                        emailId.requestFocus();
                    } else if (paswd.isEmpty()) {
                        passwd.setError("Set your password");
                        passwd.requestFocus();
                    } else if (emailID.isEmpty() && paswd.isEmpty()) {
                        emailId.setError("Provide your Email first!");
                        emailId.requestFocus();

                        passwd.setError("Set your password");
                        passwd.requestFocus();

                        //Toast.makeText(AcitvitySignup.this, "Fields Empty!", Toast.LENGTH_SHORT).show();
                    } else if (!(emailID.isEmpty() && paswd.isEmpty())) {
                        firebaseAuth.createUserWithEmailAndPassword(emailID, paswd).addOnCompleteListener(AcitvitySignup.this, new OnCompleteListener() {
                            @Override
                            public void onComplete(@NonNull Task task) {

                                if (!task.isSuccessful()) {

                                    err.setText("Sign Up Not Sucessfull :"+task.getException().getMessage());



                                } else {


                                    startActivity(new Intent(AcitvitySignup.this, Home.class));


                                }
                            }
                        });
                    } else {
                        Toast.makeText(AcitvitySignup.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            signIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent I = new Intent(AcitvitySignup.this, ActivityLogin.class);
                    startActivity(I);
                }
            });
        }



    }



