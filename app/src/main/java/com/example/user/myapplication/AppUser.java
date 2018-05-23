package com.example.user.myapplication;

/**
 * Created by karimbouyounes on 5/22/18.
 */

public class AppUser {

    private String name;
    private String lastName;
    private String email;
    static String username;
    private String password;


    AppUser(String name, String lastName, String email, String password, String username) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.username = username;

    }

    public String getPassword() {
        return password;
    }




}
