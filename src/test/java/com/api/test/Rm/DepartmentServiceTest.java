package com.api.test.Rm;
import static com.api.constant.Roles.HR;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;
import static com.api.utils.ParseToken.Parsetoken;
import static org.testng.Assert.assertNotEquals;

import java.util.List;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.api.base.DepartmentService;
import com.api.models.request.DepartmentCreationData;
import com.api.models.response.ApprovedDepartmentList;
import com.api.utils.AuthTokenProvider;

import io.restassured.response.Response;

public class DepartmentServiceTest {

	@DataProvider(name = "departmentData")
	public Object[][] departmentdata() {

		return new Object[][] {

				{ DepartmentCreationData.builder().functionId(5).functionName("Accounts123").functionCategory("General")
						.functionCode("AC123").departmentEmail("vishnu.gupta@impressico.com").isUsedInTicket(2)
						.isUsedInAMS(false).isFlexibleWeeklyOff(null).active(true).build() },
				{ DepartmentCreationData.builder().functionId(1017).functionName("HR213").functionCategory("Admin")
						.functionCode("HR1223").departmentEmail("hr.team@impessico.com").isUsedInTicket(1)
						.isUsedInAMS(true).isFlexibleWeeklyOff(false).active(true).build() }

		};
	}

	@Test
	public void getApprovedDepartmentList_test() {

		String Emp_id = getEmployeeID(HR);
		String token = AuthTokenProvider.getToken(HR);

		DepartmentService departmentService = new DepartmentService();
		Response response = departmentService.getApprovedDepartmentList(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(5000L)).and().body("id", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("name", Matchers.everyItem(Matchers.notNullValue()));

		List<ApprovedDepartmentList> list = response.jsonPath().getList("", ApprovedDepartmentList.class);

		for (ApprovedDepartmentList approvedDepartmentList : list) {

			assertNotEquals(approvedDepartmentList.getId(), approvedDepartmentList.getId() > 0);
		}
	}

	@Test()
	public void getAllDepartment_test() {

		String Emp_id = getEmployeeID(HR);
		String token = AuthTokenProvider.getToken(HR);

		DepartmentService departmentService = new DepartmentService();
		Response response = departmentService.getAllDepartmentList(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(5000L)).and().body("functionId", Matchers.everyItem(Matchers.notNullValue()))
				.and().body("functionName", Matchers.everyItem(Matchers.notNullValue()))
				.and().body("[0]", Matchers.hasKey("functionId"));

	}

	@Test(dataProvider = "departmentData")
	public void createDepartment_test(DepartmentCreationData creationData) {

		String Emp_id = getEmployeeID(HR);
		String token = AuthTokenProvider.getToken(HR);
		DepartmentService departmentService = new DepartmentService();

		Response response = departmentService.SaveDepartmentDetails(creationData, Emp_id, Parsetoken(token));
		response.then().statusCode(200).and().time(Matchers.lessThan(5000L)).and()
				.body("success", Matchers.equalToObject(true)).and()
				.body("message", Matchers.equalToObject("Department has been sent for Approval."));

	}
}
