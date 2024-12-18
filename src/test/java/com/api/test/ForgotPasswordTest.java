package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordTest {

	@Test(description = "Forgot password Test")
	public void Test() {

		AuthService authService = new AuthService();
		Response response=authService.forgotPassword("dfbh@fd.com");
		System.out.println(response.asPrettyString());
		
	}
}
