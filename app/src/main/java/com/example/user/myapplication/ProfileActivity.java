package com.example.user.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView username;
    TextView firstName;
    TextView lastName;
    TextView email;
    TextView password;
    ListView companiesList;
    private ArrayAdapter<String> mAdapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        context = this;

        username = (TextView) findViewById(R.id.username);
        username.setText(AppUser.username);
        firstName = (TextView) findViewById(R.id.firstName);
        firstName.setText(AppUser.firstName);
        lastName = (TextView) findViewById(R.id.lastName);
        lastName.setText(AppUser.lastName);
        email = (TextView) findViewById(R.id.email);
        email.setText(AppUser.email);
        password = (TextView) findViewById(R.id.password);
        password.setText(AppUser.password);

        companiesList = (ListView) findViewById(R.id.compList);
        mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, AppUser.reservedCompanies);
        companiesList.setAdapter(mAdapter);
        companiesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent e = new Intent(context, QRGeneratorActivity.class);
                startActivity(e);
            }
        });
    }
}
