package com.phonebooking.phonebooking.exception;

public class PhoneAlreadyBookedException extends Exception {

    public PhoneAlreadyBookedException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public PhoneAlreadyBookedException(String errorMessage) {
        super(errorMessage);
    }

}
