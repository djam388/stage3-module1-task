package com.mjc.school.service.validator;

public class HandledException extends Exception{
    public HandledException (String code, String message) {
        super("ERROR_CODE: " + code + " ERROR_MESSAGE: " + message);
    }
}
