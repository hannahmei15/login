package com.lab4u.hannahchen.teacherlogin;

/**
 * Used for seeing an example of the API
 * Created by hannahchen on 6/28/16.
 */
public class ExampleResponse {
    private String status;
    private String code;
    private String message;

    public String getUserId() {
        return userId;
    }

    private String userId;

    public ExampleResponse(String status, String code, String message, String userId){
        this.status = status;
        this.code = code;
        this.message = message;
        this.userId = userId;
    }

    public String getStatus(){
        return status;
    }

    @Override
    public String toString(){
        return "status: " + status + " code: " + code + " message " + message
                + " userID: " + userId;
    }
}
