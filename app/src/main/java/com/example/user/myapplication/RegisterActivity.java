package com.example.user.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class RegisterActivity extends AppCompatActivity {

    EditText editName, editLastName, editEmail, editPassword, editUsername;
    Button registerBtn;
    Context context;
    AppUser appUser;
    String firstName, lastName, email, password, username;
    TextView errorMessage;

    FirebaseUser firebaseUser;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth = FirebaseAuth.getInstance();

        context = this;

        editName = (EditText) findViewById(R.id.editText2);
        editName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editName.setText("");
            }
        });

        editLastName = (EditText) findViewById(R.id.editText3);
        editLastName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editLastName.setText("");
            }
        });

        editEmail = (EditText) findViewById(R.id.editText7);
        editEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editEmail.setText("");
            }
        });

        editPassword = (EditText) findViewById(R.id.editText6);
        editPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPassword.setText("");
            }
        });

        editUsername = (EditText) findViewById(R.id.editText8);
        editUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editUsername.setText("");
            }
        });

        errorMessage = (TextView)findViewById(R.id.textView5);
        registerBtn = findViewById(R.id.button);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName = editName.getText().toString();
                lastName = editLastName.getText().toString();
                email = editEmail.getText().toString();
                password = editPassword.getText().toString();
                username = editUsername.getText().toString();


                if(firstName.isEmpty()) {
                    System.out.println("Missing Name");
                    errorMessage.setText("Missing Name");
                } else if (lastName.isEmpty()) {
                    System.out.println("Missing Last Name");
                    errorMessage.setText("Missing Last Name");
                } else if (email.isEmpty()) {
                    System.out.println("Missing Email");
                    errorMessage.setText("Missing E-mail");
                } else if (password.isEmpty()) {
                    System.out.println("Missing Password");
                    errorMessage.setText("Missing Password");
                } else if (username.isEmpty()) {
                    System.out.println("Missing Username");
                    errorMessage.setText("Missing Username");
                } else {
                    appUser = new AppUser(firstName, lastName, email, password, username);
                    System.out.println("Register");

                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            firebaseUser = auth.getCurrentUser();

                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(firstName + " " + lastName )
                                    .build();

                            firebaseUser.updateProfile(profileUpdates)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {

                                            }
                                        }
                                    });

                            Intent e = new Intent(context, MenuActivity.class);
                            startActivity(e);
                        }
                    });


                }


            }
        });
    }

}
