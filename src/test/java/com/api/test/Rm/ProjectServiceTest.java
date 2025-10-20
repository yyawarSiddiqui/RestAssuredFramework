package com.api.test.Rm;
import static com.api.constant.Roles.RM;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;
import static com.api.utils.ParseToken.Parsetoken;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.base.ProjectService;
import com.api.models.response.getProjectbyEmployeeID;
import com.api.utils.AuthTokenProvider;

import io.restassured.response.Response;

public class ProjectServiceTest {

	@Test
	public void getProjectsByEmployee() {

		String Emp_id = getEmployeeID(RM);
		String token = AuthTokenProvider.getToken(RM);
		ProjectService projectService = new ProjectService();
		Response response = projectService.getProjectsByEMPid(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(5000L)).and().body("ProjectId", Matchers.everyItem(Matchers.notNullValue()))
				.and().body("ProjectName", Matchers.everyItem(Matchers.notNullValue()));

		List<getProjectbyEmployeeID> list = response.jsonPath().getList("", getProjectbyEmployeeID.class);
		
		for (getProjectbyEmployeeID getProjectbyEmployeeID : list) {
			
		}

	}
}
