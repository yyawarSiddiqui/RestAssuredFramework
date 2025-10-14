package com.api.test.CommonServiceTest;

import static com.api.base.CommonService.*;
import static com.api.base.CommonService.ENDPOINT_RRF_GET_ROLEWISE_TITLE;
import static com.api.base.CommonService.getBasePath;
import static com.api.constant.Roles.HR;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;
import static com.api.utils.ParseToken.Parsetoken;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.CommonService;
import com.api.models.response.GetAllEmployee;
import com.api.models.response.GetExperience;
import com.api.models.response.GetTechnoloyResponse;
import com.api.models.response.RolebasedUserMenu;
import com.api.models.response.getAssociateTypeResponse;
import com.api.models.response.getGenderResponse;
import com.api.models.response.getRRFbyIDResponse;
import com.api.utils.AuthTokenProvider;

import io.restassured.response.Response;

public class CommonAPITest {

	@Test
	public void test_getRRFBYID() {

		String Emp_id = getEmployeeID(HR);
		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("RoleIds", 7);
		queryParams.put("eID", 0);
		queryParams.put("FAC", 0);
		String token = AuthTokenProvider.getToken(HR);
		CommonService RRFService = new CommonService();
		Response response = RRFService.getRequestwithParams(getBasePath() + Emp_id + ENDPOINT_RRF_GET_ROLEWISE_TITLE,
				queryParams, Parsetoken(token));

		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.body("employeeID", Matchers.everyItem(Matchers.notNullValue()))
				.body("employeeName", Matchers.everyItem(Matchers.notNullValue()));

		List<getRRFbyIDResponse> list = response.jsonPath().getList("", getRRFbyIDResponse.class);
		Assert.assertNotNull(list.get(0).getEmployeeID());

	}

	@Test
	public void test_GetAllReportingMagaer() {

		String Emp_id = getEmployeeID(HR);
		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("FAC", 0);
		String token = AuthTokenProvider.getToken(HR);
		CommonService RRFService = new CommonService();

		Response response = RRFService.getRequestwithParams(getBasePath() + Emp_id + ENDPOINT_GetAllReportingMgr,
				queryParams, Parsetoken(token));

		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.body("employeeID", Matchers.everyItem(Matchers.notNullValue())).time(Matchers.lessThan(20000L))
				.body("employeeName", Matchers.everyItem(Matchers.notNullValue()));

	}

	@Test
	public void getRoleBasedUserMenu() {

		String Emp_id = getEmployeeID(HR);
		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("FAC", 0);
		String token = AuthTokenProvider.getToken(HR);
		CommonService CommomService = new CommonService();
		Response response = CommomService.getRequestofPlainText(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L));

		List<RolebasedUserMenu> list = response.jsonPath().getList("", RolebasedUserMenu.class);

		for (RolebasedUserMenu rolebasedUserMenu : list) {

			assertNotEquals(rolebasedUserMenu.getMenuID(), 0);

		}

	}

	@Test
	public void getAllEmployees() {

		String Emp_id = getEmployeeID(HR);
		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("FAC", 1);
		queryParams.put("CE", 1);
		queryParams.put("DepartmentID", "");
		queryParams.put("CompanyID", 0);
		queryParams.put("LocationID", 0);
		queryParams.put("ProCenIds", "");
		String token = AuthTokenProvider.getToken(HR);
		CommonService CommomService = new CommonService();
		Response response = CommomService.getRequestwithParams(getBasePath() + Emp_id + ENDPOINT_GetAllEMPLOYEE,
				queryParams, Parsetoken(token));
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("employeeID", Matchers.everyItem(Matchers.notNullValue()))
				.and().body("employeeName", Matchers.everyItem(Matchers.notNullValue()));

		List<GetAllEmployee> list = response.jsonPath().getList("", GetAllEmployee.class);

		for (GetAllEmployee getAllEmployee : list) {

			assertNotEquals(getAllEmployee.getEmployeeID(), getAllEmployee.getEmployeeID() > 0);

		}

	}

	@Test
	public void getExperience() {

		String Emp_id = getEmployeeID(HR);
		String token = AuthTokenProvider.getToken(HR);
		CommonService CommomService = new CommonService();
		Response response = CommomService.getExperience(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("name", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("id", Matchers.everyItem(Matchers.notNullValue()));

		// List<GetExperience> list = response.jsonPath().getList("",
		// GetExperience.class);

	}

	@Test
	public void getTechnology() {

		String Emp_id = getEmployeeID(HR);
		String token = AuthTokenProvider.getToken(HR);
		CommonService CommomService = new CommonService();
		Response response = CommomService.getTechnonlogy(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("ID", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("Technology", Matchers.everyItem(Matchers.notNullValue()));

		// List<GetTechnoloyResponse> list = response.jsonPath().getList("",
		// GetTechnoloyResponse.class);

	}

	@Test
	public void getAssociateType() {

		String Emp_id = getEmployeeID(HR);
		String token = AuthTokenProvider.getToken(HR);
		CommonService CommomService = new CommonService();
		Response response = CommomService.getAssociateType(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and()
				.body("AssociateTypeId", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("AssociateTypeId", Matchers.everyItem(Matchers.notNullValue()));

		List<getAssociateTypeResponse> list = response.jsonPath().getList("", getAssociateTypeResponse.class);

		for (getAssociateTypeResponse getAssociateTypeResponse : list) {

			assertEquals(getAssociateTypeResponse.getAssociateTypeId() < 5, true);

		}

	}

	@Test
	public void getGender() {

		String Emp_id = getEmployeeID(HR);
		String token = AuthTokenProvider.getToken(HR);
		CommonService CommomService = new CommonService();
		Response response = CommomService.GetGender(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("id", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("name", Matchers.everyItem(Matchers.notNullValue()));

		List<getGenderResponse> list = response.jsonPath().getList("", getGenderResponse.class);

		int count = 0;
		for (getGenderResponse getGenderResponse : list) {

			getGenderResponse.getId();
			count++;
		}

		assertTrue(count <= 2, "Gender are available");

	}

	@Test
	public void getMartialStatus() {

		String Emp_id = getEmployeeID(HR);
		String token = AuthTokenProvider.getToken(HR);
		CommonService CommomService = new CommonService();
		Response response = CommomService.GetMartialStatus(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("id", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("name", Matchers.everyItem(Matchers.notNullValue()))
				.body("", Matchers.hasSize(Matchers.greaterThanOrEqualTo(2)));

	}

	@Test
	public void getEducation() {

		String Emp_id = getEmployeeID(HR);
		String token = AuthTokenProvider.getToken(HR);
		CommonService CommomService = new CommonService();
		Response response = CommomService.GetEducation(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("DegreeLevel", Matchers.everyItem(Matchers.notNullValue()))
				.and().body("Value", Matchers.everyItem(Matchers.notNullValue()))
				.body("", Matchers.hasSize(Matchers.greaterThanOrEqualTo(2)));

	}

}
