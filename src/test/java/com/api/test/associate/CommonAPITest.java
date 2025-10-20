package com.api.test.associate;
import static com.api.base.CommonService.ENDPOINT_GetAllEMPLOYEE;
import static com.api.base.CommonService.ENDPOINT_GetAllReportingMgr;
import static com.api.base.CommonService.ENDPOINT_RRF_GET_ROLEWISE_TITLE;
import static com.api.base.CommonService.getBasePath;
import static com.api.constant.Roles.ASSOCIATE;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;
import static com.api.utils.ParseToken.Parsetoken;
import static com.api.utils.getEmployeeDetailID.GetEmployeedetailID;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.base.CommonService;
import com.api.models.response.GetAllEmployee;
import com.api.models.response.RolebasedUserMenu;
import com.api.models.response.getAssociateTypeResponse;
import com.api.models.response.getGenderResponse;
import com.api.models.response.getRRFbyIDResponse;
import com.api.utils.AuthTokenProvider;

import io.restassured.response.Response;

public class CommonAPITest {

	private CommonService commonService;
	private String Emp_id;
	private String token;
	private String employeedetailID;
	private File file;

	@BeforeClass
	public void setup() {

		Emp_id = getEmployeeID(ASSOCIATE);
		token = AuthTokenProvider.getToken(ASSOCIATE);
		commonService = new CommonService();
		employeedetailID = GetEmployeedetailID(ASSOCIATE);

	}

