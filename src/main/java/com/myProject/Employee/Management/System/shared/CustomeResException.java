package com.myProject.Employee.Management.System.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomeResException extends RuntimeException{
    private int code;
    private String message;

    public static CustomeResException ResourceNotFound( String message){
        return new CustomeResException(404,message);
    }
    public static CustomeResException BadCredentials(){
        return new CustomeResException(401,"Bad credentials");
    }
}
