package com.lab4u.hannahchen.teacherlogin;

/**
 * Created by hannahchen on 6/22/16.
 */
public interface RegistrationContract {
    interface Presenter{
        void addUser();
        boolean isValid(String email);
        void initRegisterLab4UApplication();
    }

    interface View{
        void showInvalid(); //show that the email is invalid
        void showRegistration(); //show a succesful registration
        String getPassword();
        String getEmail();
        String getFirstName();
        String getLastName();
        String getGender();
        String getType();
        String getLanguage();
        void onCompleteRegisterLoginLab4UApplication();
        void clearText();
    }




}
