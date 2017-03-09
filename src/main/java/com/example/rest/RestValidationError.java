/**
 * MSXF
 */
package com.example.rest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hongzheng.liu
 * @created 2015年9月25日
 */
public class RestValidationError {
	private String message;

	private Map<String, String> fields = new HashMap<String, String>(6);

	public RestValidationError(String message) {
		this.message = message;
	}

	public RestValidationError(Map<String, String> fields, String message) {
		this.fields = fields;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, String> getFields() {
		return fields;
	}

	public void setFields(Map<String, String> fields) {
		this.fields = fields;
	}
}
