package com.manide.exception;

public class ManideException extends RuntimeException {

    public ManideException(Exception e) {
	super(e);
    }

    public ManideException(String message) {
	super(message);
    }

    private static final long serialVersionUID = 1L;

}
