package com.lab4u.hannahchen.teacherlogin;

/**
 * Created by hannahchen on 6/22/16.
 */

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegistrationTest {

    RegistrationPresenter rp = null;


    @Before
    public void setup(){
        rp = new RegistrationPresenter(DataBase.dataBase, new RegistrationActivity());
    }

    @Test
    public void testValidLetters(){
        assertTrue(rp.isValid("hannah@gmail.com"));
    }

    @Test
    public void testValidAllCharacters(){
        assertTrue(rp.isValid("HanN4a.h_cheN@lab4U.com"));
    }

    @Test
    public void testInvalidNoAt(){
        assertFalse(rp.isValid("hannahchen"));
    }

    @Test
    public void testInvalidNoPeriod(){
        assertFalse(rp.isValid("hannah@gmailcom"));
    }

    @Test
    public void testInvalidCharacters(){
        assertFalse(rp.isValid("h239&*@gmail.com!"));
    }

    @Test
    public void testInvalidMultipleAts(){
        assertFalse(rp.isValid("hannah@gmail@aol.co"));
    }


}
