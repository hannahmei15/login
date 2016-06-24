package com.lab4u.hannahchen.teacherlogin;

import android.widget.EditText;

import java.util.Hashtable;

/**
 * Created by hannahchen on 6/23/16.
 */
public class SigninPresenter implements SigninContract.Presenter {

    private SigninActivity view;
    private Hashtable db;

    public SigninPresenter(Hashtable db, SigninActivity view){
        this.db = db;
        this.view = view;
    }

    public boolean userValid(){
        EditText email = (EditText)view.findViewById(R.id.email);
        EditText password = (EditText) view.findViewById(R.id.password);
        if (db.containsKey(email.getText().toString())){
            if (db.get(email.getText().toString()).equals(password.getText().toString())){
                return true;
            }
        }
        return false;
    }
}
