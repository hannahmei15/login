package com.lab4u.hannahchen.teacherlogin;

import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hannahchen on 6/22/16.
 */
public class RegistrationPresenter implements RegistrationContract.Presenter {

    private Hashtable db;

    private RegistrationContract.View view;

    public RegistrationPresenter(RegistrationContract.View view){
        db = DataBase.dataBase;
        this.view = view;
    }

    @Override
    public boolean isValid(String email){
        if (email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")){
            return true;
        }
        return false;
    }

    @Override
    public void addUser(){
        String email = view.getEmail();
        String password = view.getPassword();
        db.put(email, password);
    }

//    public void getPassword(){
//        userPass =  view.findViewById(R.id.password).toString();
//    }

    //for testing
//    public void setFields(String e,String p){
//        userEmail = e;
//        userPass = p;
//    }

//    public DataBase getDB(){
//        return dataBase;
//    }

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



}
