package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import static com.api.constant.Roles.*;
import com.api.models.request.LoginRequest;
import com.api.models.response.UserProfileResponse;
import static com.api.utils.AuthTokenProvider.*;

import io.restassured.response.Response;

public class getUserProfileManagementTest {

	@Test(description = "Verify UserProfileManagementTest of user")
	public void Test() {

		AuthService authService = new AuthService();
		authService.login(new LoginRequest("yawafrhh", "56756453@E#$"));

//		LoginResponse loginResponse = response.as(LoginResponse.class);
//		String token = loginResponse.getToken();
		UserProfileManagementService managementService = new UserProfileManagementService();

		Response response2 = managementService.getProfile(getToken(ASSOCIATE));
		UserProfileResponse profileResponse = response2.as(UserProfileResponse.class);

		System.out.println(profileResponse.getUsername());

	}

}
