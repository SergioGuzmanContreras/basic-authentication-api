package com.basic.authentication.project.utils.exceptions;

public class ResponseInternalServerErrorException extends  RuntimeException{

	private static final long serialVersionUID = 3855065129866858755L;

	public ResponseInternalServerErrorException(String message) {
        super(message);
    }

}
