package com.example.user.myapplication;

import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.ArrayList;

/**
 * Created by karimbouyounes on 4/10/18.
 */

public class SceneManager {


    private ArrayList<Scene> scenes = new ArrayList<>(); //array of lists
    public static int ACTIVE_SCENE; //this indicates an active scene


    //constructor
    public SceneManager() {
        ACTIVE_SCENE = 0;
        scenes.add(new Home());
    }


    //waits for touch events
    public void recieveTouch(MotionEvent event) {
        scenes.get(ACTIVE_SCENE).receiveTouch(event);
    }


    //updtaes scene
    public void update() {
        scenes.get(ACTIVE_SCENE).update();
    }


    //draws scene
    public void draw(Canvas canvas) {
        scenes.get(ACTIVE_SCENE).draw(canvas);
    }

}
