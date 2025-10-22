package com.api.test.hr;

import static com.api.constant.Roles.HR;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;
import static com.api.utils.ParseToken.Parsetoken;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.api.base.ExtensionService;
import com.api.utils.AuthTokenProvider;

import io.restassured.response.Response;

public class ExtensionServiceTest {

	private ExtensionService extensionService;
	private String Emp_id;
	private String token;

	@DataProvider(name = "locationData")
	public Object[][] LocationId_Provider() {

		return new Object[][] {

				{ 1 }, { 5 }, { 6 }, { 8 }, { 4 }

		};
	}

	@BeforeClass
	public void setup() {

		Emp_id = getEmployeeID(HR);
		token = AuthTokenProvider.getToken(HR);
		extensionService = new ExtensionService();

	}

	@Test(dataProvider = "locationData")
	public void test_getExtensionList(int locationid) {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("locationid", locationid);
		map.put("isdownload", false);

		Response response = extensionService.GetExtensionList(Parsetoken(token), Emp_id, map);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("extensionId", Matchers.everyItem(Matchers.notNullValue()));
		

	}
}
