package com.lab4u.hannahchen.teacherlogin;

/**
 * Created by hannahchen on 6/22/16.
 */
public class RegistrationContract {
    interface Presenter{
        void addUser();
        boolean isValid(String email);
    }

    interface View{
        void showInvalid(); //show that the email is invalid
        void showRegistration(); //show a succesful registration
    }




}
