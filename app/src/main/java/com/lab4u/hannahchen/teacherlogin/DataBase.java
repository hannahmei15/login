package com.lab4u.hannahchen.teacherlogin;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * Created by hannahchen on 6/22/16.
 * Class to act as a data base to store emails and passwords using a hashtable
 */
public class DataBase {
    private Hashtable data;


    public DataBase() {
        data = new Hashtable();
    }

    public void addData(String email, String password){
        data.put(email, password);
    }

    public boolean hasUser(String email, String password){
        if (data.contains(email)){
            if (data.get(email).equals(password)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        String answer = "";
        for (Object key : data.keySet()){
            answer += "(" + key.toString() + "," + data.get(key) + ")\n";
        }
        return answer;
    }


}
