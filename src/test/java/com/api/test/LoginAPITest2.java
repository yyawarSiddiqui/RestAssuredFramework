package com.api.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListeners.class)
public class LoginAPITest2 {

	@Test(description = "Verify if login page is working", groups = { "Smoke" })
	public void loginTest() {

		LoginRequest loginRequest = new LoginRequest("uday1234", "uday1234");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);

		LoginResponse loginResponse = response.as(LoginResponse.class);// it returns you new LoginResponse();

		String token = loginResponse.getToken();

	}
}
