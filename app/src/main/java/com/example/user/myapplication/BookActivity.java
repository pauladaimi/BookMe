package com.example.user.myapplication;

import android.app.Activity;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by User on 5/16/2018.
 */

public class BookActivity extends Activity {
    Space space;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        Constants.SCREEN_WIDTH=dm.widthPixels;
        Constants.SCREEN_HEIGHT=dm.heightPixels;
        context=this;
        RetrofitClient.initRetrofit(this);

        ApiUtils.getBookService().getSpace("b34mx5Djv4obp7OFeTYy").enqueue(new Callback<Space>() {
            @Override
            public void onResponse(Call<Space> call, Response<Space> response) {
                if(response.isSuccessful()){
                    Log.d("BOOK ME","Successfull");
                    space=response.body();
                    Log.d("BOOK ME", response.body().toString());
                    setContentView(new BookPanel(context,space));
                }
                else{
                    Log.d("BOOK ME", response.message());
                }

            }

            @Override
            public void onFailure(Call<Space> call, Throwable t) {
                Log.d("BOOK ME", t.getMessage());
            }
        });


    }
}
