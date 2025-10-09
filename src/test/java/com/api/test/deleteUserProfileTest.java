package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class deleteUserProfileTest {

	@Test(description = "Delete User Profile Test")
	public void deleteUserProfile() {

		LoginRequest loginRequest = new LoginRequest("yawafrhh", "56756453@E#$");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		String token = loginResponse.getToken();
		UserProfileManagementService managementService = new UserProfileManagementService();

		Response response2 = managementService.deleteProfile(token);

		Assert.assertEquals(response2.statusCode(), 200);
		

	}

}
