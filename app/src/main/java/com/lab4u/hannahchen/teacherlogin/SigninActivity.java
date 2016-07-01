package com.lab4u.hannahchen.teacherlogin;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.preference.Preference;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Hashtable;
import java.util.ServiceConfigurationError;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hannahchen on 6/23/16.
 */

@TargetApi(11)
public class SigninActivity extends Activity implements SigninContract.View{
//    @BindView(R.id.logInButton) Button logInButton;
    private Button logInButton;
    private EditText email;
    private EditText password;
    private Button registerButton;
    private SigninPresenter presenter;

    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
//        ButterKnife.bind(this);
        logInButton = (Button) findViewById(R.id.logInButton);
        registerButton = (Button) findViewById(R.id.newUser);
        registerButton.setPaintFlags(registerButton.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        sharedPref= getPreferences(Context.MODE_PRIVATE);

        //create the presenter
        presenter = new SigninPresenter(this);

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.initLoginLab4UApplication();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SigninActivity.this, RegistrationActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });
    }

    @Override
    public void showNoAccount(){
        Toast.makeText(getApplicationContext(), "Username or Password is incorrect", Toast.LENGTH_LONG).show();
    }

    @Override
    public String getEmail() {
        return String.valueOf(((EditText)findViewById(R.id.email)).getText());
    }

    @Override
    public String getPasword() {
        return String.valueOf(((EditText)findViewById(R.id.password)).getText());
    }

    @Override
    public void cleanPassword() {
        password.setText("");
    }

    /**
     * login is complete, directs the user to a new blank activity
     */
    @Override
    public void onCompleteInitLoginLab4UApplication() {
        goToHomeScreen();
    }

    @Override
    public SharedPreferences getSharedPref() {
        return sharedPref;
    }

    @Override
    public boolean hasAuthentication(){
        String accessToken = sharedPref.getString("AccessToken", "None");
        if (accessToken.equals("None")){
            return false;
        }
        return true;
    }

    @Override
    public void goToHomeScreen(){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            HomeFragment homeFragment = new HomeFragment();
            fragmentTransaction.add(android.R.id.content, homeFragment);
            fragmentTransaction.commit();
            password.setKeyListener(null);
            email.setKeyListener(null);
            logInButton.setEnabled(false);
            registerButton.setEnabled(false);
    }
}
