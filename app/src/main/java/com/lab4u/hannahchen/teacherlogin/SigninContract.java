package com.lab4u.hannahchen.teacherlogin;

/**
 * Created by hannahchen on 6/23/16.
 */
public interface SigninContract {
    interface Presenter{
        boolean userValid();
        void initLoginLab4UApplication();
//        void initLoginLab4UApplication(String email,String password);
    }

    interface View{
        void showNoAccount();
        String getEmail();
        String getPasword();
        void cleanPassword();
        void onCompleteInitLoginLab4UApplication();
    }

}
