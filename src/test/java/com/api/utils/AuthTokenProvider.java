package com.api.utils;

import com.api.base.AuthService;
import com.api.constant.Roles;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class AuthTokenProvider {

	private AuthTokenProvider() {

	}

	public static String getToken(Roles Role) {

		LoginRequest loginRequest = null;

		if (Role == Roles.HR) {

			loginRequest = new LoginRequest("yawafrhh", "56756453@E#$");

		} else if (Role == Roles.ACCOUNT) {

			loginRequest = new LoginRequest("yawafrhh", "56756453@E#$");

		}

		else if (Role == Roles.ADMIN) {

			loginRequest = new LoginRequest("yawafrhh", "56756453@E#$");

		} else if (Role == Roles.ASSOCIATE) {

			loginRequest = new LoginRequest("yawafrhh", "56756453@E#$");

		}

		else if (Role == Roles.IT) {

			loginRequest = new LoginRequest("yawafrhh", "56756453@E#$");

		}

		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		String token = loginResponse.getToken();
		return token;

	}

}
