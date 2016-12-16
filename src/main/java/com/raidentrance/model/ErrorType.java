/**
 * 
 */
package com.raidentrance.model;

/**
 * @author raidentrance
 *
 */
public enum ErrorType {
	
	NOT_FOUND("%s Not found", 40);
	
	private String message;
	private Integer code;

	private ErrorType(String message, Integer code) {
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public Integer getCode() {
		return code;
	}
}
