package com.lab4u.hannahchen.teacherlogin;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;

/**
 * Created by hannahchen on 6/28/16.
 */
public interface WebService {

    @POST("/api/users/register")
    void createUser(@Body User user, Callback<Token> callback);


    @POST("/auth/local")
    @FormUrlEncoded
    void authorize(@Field("email") String email, @Field("password") String password,
            @Field("login_type") String login_type, Callback<Token> callback);

    @GET("/api/ping/fastping")
    void getResponse(Callback<ExampleResponse> callback);

}
