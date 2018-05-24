package com.example.user.myapplication;

/**
 * Created by marna on 2/25/2018.
 */

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface BookService {

//    @GET("/newsfeed")
//    Call<List<NewsItem>> getNewsfeed();

    @GET("/spaces/{id}")
    Call<Space> getSpace(@Path("id")String id);

    @POST("/reservations")
    Call<String> makeReservation(@Body Reservation reservation);

    @GET("/spaces")
    Call<List<Space>> getSpaces();
}