	@BeforeMethod
	public void initializeFilepath(Method method) {
		if (method.getName().equalsIgnoreCase("test_uploadImage")) {

			file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
					+ File.separator + "resources" + File.separator + "UploadFile" + File.separator
					+ "Screenshot 2025-09-19 200857.png");
		}
	}

	@Test
	public void test_getRRFBYID() {

		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("RoleIds", 7);
		queryParams.put("eID", 0);
		queryParams.put("FAC", 0);

		Response response = commonService.getRequestwithParams(getBasePath() + Emp_id + ENDPOINT_RRF_GET_ROLEWISE_TITLE,
				queryParams, Parsetoken(token));

		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.body("employeeID", Matchers.everyItem(Matchers.notNullValue()))
				.body("employeeName", Matchers.everyItem(Matchers.notNullValue()));

		List<getRRFbyIDResponse> list = response.jsonPath().getList("", getRRFbyIDResponse.class);
		Assert.assertNotNull(list.get(0).getEmployeeID());

	}

	@Test
	public void test_GetAllReportingMagaer() {

		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("FAC", 0);
		Response response = commonService.getRequestwithParams(getBasePath() + Emp_id + ENDPOINT_GetAllReportingMgr,
				queryParams, Parsetoken(token));

		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.body("employeeID", Matchers.everyItem(Matchers.notNullValue())).time(Matchers.lessThan(20000L))
				.body("employeeName", Matchers.everyItem(Matchers.notNullValue()));

	}

	@Test
	public void getRoleBasedUserMenu() {

		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("FAC", 0);

		Response response = commonService.getRequestofPlainText(Parsetoken(token), Emp_id,
				CommonService.ENDPOINT_GetRoleBasedUserMenu);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L));

		List<RolebasedUserMenu> list = response.jsonPath().getList("", RolebasedUserMenu.class);

		for (RolebasedUserMenu rolebasedUserMenu : list) {

			assertNotEquals(rolebasedUserMenu.getMenuID(), 0);

		}

	}

	@Test
	public void getAllEmployees() {

		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("FAC", 1);
		queryParams.put("CE", 1);
		queryParams.put("DepartmentID", "");
		queryParams.put("CompanyID", 0);
		queryParams.put("LocationID", 0);
		queryParams.put("ProCenIds", "");

		Response response = commonService.getRequestwithParams(getBasePath() + Emp_id + ENDPOINT_GetAllEMPLOYEE,
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

		Response response = commonService.getExperience(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("name", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("id", Matchers.everyItem(Matchers.notNullValue()));

		// List<GetExperience> list = response.jsonPath().getList("",
		// GetExperience.class);

	}

	@Test
	public void getTechnology() {

		Response response = commonService.getTechnonlogy(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("ID", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("Technology", Matchers.everyItem(Matchers.notNullValue()));

		// List<GetTechnoloyResponse> list = response.jsonPath().getList("",
		// GetTechnoloyResponse.class);

	}

	@Test
	public void getAssociateType() {

		Response response = commonService.getAssociateType(Parsetoken(token), Emp_id);
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

		Response response = commonService.GetGender(Parsetoken(token), Emp_id);
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

		Response response = commonService.GetMartialStatus(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("id", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("name", Matchers.everyItem(Matchers.notNullValue()))
				.body("", Matchers.hasSize(Matchers.greaterThanOrEqualTo(2)));

	}

	@Test
	public void getEducation() {

		Response response = commonService.GetEducation(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("DegreeLevel", Matchers.everyItem(Matchers.notNullValue()))
				.and().body("Value", Matchers.everyItem(Matchers.notNullValue()))
				.body("", Matchers.hasSize(Matchers.greaterThanOrEqualTo(2)));

	}

	@Test
	public void test_getProfitCentre() {

		Response response = commonService.GetProfitCentre(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and()
				.body("ProfitCenterID", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("ProfitCenterID", Matchers.everyItem(Matchers.notNullValue()))
				.body("", Matchers.hasSize(Matchers.greaterThanOrEqualTo(0)));

	}

	@Test
	public void test_getTimeSheet() {

		Response response = commonService.GetTimesheet(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("id", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("name", Matchers.everyItem(Matchers.notNullValue()))
				.body("", Matchers.hasSize(Matchers.greaterThanOrEqualTo(0)));

	}

	@Test
	public void test_getBioMetricCardNumber() {

		Response response = commonService.GetBioMetricCardNumber(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L));

	}

	@Test
	public void test_GetStandardWeekDays() {

		Response response = commonService.GetStandardWeekDays(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("id", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("name", Matchers.everyItem(Matchers.notNullValue()))
				.body("", Matchers.hasSize(Matchers.greaterThanOrEqualTo(0)));

	}

	@Test
	public void test_GetStates() {

		Response response = commonService.GetDegreeLevel(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("id", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("name", Matchers.everyItem(Matchers.notNullValue()))
				.body("", Matchers.hasSize(Matchers.greaterThanOrEqualTo(0)));

	}

	@Test
	public void test_GetRealtionship() {

		Response response = commonService.GetRelationship(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("id", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("name", Matchers.everyItem(Matchers.notNullValue()))
				.body("", Matchers.hasSize(Matchers.greaterThanOrEqualTo(0)));

	}

	@Test
	public void test_GetTypeofAccount() {

		Response response = commonService.GetTypesOfAccount(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("id", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("name", Matchers.everyItem(Matchers.notNullValue()))
				.body("", Matchers.hasSize(Matchers.greaterThanOrEqualTo(0)));

	}

	@Test
	public void test_Getyears() {

		Response response = commonService.GetYears(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("id", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("name", Matchers.everyItem(Matchers.notNullValue()))
				.body("", Matchers.hasSize(Matchers.greaterThanOrEqualTo(0)));

	}

	@Test
	public void test_GetIdentity() {

		Response response = commonService.GetIdentityName(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("id", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("name", Matchers.everyItem(Matchers.notNullValue()))
				.body("", Matchers.hasSize(Matchers.greaterThanOrEqualTo(0)));

	}

	@Test
	public void test_ISFlexibleWeekoffAllowByDept() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("departmentid", 6);
		Response response = commonService.ISFlexibleWeekoffAllowBYdept(Parsetoken(token), Emp_id, map);
		response.then().statusCode(200).and().body("Id", (Matchers.greaterThan(0))).time(Matchers.lessThan(10000L))
				.and().body("Id", (Matchers.notNullValue())).and().body("Name", (Matchers.notNullValue()));

	}

	@Test
	public void test_getType_of_Account() {

		Response response = commonService.getTypeofAccount(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().time(Matchers.lessThan(10000L)).and()
				.body("id", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("name", Matchers.everyItem(Matchers.notNullValue()));

	}

	@Test
	public void test_getIdenityName() {

		Response response = commonService.getIdentityName(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().time(Matchers.lessThan(10000L)).and()
				.body("id", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("name", Matchers.everyItem(Matchers.notNullValue()));

	}

	@Test
	public void test_uploadImage() {

		Map<String, Object> map11 = new HashMap<String, Object>();
		map11.put("FileName", "image.png");
		map11.put("file", file);
		map11.put("DocType", "PROFILE");

		Response response = commonService.UploadImage(map11, Emp_id, Parsetoken(token));
		response.then().statusCode(200).and().time(Matchers.lessThan(10000L));

	}

	@Test
	public void test_uploadFiles() {

		Response response = commonService.Uploadfiles(Emp_id, Parsetoken(token));
		response.then().statusCode(200).and().time(Matchers.lessThan(10000L));

	}
}
