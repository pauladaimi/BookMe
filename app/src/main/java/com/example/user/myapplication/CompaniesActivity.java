package com.example.user.myapplication;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompaniesActivity extends AppCompatActivity {//ListActivity {

    Context context;
    ListView companies;
    private ArrayAdapter<String> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companies);

        context = this;

        String[] companiesList = new String[] {
                "437's Kitchen",
                "437's 7 stars Hotel"
        };

        List<String> comp = new ArrayList<String>(Arrays.asList(companiesList));
        companies = (ListView) findViewById(R.id.compList);
        mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, comp);
        companies.setAdapter(mAdapter);
        companies.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AppUser.reservedCompanies.add("437's Kitchen");
                Intent e = new Intent(context, BookActivity.class);
                startActivity(e);
            }
        });
    }
}
