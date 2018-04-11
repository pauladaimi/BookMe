package com.example.user.myapplication;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Chair extends Spot{
    private Rect rectangle;

    public void draw(Canvas canvas)  {
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        canvas.drawRect(rectangle, paint);
    }



}
