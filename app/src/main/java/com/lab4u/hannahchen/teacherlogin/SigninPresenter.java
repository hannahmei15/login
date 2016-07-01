package com.lab4u.hannahchen.teacherlogin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.EditText;

import java.util.Hashtable;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by hannahchen on 6/23/16.
 */
public class SigninPresenter implements SigninContract.Presenter {

    private SigninContract.View view;

    private WebService mWebService;

    private SharedPreferences sharedPref;

    public SigninPresenter(SigninContract.View view){
        this.view = view;
        sharedPref = view.getSharedPref();
        mWebService = ServiceGenerator.createService(WebService.class);
        if (view.hasAuthentication()){
            view.goToHomeScreen();
            String accessToken = sharedPref.getString("AccessToken", "None");
        }
    }

    /**
     * starts the log in process
     */
    @Override
    public void initLoginLab4UApplication() {
        final String email = view.getEmail();
        final String password = view.getPasword();
        AuthorizeUser user = new AuthorizeUser(email, password, "LAB4U");
        mWebService.authorize(email, password, "LAB4U", new Callback<Token>() {
            @Override
            public void success(Token tokenResponse, Response response) {
                SharedPreferences.Editor editor = sharedPref.edit();
                String accessToken = tokenResponse.getAccessToken();
//                Log.d("SigninPresenter-", exampleResponse.toString());
                editor.putString("AccessToken", "Bearer " + accessToken);
                editor.commit();
                view.onCompleteInitLoginLab4UApplication();
//                mWebService = ServiceGenerator.createService(WebService.class, accessToken);

            }

            @Override
            public void failure(RetrofitError error) {
                view.showNoAccount();
            }
        });

    }





}
