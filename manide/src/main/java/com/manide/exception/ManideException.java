package com.manide.exception;

public class ManideException extends RuntimeException {

    public ManideException(Exception e) {
	super(e);
    }

    private static final long serialVersionUID = 1L;

}
