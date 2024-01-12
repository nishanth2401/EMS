package com.excelr.mainpackage.Exception;

public class ResourceNotFoundException extends RuntimeException{
    @Override
    public String toString() {
        return "Resource not found";
    }
}
