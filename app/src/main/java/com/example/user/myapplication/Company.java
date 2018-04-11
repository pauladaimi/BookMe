package com.example.user.myapplication;

import java.util.ArrayList;

/**
 * Created by User on 4/10/2018.
 */

public class Company{
    String name;
    ArrayList<Room> rooms;

    String type; //Change to enum

    public Company(ArrayList<Room> rooms){
        this.rooms=rooms;
    }

}
