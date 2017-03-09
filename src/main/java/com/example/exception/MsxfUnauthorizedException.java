package com.example.exception;

import com.example.ErrorCode;

public class MsxfUnauthorizedException extends MsxfException {

	private static final long serialVersionUID = 6296082588102774344L;

	public MsxfUnauthorizedException(ErrorCode errorCode, String message) {
		super(errorCode, message);
	}

	public MsxfUnauthorizedException(ErrorCode errorCode, String message, Throwable t) {
		super(errorCode, message, t);
	}
}