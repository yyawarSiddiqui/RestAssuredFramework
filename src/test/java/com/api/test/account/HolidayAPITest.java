package com.api.test.account;
import static com.api.constant.Roles.HR;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;
import static com.api.utils.ParseToken.Parsetoken;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static com.api.base.HolidayService.*;

import com.api.base.HolidayService;
import com.api.models.response.getDepartmentsHoliday;
import com.api.models.response.getHolidayResponse;
import com.api.utils.AuthTokenProvider;

import io.restassured.response.Response;

public class HolidayAPITest {

	@Test
	public void test_getDepartments() {

		String Emp_id = getEmployeeID(HR);
		String token = AuthTokenProvider.getToken(HR);
		HolidayService holiday = new HolidayService();
		Response response = holiday.getDepartments(Parsetoken(token), Emp_id);

		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.body("id", Matchers.everyItem(Matchers.notNullValue()))
				.body("name", Matchers.everyItem(Matchers.notNullValue()));

		List<getDepartmentsHoliday> getdept = response.jsonPath().getList("", getDepartmentsHoliday.class);
		for (getDepartmentsHoliday Departments : getdept) {

			assertNotEquals(Departments.getId(), 0);
		}
	}

	@Test
	public void test__getHoliday() {

		String Emp_id = getEmployeeID(HR);
		String token = AuthTokenProvider.getToken(HR);
		HolidayService holiday = new HolidayService();
		Response response = holiday.getHolidays(Parsetoken(token), Emp_id);

		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.body("id", Matchers.everyItem(Matchers.notNullValue()))
				.body("year", Matchers.everyItem(Matchers.notNullValue()));

		List<getHolidayResponse> holidayResponse = response.jsonPath().getList("", getHolidayResponse.class);

		for (getHolidayResponse val : holidayResponse) {

			assertNotNull(val.getLocationDetails(), "Location details shouldn't be null");
		}

	}
	
	@Test
	public void test_getLocationByHoliday() {

		Map<String,Object> queryParams=new HashMap<String, Object>();
		queryParams.put("FAC", 0);
		String Emp_id = getEmployeeID(HR);
		String token = AuthTokenProvider.getToken(HR);
		HolidayService holiday = new HolidayService();
		Response response = holiday.getRequestwithParams(getBasePath()+Emp_id+ENDPOINT_GETLOCATIONS, queryParams, Parsetoken(token));

		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.body("id", Matchers.everyItem(Matchers.notNullValue()))
				.body("name", Matchers.everyItem(Matchers.notNullValue()));

	}

}
