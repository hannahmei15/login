package com.lab4u.hannahchen.teacherlogin;

import android.content.SharedPreferences;

import java.util.ResourceBundle;

/**
 * Created by hannahchen on 6/23/16.
 */
public interface SigninContract {
    interface Presenter{
        void initLoginLab4UApplication();
    }

    interface View{
        void showNoAccount();
        String getEmail();
        String getPasword();
        void cleanPassword();
        void onCompleteInitLoginLab4UApplication();
        SharedPreferences getSharedPref();
        boolean hasAuthentication();
        void goToHomeScreen();
    }

}
