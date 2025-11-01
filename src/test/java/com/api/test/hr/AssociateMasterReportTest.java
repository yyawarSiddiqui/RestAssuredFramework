package com.api.test.hr;

import static com.api.constant.Roles.HR;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.base.AssociateMasterReportService;
import com.api.utils.AuthTokenProvider;
import static com.api.utils.ParseToken.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;

public class AssociateMasterReportTest {

	@Test
	public void getAssociateMasterColumntoViewTest() {

		Map<String, Object> values = new HashMap<String, Object>();
		values.put("userType", "ADM");

		String Emp_id = getEmployeeID(HR);
		String token = AuthTokenProvider.getToken(HR);
		AssociateMasterReportService associateMasterReportService = new AssociateMasterReportService();
		Response response = associateMasterReportService.getAssociateMasterColumntoView(Parsetoken(token), Emp_id,
				values);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("id", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("name", Matchers.everyItem(Matchers.notNullValue()))
				.body("", Matchers.hasSize(Matchers.greaterThanOrEqualTo(10)));

	}

	@Test
	public void get_AssociateMasteReport() {

		Map<String, Object> values = new HashMap<String, Object>();
		values.put("associatetype", "");
		values.put("clientid", "");
		values.put("columns", "");
		values.put("coretechnologyid", "");
		values.put("currentemployed", "");
		values.put("deptid", "5,3,1026,1021,2,1016,4,1031,1029,1014,1022,1027,14,1015,6,1025,1023,1024");
		values.put("education", "");
		values.put("empid",
				"4971,5104,5249,4704,4870,4911,5494,5489,5422,5318,5468,74,5364,5289,4677,5389,2454,5133,73,351,5510,5045,5107,4771,5306,5481,5119,334,2453,4997,4715,4537,5063");
		values.put("gender", "");
		values.put("isdownload", false);
		values.put("ispermanentwfh", "");
		values.put("isreportingmanager", "");
		values.put("locationid", "");
		values.put("managerid", "");
		values.put("maritalstatus", "");
		values.put("projectid", "");
		values.put("technology", "");

		String Emp_id = getEmployeeID(HR);
		String token = AuthTokenProvider.getToken(HR);
		AssociateMasterReportService associateMasterReportService = new AssociateMasterReportService();
		Response response = associateMasterReportService.getAssociateMasterReport(Parsetoken(token), Emp_id, values);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("AssociateType", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("AssociateCode", Matchers.everyItem(Matchers.notNullValue()))
				.body("", Matchers.hasSize(Matchers.greaterThanOrEqualTo(10)));

	}

}
