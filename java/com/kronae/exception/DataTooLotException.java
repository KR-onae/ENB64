package com.kronae.encrypt.enb64.exception;

public class DataTooLotException extends RuntimeException {
    public DataTooLotException() {
        super();
    }
    public DataTooLotException(String msg) {
        super(msg);
    }
    public DataTooLotException(Exception e) {
        super(e);
    }
}
