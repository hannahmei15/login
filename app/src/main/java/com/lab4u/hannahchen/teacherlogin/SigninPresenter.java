package com.lab4u.hannahchen.teacherlogin;

import android.content.Intent;
import android.widget.EditText;

import java.util.Hashtable;

/**
 * Created by hannahchen on 6/23/16.
 */
public class SigninPresenter implements SigninContract.Presenter {

    private SigninContract.View view;
    private Hashtable db;

    public SigninPresenter(Hashtable db, SigninContract.View view){
        this.db = db;
        this.view = view;
    }

    /**
     *
     * @return
     */
    public boolean userValid(){
        String email = view.getEmail();
        String password = view.getPasword();
        if (db.containsKey(email)){
            if (db.get(email).equals(password)){
                return true;
            }
        }
        return false;
    }

    /**
     *
     */
    @Override
    public void initLoginLab4UApplication() {
        if (userValid()){
            view.onCompleteInitLoginLab4UApplication();
        }
        else{
            view.showNoAccount();
            view.cleanPassword();
        }
    }

    @Override
    public void initLoginLab4UApplication(String email, String password) {

    }
}
