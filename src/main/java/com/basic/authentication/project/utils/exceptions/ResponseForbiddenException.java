package com.basic.authentication.project.utils.exceptions;

public class ResponseForbiddenException extends  RuntimeException{

	private static final long serialVersionUID = -3048939988131411352L;

	public ResponseForbiddenException(String message) {
        super(message);
    }

}
