package com.api.test.hr;

import static com.api.constant.Roles.HR;
import static com.api.utils.FakerdataCreation.getRandomString;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;
import static com.api.utils.ParseToken.Parsetoken;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.api.base.ConsolidateAttendanceReport;
import com.api.base.RoleMaster;
import com.api.models.request.Employee;
import com.api.utils.AuthTokenProvider;

import io.restassured.response.Response;

public class ConsolidateAttendanceReportTest {

	
	private ConsolidateAttendanceReport consolidateAttendanceReport;
	private String Emp_id;
	private String token;

	@BeforeClass
	public void setup() {

		Emp_id = getEmployeeID(HR);
		token = AuthTokenProvider.getToken(HR);
		consolidateAttendanceReport = new ConsolidateAttendanceReport();

	}

	@Test
	public void test_GetConsolidateAttendanceDetails() {

		Response response = consolidateAttendanceReport.GetConsolidateAttendanceDetails( Parsetoken(token),Emp_id);
		response.then().statusCode(200).and().time(Matchers.lessThan(10000L));

	}

}
