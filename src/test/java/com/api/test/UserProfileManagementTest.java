package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UserProfileManagementTest {

	@Test(description = "Verify UserProfileManagementTest of user")
	public void Test() {

		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("uday1234", "uday1234"));

		LoginResponse loginResponse = response.as(LoginResponse.class);
		String token = loginResponse.getToken();
		
		UserProfileManagementService managementService = new UserProfileManagementService();
		
		Response response2 = managementService.getProfile(token);
		
		 UserProfileResponse profileResponse=response2.as(UserProfileResponse.class);
		System.out.println(profileResponse.getUsername());
	}

}
