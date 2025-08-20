package com.api.models.response;

import java.util.List;

public class patchtUpdateProfiletestResponse {

	private int id;
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private List<String> roles;
	private boolean active;
	private String createdAt;
	private String updatedAt;
	private String address;
	private String fullName;
	
	

	public patchtUpdateProfiletestResponse() {
		super();
	}

	public patchtUpdateProfiletestResponse(int id, String username, String password, String email, String firstName,
			String lastName, String mobileNumber, List<String> roles, boolean active, String createdAt,
			String updatedAt, String address, String fullName) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.roles = roles;
		this.active = active;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.address = address;
		this.fullName = fullName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "putUpdateProfiletestResponse [id=" + id + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber="
				+ mobileNumber + ", roles=" + roles + ", active=" + active + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", address=" + address + ", fullName=" + fullName + "]";
	}

}
