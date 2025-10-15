package com.api.test.departmentServiceTest;

import static com.api.constant.Roles.HR;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;
import static com.api.utils.ParseToken.Parsetoken;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.List;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.base.DepartmentService;
import com.api.models.response.ApprovedDepartmentList;
import com.api.utils.AuthTokenProvider;

import io.restassured.response.Response;

public class DepartmentServiceTest {

	@Test
	public void getApprovedDepartmentList_test() {

		String Emp_id = getEmployeeID(HR);
		String token = AuthTokenProvider.getToken(HR);

		DepartmentService departmentService = new DepartmentService();
		Response response = departmentService.getApprovedDepartmentList(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(5000L)).and().body("id", Matchers.everyItem(Matchers.notNullValue()))
				.and().body("name", Matchers.everyItem(Matchers.notNullValue()));

		List<ApprovedDepartmentList> list = response.jsonPath().getList("", ApprovedDepartmentList.class);

		for (ApprovedDepartmentList approvedDepartmentList : list) {
		
		assertNotEquals(approvedDepartmentList.getId(), approvedDepartmentList.getId()>0);	
		}
	}
}
