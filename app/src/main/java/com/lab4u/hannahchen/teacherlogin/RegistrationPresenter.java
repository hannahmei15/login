package com.lab4u.hannahchen.teacherlogin;

import android.util.Log;
import android.widget.EditText;

import com.squareup.okhttp.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import retrofit.Callback;
import retrofit.RetrofitError;

/**
 * Created by hannahchen on 6/22/16.
 */
public class RegistrationPresenter implements RegistrationContract.Presenter {

    private Hashtable db;

    private RegistrationContract.View view;
    private WebService mWebService;

    public RegistrationPresenter(RegistrationContract.View view, WebService webService){
        db = DataBase.dataBase;
        this.view = view;
        this.mWebService = webService;
    }

    @Override
    public boolean isValid(String email){
        if (email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")){
            return true;
        }
        return false;
    }

    @Override
    public void initRegisterLab4UApplication(){
        if (isValid(view.getEmail())){
            view.onCompleteRegisterLoginLab4UApplication();
            addUser();
        }
        else{
            view.showInvalid();
            view.clearText();
        }
    }

    /**
     * Adds a new user to the database
     */
    @Override
    public void addUser(){
        String email = view.getEmail();
        String password = view.getPassword();
        String first_name = view.getFirstName();
        String last_name = view.getLastName();
        String gender = view.getGender().toUpperCase();
        String type = view.getType().toUpperCase();
        String language = view.getLanguage();

        User newUser = new User(email, first_name, gender, "", language, last_name, "LAB4U", password, "", type);
        Log.d("RegistrationPresenter", newUser.toString());
        mWebService.createUser(newUser, new Callback<String>() {
            @Override
            public void success(String s, retrofit.client.Response response) {

            }
            @Override
            public void failure(RetrofitError error) {
            }
        });
//        db.put(email, password);
    }

}
