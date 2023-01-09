package com.solvd.happyfarm.exception;

public class InvalidVaccinationException extends Exception {

    public InvalidVaccinationException(String message){
        super(message);
    }

    public InvalidVaccinationException (String message, Throwable cause){
        super(message, cause);
    }

}
