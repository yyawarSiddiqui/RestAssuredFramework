package com.api.models.response;

import com.api.models.response.UserProfileResponse.Builder;

public class UserProfileResponse {

	private int id;
	private String username;
	private String email;
	private String firstName;
	private String lastName;
	private String mobileNumber;

	public UserProfileResponse() {

	}

	public UserProfileResponse(int id, String username, String email, String firstName, String lastName,
			String mobileNumber) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
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

	@Override
	public String toString() {
		return "UserProfileResponse [id=" + id + ", username=" + username + ", email=" + email + ", firstName="
				+ firstName + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + "]";
	}

	public static class Builder {

		private int id;
		private String username;
		private String email;
		private String firstName;
		private String lastName;
		private String mobileNumber;

		public Builder id(int id) {
			this.id = id;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder mobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
			return this;
		}

		public Builder id(String username) {
			this.username = username;
			return this;
		}
		
		public UserProfileResponse build() {
			UserProfileResponse profileResponse=new UserProfileResponse(id, username, email, firstName, lastName, mobileNumber);
			return profileResponse;
		}

	}

}
