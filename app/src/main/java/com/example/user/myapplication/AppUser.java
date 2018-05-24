package com.example.user.myapplication;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by karimbouyounes on 5/22/18.
 */

public class AppUser {

    static String firstName;
    static String lastName;
    static String email;
    static String username;
    static String password;

    static ArrayList<String> reservedCompanies = new ArrayList<String>();
    static Bitmap qrCode;


    AppUser(String firstName, String lastName, String email, String password, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.username = username;

    }






}
