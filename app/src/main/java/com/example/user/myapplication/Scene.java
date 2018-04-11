package com.example.user.myapplication;

import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * Created by karimbouyounes on 4/10/18.
 */

public interface Scene {
    public void update(); //updates scene
    public void draw(Canvas canvas);   //draws scene
    public void terminate(); //terminates scene
    public void receiveTouch(MotionEvent event); //waits for touch events
}
