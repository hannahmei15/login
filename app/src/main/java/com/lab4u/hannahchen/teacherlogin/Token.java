package com.lab4u.hannahchen.teacherlogin;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hannahchen on 7/1/16.
 */
public class Token {
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    @SerializedName("token")
    private String accessToken;

    public Token(String accessToken){
        this.accessToken = accessToken;
    }
}
