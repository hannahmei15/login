package com.lab4u.hannahchen.teacherlogin;

/**
 * Created by hannahchen on 6/23/16.
 */
public interface SigninContract {
    interface Presenter{
        boolean userValid();
    }

    interface View{
        void showNoAccount();
    }

}
