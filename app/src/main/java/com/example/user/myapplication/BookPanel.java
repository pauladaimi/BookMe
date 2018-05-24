package com.example.user.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by AppUser on 5/16/2018.
 */

public class BookPanel extends SurfaceView implements SurfaceHolder.Callback{
//    private BookThread thread;


    ArrayList<Spot> spots;


    static ArrayList<Integer> reservedSpotsIDs = new ArrayList<Integer>();
    Canvas canvas;
    SurfaceHolder surface;
    Context context;
    Rect r;

    boolean isPortrait = false;


    public BookPanel(Context context, Space space) {
        super(context);
        spots = new ArrayList<Spot>();
        spots.addAll(space.getSpots());
        double ratio = 1;

        this.context = context;



        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            ratio = 2;
            isPortrait = true;
        }


        for(int i=0;i<spots.size();i++){

            spots.get(i).setX(spots.get(i).getX()*Constants.SCREEN_WIDTH);
            spots.get(i).setY(spots.get(i).getY()*Constants.SCREEN_HEIGHT/ratio + 0.05*Constants.SCREEN_HEIGHT );
            spots.get(i).setH(spots.get(i).getH()*Constants.SCREEN_HEIGHT/ratio);
            spots.get(i).setW(spots.get(i).getW()*Constants.SCREEN_WIDTH);

        }
        Log.d("BOOOOOK ME", spots.get(1).getX()+" "+ spots.get(1).getW());
        getHolder().addCallback(this);
        setFocusable(true);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // MotionEvent object holds X-Y values
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            String text = "You clicked at x = " + event.getX() + " and y = " + event.getY();
            System.out.println(text);

            double spotX = 0;
            double spotWidth = 0;
            double spotY = 0;
            double spotHeight = 0;

            for(int i=0;i<spots.size();i++) {
                spotX = spots.get(i).getX();
                spotWidth = spots.get(i).getW();
                spotY = spots.get(i).getY();
                spotHeight = spots.get(i).getH();

                if(event.getX() > spotX && event.getX() < (spotWidth + spotX) ) {
                    if(event.getY() > Math.abs(spotY) && event.getY() < (spotHeight + Math.abs(spotY)) ) {
                        text = "You clicked at a spot! x = " + event.getX() + " and y = " + event.getY();
                        System.out.println(text);

                        if (reservedSpotsIDs.size() == 0) {
                            reservedSpotsIDs.add(spots.get(i).getId());

                            initCanvas();

                        } else if (reservedSpotsIDs.size() > 0) {
                           boolean duplicateID = false;
                            for (int j = 0; j < reservedSpotsIDs.size(); j++) {
                                if ((reservedSpotsIDs.get(j) == spots.get(i).getId()) ) {
                                    duplicateID = true;
                                }
                            }

                            if(!duplicateID) {
                                reservedSpotsIDs.add(spots.get(i).getId());
                                initCanvas();

                            }
                        }

                        for (int j = 0; j < reservedSpotsIDs.size(); j++) {
                            System.out.println("                    Reserved Spots: " + reservedSpotsIDs.get(j));
                        }



                        System.out.println("                You have reserved: " + spots.get(i).getId());
                        System.out.println("                You have reserved: " + reservedSpotsIDs.size() + " spots");






                    }
                }

            }

            if(isPortrait) {
                if (event.getX() > r.left && event.getX() < (r.left + r.width())) {
                    if (event.getY() > r.bottom && event.getY() < (Math.abs(r.height()) + r.bottom)) {

                        if (reservedSpotsIDs.size() > 0) {
                            Intent myIntent = new Intent(context, DateActivity.class);

                            context.startActivity(myIntent);
                        }
                    }

                }
            }
        }

        return super.onTouchEvent(event);
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


        boolean drawNormal = true;
        for(int i=0; i<spots.size();i++){
            drawNormal = true;
            for(int j = 0; j < reservedSpotsIDs.size(); j++){
                if(spots.get(i).getId() == reservedSpotsIDs.get(j)) {
                    spots.get(i).draw(canvas, Color.RED);
                    drawNormal = false;
                    break;
                }
            }
            if(drawNormal) {
                spots.get(i).draw(canvas, Color.GRAY);

            }

        }


        if(isPortrait) {

            Paint paint = new Paint();
            paint.setTextSize(70);
            paint.setColor(Color.MAGENTA);
            canvas.drawText(AppUser.username, (int) (0.75 * Constants.SCREEN_WIDTH), (int) (0.035 * Constants.SCREEN_HEIGHT), paint);

            paint.setTextSize(canvas.getWidth() / 15);
            drawCenterText(canvas, paint, "Make Reservation", false);

        } else {

            Paint paint = new Paint();
            paint.setTextSize(70);
            paint.setColor(Color.MAGENTA);
            canvas.drawText(AppUser.username, (int) (0.75 * Constants.SCREEN_WIDTH), (int) (0.07 * Constants.SCREEN_HEIGHT), paint);



        }
    }

    private Rect rect = new Rect();

    private void drawCenterText(Canvas canvas, Paint paint, String text, boolean space) {
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.getClipBounds(rect);
        int cHeight = rect.height();
        int cWidth = rect.width();
        paint.getTextBounds(text, 0, text.length(), rect);
        float x = cWidth / 2f - rect.width() / 2f - rect.left;
        float y = cHeight / 2f + rect.height() / 2f - rect.bottom;
        System.out.println(cHeight + "          " + cWidth);

        r = new Rect((int)x, (int)(y+Constants.SCREEN_HEIGHT / 7.9), (int)(cWidth/1.3), (int)(cHeight/1.7));
        paint.setColor(Color.GRAY);
        canvas.drawRect(r,paint);

        paint.setColor(Color.BLUE);
        if(space) {
            canvas.drawText(text, x, y, paint);
        } else {
            canvas.drawText(text, x, y + Constants.SCREEN_HEIGHT / 9, paint);
        }

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {


        initCanvas();

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}
