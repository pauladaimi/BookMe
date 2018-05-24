package com.example.user.myapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.text.format.DateFormat;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    Button b_pick;
    Button qrGenerator;
    TextView tv_result;
    TextView tv_result2;
    TextView command;

    int counter = -1;


    Context context;


    int day, month, year, hour, minute;
    int startDayFinal, startMonthFinal, startYearFinal, startHourFinal, startMinuteFinal;
    int endDayFinal, endMonthFinal, endYearFinal, endHourFinal, endMinuteFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        context = this;

        b_pick = (Button) findViewById(R.id.b_pick);
        qrGenerator = (Button) findViewById(R.id.qrGenerator);
        tv_result = (TextView) findViewById(R.id.tv_result);
        tv_result2 = (TextView) findViewById(R.id.tv_result2);
        command = (TextView) findViewById(R.id.command);



        b_pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);
                counter ++;
                DatePickerDialog datePickerDialog = new DatePickerDialog(DateActivity.this, DateActivity.this, year, month, day);
                datePickerDialog.show();
            }
        });

        qrGenerator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(counter > 0){
                    Intent e = new Intent(context, QRGeneratorActivity.class);
                    startActivity(e);
                }
            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

        if(counter == 0) {
            startYearFinal = i;
            startMonthFinal = i1 + 1;
            startDayFinal = i2;

            Calendar c = Calendar.getInstance();
            hour = c.get(Calendar.HOUR_OF_DAY);
            minute = c.get(Calendar.MINUTE);

        } else if (counter == 1) {
            endYearFinal = i;
            endMonthFinal = i1 + 1;
            endDayFinal = i2;

            Calendar c = Calendar.getInstance();
            hour = c.get(Calendar.HOUR_OF_DAY);
            minute = c.get(Calendar.MINUTE);

        }

        TimePickerDialog timePickerDialog = new TimePickerDialog(DateActivity.this, DateActivity.this, hour, minute, DateFormat.is24HourFormat(this));
        timePickerDialog.show();

    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {

        if(counter == 0) {
            startHourFinal = i;
            startMinuteFinal = i1;

            tv_result.setText("Start Date: " + "\n" +
                    "Year:   " + startYearFinal + "\n" +
                    "Month:  " + startMonthFinal + "\n" +
                    "Day:    " + startDayFinal + "\n" +
                    "Hour:   " + startHourFinal + "\n" +
                    "Minute: " + startMinuteFinal);

            command.setText("Pick End Date");
            String startDate =  startMonthFinal + "/" + startDayFinal + "/" + startYearFinal + " " + startHourFinal + ":" + startMinuteFinal;

            try {
                Long startDateMillis = new SimpleDateFormat("MM/dd/yyyy hh:mm").parse(startDate).getTime();
                System.out.println(" Start Date Epoch time in millis: " + startDateMillis);
            }catch (ParseException e) {
                e.printStackTrace();
            }

        } else if (counter == 1) {
            endHourFinal = i;
            endMinuteFinal = i1;

            tv_result2.setText("End Date: " + "\n" +
                    "Year:   " + endYearFinal + "\n" +
                    "Month:  " + endMonthFinal + "\n" +
                    "Day:    " + endDayFinal + "\n" +
                    "Hour:   " + endHourFinal + "\n" +
                    "Minute: " + endMinuteFinal);

            String endDate =  endMonthFinal + "/" + endDayFinal + "/" + endYearFinal + " " + endHourFinal + ":" + endMinuteFinal;
            try {
                Long startDateMillis = new SimpleDateFormat("MM/dd/yyyy hh:mm").parse(endDate).getTime();
                System.out.println(" End Date Epoch time in millis: " + startDateMillis);
            }catch (ParseException e) {
                e.printStackTrace();
            }
        }


    }



}
