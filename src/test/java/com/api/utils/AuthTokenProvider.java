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

			loginRequest = new LoginRequest("INEMP000775", "ibs#2020");

		} else if (Role == Roles.ACCOUNT) {

			loginRequest = new LoginRequest("INEMP000327", "ibs#2020");

		}

		else if (Role == Roles.ADMIN) {

			loginRequest = new LoginRequest("INEMP000410", "ibs#2020");

		} else if (Role == Roles.ASSOCIATE) {

			loginRequest = new LoginRequest("INEMP000667", "ibs#2020");

		}

		else if (Role == Roles.IT) {

			loginRequest = new LoginRequest("INEMP000228", "ibs#2020");

		}
		
		else if (Role == Roles.RM) {

			loginRequest = new LoginRequest("INEMP000228", "ibs#2020");

		}

		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		String token = loginResponse.getToken();
		return token;

	}

}
