package com.basic.authentication.project.utils.exceptions;

public class ResponseNotFoundException extends  RuntimeException{

	private static final long serialVersionUID = 3344147423375336198L;

	public ResponseNotFoundException(String message) {
        super(message);
    }

}
