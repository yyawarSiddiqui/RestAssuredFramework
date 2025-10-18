package com.api.test.hr;

import static com.api.constant.Roles.HR;
import static com.api.utils.ParseToken.Parsetoken;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.base.RPACommonService;
import com.api.utils.AuthTokenProvider;

import io.restassured.response.Response;

public class RPACommonServiceTest {

	@Test
	public void test_GetAllReportingMagaer() {

		String token = AuthTokenProvider.getToken(HR);
		RPACommonService RPACommonService = new RPACommonService();

		Response response = RPACommonService.getHiringLocationbyEMP(Parsetoken(token));

		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.body("hiringLocationID", Matchers.everyItem(Matchers.notNullValue())).time(Matchers.lessThan(20000L))
				.body("hiringLocationName", Matchers.everyItem(Matchers.notNullValue()));

	}
	
	@Test
	public void test_Get_Hiring_Location() {

		String token = AuthTokenProvider.getToken(HR);
		RPACommonService RPACommonService = new RPACommonService();

		Response response = RPACommonService.getHiringLocationbyEMP(Parsetoken(token));

		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.body("hiringLocationID", Matchers.everyItem(Matchers.notNullValue())).time(Matchers.lessThan(20000L))
				.body("hiringLocationName", Matchers.everyItem(Matchers.notNullValue()));

	}

}
