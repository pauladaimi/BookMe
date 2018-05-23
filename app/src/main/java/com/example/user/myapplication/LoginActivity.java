package com.example.user.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by AppUser on 5/16/2018.
 */

public class LoginActivity extends AppCompatActivity {
    Button loginBtn;
    Button registerBtn;
    Context context;
    EditText username, password;
    TextView errorMessage;
    String userUsername;
    String userPassword;
    AppUser appUser = new AppUser("Karim", "Bou Younes", "kab13@mail.aub.edu", "Karim", "Karim");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        Constants.SCREEN_WIDTH = dm.widthPixels;
        Constants.SCREEN_HEIGHT = dm.heightPixels;

        context = this;

        username = (EditText)findViewById(R.id.editText4);
        password = (EditText)findViewById(R.id.editText5);
        errorMessage = (TextView)findViewById(R.id.textView4);
        loginBtn = findViewById(R.id.button3);
        registerBtn = findViewById(R.id.button2);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userUsername = username.getText().toString();
                userPassword = password.getText().toString();

                if(userUsername.isEmpty()){
                    System.out.println(         "Missing Username");
                    errorMessage.setText("Missing Username");
                } else if(userPassword.isEmpty()) {
                    System.out.println(         "Missing Password");
                    errorMessage.setText("Missing Password");
                } else if(!userUsername.equals(AppUser.username)){ //replace with search in the database
                    System.out.println(         "Wrong Username");
                    errorMessage.setText("Wrong Username");
                } else if (!userPassword.equals(appUser.getPassword())) { //replace with search in the database
                    System.out.println(         "Wrong Password");
                    errorMessage.setText("Wrong Password");
                } else {
                    Intent e = new Intent(context,BookActivity.class);
                    //Intent e = new Intent(context,DateActivity.class);
                    startActivity(e);
                }

            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Register");
                Intent e = new Intent(context,RegisterActivity.class);
                startActivity(e);


            }
        });


    }
}
