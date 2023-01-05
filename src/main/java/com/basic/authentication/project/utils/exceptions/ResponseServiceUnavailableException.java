package com.basic.authentication.project.utils.exceptions;

public class ResponseServiceUnavailableException extends  RuntimeException{

	private static final long serialVersionUID = 456058647835911633L;

	public ResponseServiceUnavailableException(String message) {
        super(message);
    }

}
