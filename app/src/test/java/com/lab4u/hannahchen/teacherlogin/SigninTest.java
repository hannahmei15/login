package com.lab4u.hannahchen.teacherlogin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ajperalt on 6/24/16.
 */
public class SigninTest {

    SigninContract.Presenter p;
    SigninContract.View v;

    @Before
    public void setup(){
        p = new SigninPresenter(DataBase.dataBase,v);
    }


    @Test
    public void initLoginLab4UApplicationTest(){
        try {
            p.initLoginLab4UApplication("hannanh@lab4u.cl", "hannahpassword");
        }catch(Exception e){
            Assert.assertTrue(e.getMessage(),false);
        }
    }
}
