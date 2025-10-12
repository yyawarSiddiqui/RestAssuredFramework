package com.api.test;

import static com.api.base.CommonService.ENDPOINT_GetAllReportingMgr;
import static com.api.base.CommonService.ENDPOINT_RRF_GET_ROLEWISE_TITLE;
import static com.api.base.CommonService.getBasePath;
import static com.api.constant.Roles.HR;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;
import static com.api.utils.ParseToken.Parsetoken;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.CommonService;
import com.api.models.response.getRRFbyIDResponse;
import com.api.utils.AuthTokenProvider;

import io.restassured.response.Response;

public class CommonAPITest {

	@Test
	public void test_getRRFBYID() {

		String Emp_id = getEmployeeID(HR);
		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("RoleIds", 7);
		queryParams.put("eID", 0);
		queryParams.put("FAC", 0);
		String token = AuthTokenProvider.getToken(HR);
		CommonService RRFService = new CommonService();
		Response response = RRFService.getRequestwithParams(getBasePath() + Emp_id + ENDPOINT_RRF_GET_ROLEWISE_TITLE,
				queryParams, Parsetoken(token));

		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.body("employeeID", Matchers.everyItem(Matchers.notNullValue()))
				.body("employeeName", Matchers.everyItem(Matchers.notNullValue()));

		List<getRRFbyIDResponse> list = response.jsonPath().getList("", getRRFbyIDResponse.class);
		Assert.assertNotNull(list.get(0).getEmployeeID());

	}

	@Test
	public void test_GetAllReportingMagaer() {

		String Emp_id = getEmployeeID(HR);
		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("FAC", 0);
		String token = AuthTokenProvider.getToken(HR);
		CommonService RRFService = new CommonService();

		Response response = RRFService.getRequestwithParams(getBasePath() + Emp_id + ENDPOINT_GetAllReportingMgr,
				queryParams, Parsetoken(token));

		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.body("employeeID", Matchers.everyItem(Matchers.notNullValue())).time(Matchers.lessThan(20000L))
				.body("employeeName", Matchers.everyItem(Matchers.notNullValue()));

	}

}
