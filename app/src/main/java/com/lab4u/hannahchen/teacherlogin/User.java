package com.lab4u.hannahchen.teacherlogin;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a user by his/her first and last name, email, password, gender, email,
 * language, login type, type of user, and third party id
 * Created by hannahchen on 6/28/16.
 */
public class User {
    @SerializedName("email")
    private String email;

    @SerializedName("first_name")
    private String first_name;

    @SerializedName("gender")
    private String gender;

    @SerializedName("image")
    private String image;

    @SerializedName("language")
    private String language;

    @SerializedName("last_name")
    private String last_name;

    @SerializedName("login_type")
    private String login_type;

    @SerializedName("password")
    private String password;

    @SerializedName("third_party_id")
    private String third_party_id;

    @SerializedName("type")
    private String type;

    public User(String email, String first_name, String gender, String image, String language, String last_name,
                String login_type, String password, String third_party_id, String type){
        this.email = email;
        this.first_name = first_name;
        this.gender = gender;
        this.image = image;
        this.language = language;
        this.last_name = last_name;
        this.login_type = login_type;
        this.password = password;
        this.third_party_id = third_party_id;
        this.type = type;
    }

    @Override
    public String toString(){
        return email + " " + first_name + " " + gender + " " + image + " " + language
                + " " + last_name  + " " + login_type  + " " + password  + " " + third_party_id  + " " + type;
    }
}
