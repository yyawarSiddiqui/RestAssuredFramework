package com.api.test.hr;

import static com.api.base.RecruitmentRequestFormRRFService.getBasePath;
import static com.api.utils.ParseToken.Parsetoken;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.RecruitmentRequestFormRRFService;

import static com.api.base.RecruitmentRequestFormRRFService.*;
import com.api.constant.Roles;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.getRRFdetailResponse;
import com.api.utils.AuthTokenProvider;

import io.restassured.response.Response;

public class rrfServicetest {

	int id;

	@Test(description = "Verify GetTechnologyAPI of user")
	public void test_GetTechnologyAPI() {

		LoginRequest loginRequest = new LoginRequest("INEMP000775", "ibs#2020");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);

		LoginResponse loginResponse = response.as(LoginResponse.class);
		String updatedToken = Parsetoken(loginResponse.getToken());
		RecruitmentRequestFormRRFService RRFService = new RecruitmentRequestFormRRFService(loginResponse.getToken());
		Response response2 = RRFService.getTechnologies(updatedToken);
		response2.then().statusCode(200).and().time(Matchers.lessThan(7500L)).and().body(Matchers.notNullValue());

	}

	@Test
	public void test_countAPI_Missingtoken() {

		LoginRequest loginRequest = new LoginRequest("INEMP000775", "ibs#2020");
		AuthService authService = new AuthService();
		authService.login(loginRequest);
		RecruitmentRequestFormRRFService managementService = new RecruitmentRequestFormRRFService();
		Response response = managementService.getTechnologies(null);
		response.then().statusCode(401);

	}

	@Test
	public void test_getrrfDetail() {

		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("StatusID", 1);
		queryParams.put("FAC", 1);
		String token = AuthTokenProvider.getToken(Roles.HR);
		RecruitmentRequestFormRRFService RRFService = new RecruitmentRequestFormRRFService(token);

		Response response = RRFService.getRequestwithParams(
				getBasePath() + RRFService.getEmpID() + ENDPOINT_RRF_JOB_TITLE, queryParams, Parsetoken(token));
		response.then().statusCode(200).and().body("id", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("id", Matchers.everyItem(Matchers.greaterThan(0))).and().time(Matchers.lessThan(8000L));

		assertTrue(response.jsonPath().getList("$").size() > 0);

		List<Map<String, Object>> items = response.jsonPath().getList("$");
		for (Map<String, Object> item : items) {

			assertTrue(item.containsKey("id"));
			assertTrue(item.containsKey("name"));
		}

		List<getRRFdetailResponse> details = response.jsonPath().getList("", getRRFdetailResponse.class);
		id = details.get(0).getId();
	}

	@Test(dependsOnMethods = { "test_getrrfDetail" })
	public void test_getRRFBYID() {

		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("RRFID", id);
		String token = AuthTokenProvider.getToken(Roles.HR);
		RecruitmentRequestFormRRFService RRFService = new RecruitmentRequestFormRRFService(token);

		Response response = RRFService.getRequestwithParams(
				getBasePath() + RRFService.getEmpID() + ENDPOINT_RRF_BYRRFID, queryParams, Parsetoken(token));

		response.then().statusCode(200);

	}

}
