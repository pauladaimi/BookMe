package com.example.user.myapplication;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private Button search;

    EditText editText;

    private ListView listView;
    private ArrayAdapter<String> mAdapter;

    private TextView mTextMessage;
    private ImageView imageView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText("Search");
                    return true;
                case R.id.navigation_dashboard:
                    //mTextMessage.setText("Profile");
                    return true;
                case R.id.navigation_notifications:
                    setContentView(R.layout.profile_acitivity);
                    return true;
            }
            return false;
        }
    };

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView) findViewById(R.id.imageView);
        search=(Button) findViewById(R.id.searchBtn);
        editText=(EditText) findViewById(R.id.editText);

        listView=(ListView) findViewById(R.id.listView);
        mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);

        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editText.setText(""+i);
            }
        });

        mAdapter.add("Karim");
        mAdapter.add("Paul");

        mAdapter.notifyDataSetChanged();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap = Bitmap.createBitmap(1000,500,Bitmap.Config.ARGB_8888);

                Canvas canvas = new Canvas(bitmap);

                canvas.drawColor(Color.BLUE);
                Rect rect = new Rect(50,50,canvas.getWidth()-50,canvas.getHeight()-50);
                Paint paint = new Paint();
                paint.setColor(Color.GREEN);

                canvas.drawRect(rect,paint);
                imageView.setImageBitmap(bitmap);
            }
        });

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        Constants.SCREEN_WIDTH = dm.widthPixels;
        Constants.SCREEN_HEIGHT = dm.heightPixels;

    }


}
