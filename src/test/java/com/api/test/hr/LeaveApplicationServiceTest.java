package com.api.test.hr;

import static com.api.constant.Roles.HR;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;
import static com.api.utils.ParseToken.Parsetoken;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.api.base.LeaveApplicationService;
import com.api.models.response.LeaveResponse;

import static com.api.base.LeaveApplicationService.*;
import com.api.utils.AuthTokenProvider;

import io.restassured.response.Response;

public class LeaveApplicationServiceTest {

	private LeaveApplicationService applicationService;
	private String Emp_id;
	private String token;

	@BeforeClass
	public void setup() {

		Emp_id = getEmployeeID(HR);
		token = AuthTokenProvider.getToken(HR);
		applicationService = new LeaveApplicationService();

	}

	@Test
	public void test_getAttendanceMonth() {

		Response response = applicationService.getAttendanceMonth(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("attMonth", Matchers.greaterThanOrEqualTo(0));

		response.then().time(Matchers.lessThan(10000L)).and().body("attMonth", Matchers.notNullValue()).and()
				.body("attYear", Matchers.notNullValue());

	}

	@Test
	public void test_getAttendaneMonth() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("empId", Emp_id);
		Response response = applicationService
				.getRequestwithParams(getBasePath() + Emp_id + "/GetLeaveApplicationDetails", map, Parsetoken(token));
		response.then().statusCode(200);

		LeaveResponse leaveResponse=response.as(LeaveResponse .class);
		
	assertEquals(leaveResponse.getLeaveDetails().get(0).getEmployeeId(),Integer.parseInt(Emp_id));
		
		
		
	}
}
