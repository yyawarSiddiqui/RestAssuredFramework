package com.api.test.ListAssociate;

import static com.api.base.ListAssociateService.get_Employee_Basicdetail_EndPoint;
import static com.api.constant.Roles.HR;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;
import static com.api.utils.ParseToken.Parsetoken;
import static com.api.utils.getEmployeeDetailID.GetEmployeedetailID;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.api.base.ListAssociateService;
import com.api.utils.AuthTokenProvider;

import io.restassured.response.Response;

public class ListAssociateServiceTest {

	private String Emp_id;
	private String token;
	private String employeedetailID;
	private ListAssociateService listAssociate;

	@DataProvider(name = "associateTypeIds")
	public Object[][] associateTypeIds() {
		return new Object[][] { { 1 }, { 2 }, { 3 }, { 8 } };
	}
	
	@DataProvider(name = "Months")
	public Object[][] months() {

		return new Object[][] {

				{ 1 }, { 2 }, { 3 }, { 4 }, { 5 }, { 6 }, { 7 }, { 8 }, { 9 }, { 10 }, { 11 }, { 12 } };
	}

	@BeforeClass
	public void setup() {

		Emp_id = getEmployeeID(HR);
		token = AuthTokenProvider.getToken(HR);
		listAssociate = new ListAssociateService();
		employeedetailID = GetEmployeedetailID(HR);
	}

	@Test
	public void test_getListofAssociate() {

		String Emp_id = getEmployeeID(HR);
		String token = AuthTokenProvider.getToken(HR);
		ListAssociateService listAssociateService = new ListAssociateService();
		Response response = listAssociateService.getListofAssociate(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("employeeCode", Matchers.everyItem(Matchers.notNullValue()))
				.and().body("employeeName", Matchers.everyItem(Matchers.notNullValue()));

		// List<GetExperience> list = response.jsonPath().getList("",
		// GetExperience.class);

	}

	@Test
	public void test_getRoleHistoryDLL() {

		String Emp_id = getEmployeeID(HR);
		String token = AuthTokenProvider.getToken(HR);
		ListAssociateService listAssociateService = new ListAssociateService();
		Response response = listAssociateService.getRoleHistoryDLL(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("Id", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("ProjectRole", Matchers.everyItem(Matchers.notNullValue()));

		// List<GetExperience> list = response.jsonPath().getList("",
		// GetExperience.class);

	}

	@Test
	public void test_getEmployeeBasicDetail() {

		Map<String, Object> map = new HashMap<String, Object>();
		String Emp_id = getEmployeeID(HR);
		String token = AuthTokenProvider.getToken(HR);
		map.put("employeeid", Emp_id);
		ListAssociateService listAssociateService = new ListAssociateService();
		Response response = listAssociateService.getRequestofPlainText(Parsetoken(token), Emp_id,
				get_Employee_Basicdetail_EndPoint, map);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("AssociateTypeId", (Matchers.notNullValue())).and()
				.body("CommitmentType", (Matchers.notNullValue()));
	}

	@Test(dataProvider = "associateTypeIds")
	public void test_getContractCommitment(int associateTypeId) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("AssociateTypeID", associateTypeId);
		String Emp_id = getEmployeeID(HR);
		String token = AuthTokenProvider.getToken(HR);
		ListAssociateService listAssociateService = new ListAssociateService();
		Response response = listAssociateService.getContractCommitment(Parsetoken(token), Emp_id, map);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThanOrEqualTo(0)))
				.time(Matchers.lessThan(10000L)).and()
				.body("AssociateTypeID", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("AssociateType", Matchers.everyItem(Matchers.notNullValue()));

		if (associateTypeId >= 4) {

			response.then().body("", Matchers.empty());
		}
	}

	@Test(dataProvider = "Months")
	public void test_GetEmployeeWeeklyOffDetails(int month) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("employeeid", Emp_id);
		map.put("employmentdetailid", employeedetailID);
		map.put("Month", month);
		map.put("Year", 2025);

		Response response = listAssociate.GetEmployeeWeeklyOffDetails(Parsetoken(token), Emp_id, map);
		response.then().statusCode(200).and().body("DayID", (Matchers.greaterThan(0))).time(Matchers.lessThan(10000L))
				.and().body("WeekOffTypeID", (Matchers.notNullValue())).and().body("Name", (Matchers.notNullValue()));

	}
}
