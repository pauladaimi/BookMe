package com.example.user.myapplication;

/**
 * Created by marna on 2/25/2018.
 */

public class ApiUtils {

    public static final String BASE_URL = "https://bookme437.herokuapp.com/";

    public static BookService getBookService() {
        return RetrofitClient.getClient(BASE_URL).create(BookService.class);
    }

}
