package com.api.test;

import static com.api.utils.ParseToken.Parsetoken;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.RecruitmentRequestFormRRFService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class rrfServicetest {

	@Test(description = "Verify GetTechnologyAPI of user")
	public void test_GetTechnologyAPI() {

		LoginRequest loginRequest = new LoginRequest("INEMP000775", "ibs#2020");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);

		LoginResponse loginResponse = response.as(LoginResponse.class);
		String updatedToken = Parsetoken(loginResponse.getToken());
		RecruitmentRequestFormRRFService RRFService = new RecruitmentRequestFormRRFService();
		Response response2 = RRFService.getTechnologies(updatedToken);
		response2.then().statusCode(200).and().time(Matchers.lessThan(500L)).and().body(Matchers.notNullValue());

	}

	@Test
	public void test_countAPI_Missingtoken() {

		LoginRequest loginRequest = new LoginRequest("INEMP000775", "ibs#2020");
		AuthService authService = new AuthService();
		authService.login(loginRequest);
		RecruitmentRequestFormRRFService managementService = new RecruitmentRequestFormRRFService();
		Response response = managementService.getTechnologies(null);
		response.then().statusCode(400);

	}
	
	

}
