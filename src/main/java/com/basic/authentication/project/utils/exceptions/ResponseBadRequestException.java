package com.basic.authentication.project.utils.exceptions;

public class ResponseBadRequestException extends  RuntimeException{

    private static final long serialVersionUID = -4952200319543013069L;

	public ResponseBadRequestException(String message) {
        super(message);
    }

}
