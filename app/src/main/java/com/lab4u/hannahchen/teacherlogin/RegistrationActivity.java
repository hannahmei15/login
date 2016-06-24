package com.lab4u.hannahchen.teacherlogin;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity implements RegistrationContract.View{
    private Button submitButton;
    private EditText email;
    private EditText password;
    private RegistrationPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        submitButton = (Button) findViewById(R.id.submitButton);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        //create the presenter
        presenter = new RegistrationPresenter(this);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.initRegisterLab4UApplication();
                }
        });
    }

    //methods for the view
    @Override
    public void showInvalid(){
        Toast.makeText(getApplicationContext(), "Email Address is Invalid. Try Again.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showRegistration(){
        password.setKeyListener(null);
        email.setKeyListener(null);
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout,
                (ViewGroup) findViewById(R.id.registration_toast));

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, Gravity.CENTER_HORIZONTAL,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    @Override
    public String getEmail(){
        return String.valueOf(((EditText)findViewById(R.id.email)).getText());
    }

    @Override
    public void onCompleteRegisterLoginLab4UApplication() {
        showRegistration();
        //change to a new blank window
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(RegistrationActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        }, 3800);
    }


    @Override
    public String getPassword(){
        return String.valueOf(((EditText)findViewById(R.id.password)).getText());
    }

    @Override
    public void clearText(){
        email.setText("");
        password.setText("");
    }



}
