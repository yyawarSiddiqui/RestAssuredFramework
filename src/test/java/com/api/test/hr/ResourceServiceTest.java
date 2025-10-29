package com.api.test.hr;

import static com.api.constant.Roles.HR;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;
import static com.api.utils.ParseToken.Parsetoken;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.api.base.ResourceService;
import com.api.utils.AuthTokenProvider;

import io.restassured.response.Response;

public class ResourceServiceTest {

	
	private ResourceService resourceService;
	private String Emp_id;
	private String token;

	@DataProvider(name = "Leave Types")
	public Object[][] Leaveids() {

		return new Object[][] {

				{ "CL" }, { "HD" }, { "MDL" }, { "WL" } };
	}

	@BeforeMethod
	public void setup() {

		Emp_id = getEmployeeID(HR);
		token = AuthTokenProvider.getToken(HR);
		resourceService = new ResourceService();

	}
	
	@Test
	public void test_getResourceList() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isactive", 1);
	
		Response response = resourceService.getResourceList(Parsetoken(token), Emp_id, map);
		response.then().statusCode(200).and().body("", Matchers.everyItem(Matchers.hasKey("resourceId"))).body("",
				Matchers.everyItem(Matchers.hasKey("resourceName")));

	}

}
