package com.raidentrance.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author raidentrance
 *
 */
@JsonInclude(Include.NON_NULL)
public class ErrorMessage implements Serializable {
	private Integer httpStatus;
	private String message;
	private Integer code;
	private String developerMessage;

	private static final long serialVersionUID = 5318063708359922770L;

	public ErrorMessage() {
	}

	public ErrorMessage(ServiceException ex) {
		this.httpStatus = ex.getHttpStatus();
		this.message = ex.getMessage();
		this.code = ex.getCode();
	}

	public ErrorMessage(Integer httpStatus, String message, Integer code) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
		this.code = code;
	}

	public Integer getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(Integer httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

}
