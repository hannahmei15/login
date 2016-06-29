package com.lab4u.hannahchen.teacherlogin;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by hannahchen on 6/28/16.
 */
public interface WebService {
    @POST("/api/users/register")
    void createUser(@Body User user, Callback<String> callback);

//    @GET("/api/ping/")
//    void getInfo(Callback<ExampleResponse> callback);
}
