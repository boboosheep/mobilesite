package com.example.exception;

import java.util.Map;

/**
 * @author hongzheng.liu
 * @created 2015年9月25日
 */
public class MsxfValidationException extends RuntimeException {
	private static final long serialVersionUID = -2762356894000328575L;
	private Map<String, String> fields;

	public MsxfValidationException(Map<String, String> fields) {
		this(fields, "Request entity validate faild.");
	}

	public MsxfValidationException(Map<String, String> fields, String message) {
		super(message);
		this.fields = fields;
	}

	public Map<String, String> getFields() {
		return fields;
	}

	public void setFields(Map<String, String> fields) {
		this.fields = fields;
	}
}
