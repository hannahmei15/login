package com.lab4u.hannahchen.teacherlogin;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hannahchen on 6/30/16.
 */
public class AuthorizeUser {
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("login_type")
    private String login_type;

    public AuthorizeUser(String email, String password, String login_type){
        this.email = email;
        this.password = password;
        this.login_type = login_type;
    }
}
