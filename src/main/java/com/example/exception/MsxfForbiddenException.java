/**
 * MSXF
 */
package com.example.exception;

import com.example.ErrorCode;

/**
 * @author hongzheng.liu
 * @created 2015年9月27日
 */
public class MsxfForbiddenException extends MsxfException {
	private static final long serialVersionUID = 1063810645112379020L;

	public MsxfForbiddenException(ErrorCode errorCode, String message) {
		super(errorCode, message);
	}

	public MsxfForbiddenException(ErrorCode errorCode, String message, Throwable t) {
		super(errorCode, message, t);
	}
}
