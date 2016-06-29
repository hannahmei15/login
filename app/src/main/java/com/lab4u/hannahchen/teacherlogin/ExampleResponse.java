package com.lab4u.hannahchen.teacherlogin;

/**
 * Used for seeing an example of the API
 * Created by hannahchen on 6/28/16.
 */
public class ExampleResponse {
    private String status;
    private String code;
    private String message;
    private String CdnUrl;

    public ExampleResponse(String status, String code, String message, String CdnUrl){
        this.status = status;
        this.code = code;
        this.message = message;
        this.CdnUrl = CdnUrl;
    }

    public String getStatus(){
        return status;
    }
}
