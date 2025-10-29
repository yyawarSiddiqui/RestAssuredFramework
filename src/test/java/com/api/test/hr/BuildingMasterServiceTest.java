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

import com.api.base.BuildingMasterService;
import com.api.utils.AuthTokenProvider;

import io.restassured.response.Response;

public class BuildingMasterServiceTest {

	private BuildingMasterService buildingMasterService;
	private String Emp_id;
	private String token;


	@BeforeMethod
	public void setup() {

		Emp_id = getEmployeeID(HR);
		token = AuthTokenProvider.getToken(HR);
		buildingMasterService = new BuildingMasterService();

	}

	@Test
	public void test_getBuildingFloorList() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isactive", 1);

		Response response = buildingMasterService.getBuildingFloorList(Parsetoken(token), Emp_id, map);
		response.then().statusCode(200).and().body("buildingFloorId", Matchers.notNullValue()).and()
				.body("buildingFloorName", Matchers.notNullValue()).and().body("", Matchers.everyItem(Matchers.hasEntry("isActive", 1)));
		response.then().time(Matchers.lessThan(10000L)).and().body("", Matchers.notNullValue());

	}
}
