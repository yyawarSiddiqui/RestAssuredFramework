package com.api.test;

import org.hamcrest.Matchers;
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

		response2.then().statusCode(200).and().body("username", Matchers.equalTo("yawafrhh")).and()
				.time(Matchers.lessThan(500L)).body("id", Matchers.greaterThanOrEqualTo(0))
				.body("firstName",(Matchers.notNullValue()));


	}
	
	@Test
	public void test_countAPI_Missingtoken() {

		LoginRequest loginRequest = new LoginRequest("yawafrhh", "56756453@E#$");
		AuthService authService = new AuthService();
		authService.login(loginRequest);
		UserProfileManagementService managementService = new UserProfileManagementService();
		Response response=managementService.getProfile(null);
		response.then().statusCode(400);
		
		
	}

}
