package com.api.test.IT;
import static com.api.constant.Roles.IT;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;
import static com.api.utils.ParseToken.Parsetoken;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.base.LocationService;
import com.api.utils.AuthTokenProvider;

import io.restassured.response.Response;

public class LocationServiceTest {

	@Test
	public void getLocation_test() {

		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("isactive", true);
		
		String Emp_id = getEmployeeID(IT);
		String token = AuthTokenProvider.getToken(IT);

		LocationService locationService = new LocationService();
		Response response = locationService.getLocationList(Parsetoken(token), Emp_id, map);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(5000L)).and().body("id", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("location", Matchers.everyItem(Matchers.notNullValue())).and()
				.body(matchesJsonSchemaInClasspath("responseSchema/locationlistResponse.json"));

	}
}
