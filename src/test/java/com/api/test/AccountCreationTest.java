package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {

	@Test(description = "Verify signup of user")
	public void AccountCreationTesting() {

		SignUpRequest signUpRequest = new SignUpRequest.Builder().userName("yawafrhh").Email("yajwfatrd@gmail.com").Password("56756453@E#$")
				.FirstName("sffdf").LastName("sffdf").MobileNumber("9897654365").build();

		AuthService authService = new AuthService();
		Response response=authService.signUp(signUpRequest);
	}

}
