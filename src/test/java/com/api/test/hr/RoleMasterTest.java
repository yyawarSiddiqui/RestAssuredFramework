package com.api.test.hr;

import static com.api.constant.Roles.HR;
import static com.api.utils.FakerdataCreation.getRandomString;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;
import static com.api.utils.ParseToken.Parsetoken;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.api.base.RoleMaster;
import com.api.models.request.Employee;
import com.api.utils.AuthTokenProvider;

import io.restassured.response.Response;

public class RoleMasterTest {

	private RoleMaster roleMaster;
	private String Emp_id;
	private String token;

	@DataProvider(name="Roledata")
	public Object[][] employeeDataProvider() {

		return new Object[][] {

				{ new Employee(104, "System Administrator", true) }, 
				{ new Employee(0, getRandomString(5), null) },
				{ new Employee(0, getRandomString(5), null) }

		};
	}

	@BeforeClass
	public void setup() {

		Emp_id = getEmployeeID(HR);
		token = AuthTokenProvider.getToken(HR);
		roleMaster = new RoleMaster();

	}

	@Test
	public void test_getRoleList() {

		Response response = roleMaster.getRoleListByEMP(Parsetoken(token));
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("id", Matchers.everyItem(Matchers.notNullValue()));

		// List<GetExperience> list = response.jsonPath().getList("",
		// GetExperience.class);

	}

	@Test(dataProvider = "Roledata")
	public void test_create_Update_role_HR(Employee employee) {

		Response response = roleMaster.Create_OR_UpdateRoleHR(employee, Emp_id, Parsetoken(token));
		response.then().statusCode(200).and().time(Matchers.lessThan(10000L));

	}

}
