package com.example.user.myapplication;

import android.graphics.Canvas;
import android.graphics.Rect;

public class Chair extends Spot{
    private Rect rectangle;

    public Chair(int ID, int X, int Y, int width, int height, Shape shape, int color) {
        super(ID, X, Y, width, height, shape, color);
    }

}
