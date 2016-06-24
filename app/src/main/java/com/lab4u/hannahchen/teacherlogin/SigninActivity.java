package com.lab4u.hannahchen.teacherlogin;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Hashtable;

/**
 * Created by hannahchen on 6/23/16.
 */
public class SigninActivity extends AppCompatActivity implements SigninContract.View{
    private Button logInButton;
    private EditText email;
    private EditText password;
    private Button registerButton;
    private SigninPresenter presenter;
    public static Hashtable dataBase = new Hashtable();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        logInButton = (Button) findViewById(R.id.logInButton);
        registerButton = (Button) findViewById(R.id.newUser);
        registerButton.setPaintFlags(registerButton.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        //create the presenter
        presenter = new SigninPresenter(dataBase, this);


        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (presenter.userValid()){
                    Intent i = new Intent(SigninActivity.this, BlankActivity.class);
                    startActivity(i);
                }
                else{
                    showNoAccount();
                    password.setText("");
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SigninActivity.this, RegistrationActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void showNoAccount(){
        Toast.makeText(getApplicationContext(), "Username or Password is incorrect", Toast.LENGTH_LONG).show();
    }


}
