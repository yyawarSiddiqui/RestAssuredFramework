package com.api.models.response;

public class UserProfileUpdateTestResponse {

	private String timestamp;
	private String status;
	private String error;
	private String message;
	private String path;
	private String solution;
	private String errorCode;

	public UserProfileUpdateTestResponse() {

	}

	public UserProfileUpdateTestResponse(String timestamp, String status, String error, String message, String path,
			String solution, String errorCode) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
		this.solution = solution;
		this.errorCode = errorCode;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return "UserProfileUpdateTestResponse [timestamp=" + timestamp + ", status=" + status + ", error=" + error
				+ ", message=" + message + ", path=" + path + ", solution=" + solution + ", errorCode=" + errorCode
				+ "]";
	}

}
