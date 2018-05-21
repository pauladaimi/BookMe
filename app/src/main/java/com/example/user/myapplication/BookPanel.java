package com.example.user.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

/**
 * Created by User on 5/16/2018.
 */

public class BookPanel extends SurfaceView implements SurfaceHolder.Callback{
//    private BookThread thread;

    ArrayList<Spot> spots;
    Canvas canvas;
    SurfaceHolder surface;
    public BookPanel(Context context, Space space) {
        super(context);
//        thread = new BookThread(getHolder(),this);
        spots = new ArrayList<Spot>();
        spots.addAll(space.getSpots());
        double ratio = 0;
        for(int i=0;i<spots.size();i++){
            spots.get(i).setX(spots.get(i).getX()*Constants.SCREEN_WIDTH);
            //ratio = spots.get(i).getX() / spots.get(i).getY();
            System.out.println("RATIO:       " + ratio);
            spots.get(i).setY(spots.get(i).getY()*Constants.SCREEN_HEIGHT);
            spots.get(i).setH(spots.get(i).getH()*Constants.SCREEN_HEIGHT);
            spots.get(i).setW(spots.get(i).getW()*Constants.SCREEN_WIDTH);
        }
        Log.d("BOOOOOK ME", spots.get(1).getX()+" "+ spots.get(1).getW());
        getHolder().addCallback(this);
        setFocusable(true);
    }

    private void initCanvas(){
        surface=getHolder();
        canvas =surface.lockCanvas();
        draw(canvas);
        surface.unlockCanvasAndPost(canvas);
    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        canvas.drawColor(Color.WHITE);

        for(int i=0; i<spots.size();i++){
            spots.get(i).draw(canvas);
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
//        thread.start();
        initCanvas();

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}
