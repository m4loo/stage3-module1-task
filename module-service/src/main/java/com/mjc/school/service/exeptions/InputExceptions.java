package com.mjc.school.service.exeptions;

public class InputExceptions extends Exception{

    private final String errorInfo;

    public InputExceptions (String errorInfo) {
        super (errorInfo);
        this.errorInfo = errorInfo;
    }

    public String getErrorInfo() {
        return errorInfo;
    }
}
