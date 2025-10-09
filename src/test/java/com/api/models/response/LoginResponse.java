package com.api.models.response;

public class LoginResponse {
	
	private String token;
	private String employeeCode;
	private String photoUrl;
	private String employeeName;
	private String companyEmail;

	
	
	public LoginResponse() {

		
		// Jackson needs this
	}

	
	public LoginResponse(String token, String employeeCode, String photoUrl, String employeeName, String companyEmail) {
		super();
		this.token = token;
		this.employeeCode = employeeCode;
		this.photoUrl = photoUrl;
		this.employeeName = employeeName;
		this.companyEmail = companyEmail;
	}

	

	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public String getEmployeeCode() {
		return employeeCode;
	}


	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}


	public String getPhotoUrl() {
		return photoUrl;
	}


	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getCompanyEmail() {
		return companyEmail;
	}


	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}


	@Override
	public String toString() {
		return "LoginResponse [token=" + token + ", employeeCode=" + employeeCode + ", photoUrl=" + photoUrl
				+ ", employeeName=" + employeeName + ", companyEmail=" + companyEmail + "]";
	}


	
	
	

}
