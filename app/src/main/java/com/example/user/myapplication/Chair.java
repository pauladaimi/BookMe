package com.example.user.myapplication;

<<<<<<< HEAD
public class Chair {
=======
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


>>>>>>> 27aebe687272e2064697e5ebd96a576d3ea9fb6b

}
