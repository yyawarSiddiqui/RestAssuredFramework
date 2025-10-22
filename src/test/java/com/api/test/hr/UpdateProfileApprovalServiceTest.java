package com.api.test.hr;

import static com.api.constant.Roles.HR;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;
import static com.api.utils.ParseToken.Parsetoken;
import static com.api.utils.getEmployeeDetailID.GetEmployeedetailID;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.api.base.UpdateProfileApprovalService;
import com.api.base.UpdateProfileService;
import com.api.models.response.JwtDecodedResponse;
import com.api.utils.AuthTokenProvider;
import com.api.utils.JwtDecoder;

import io.restassured.response.Response;

public class UpdateProfileApprovalServiceTest {

	private String Emp_id;
	private String token;
	private String employeedetailID;
	private UpdateProfileApprovalService approvalService;
	private JwtDecodedResponse decodedResponse;

	@BeforeClass
	public void setup() {
		decodedResponse = JwtDecoder.DecodedJWTbyUSer(HR);
		Emp_id = getEmployeeID(HR);
		token = AuthTokenProvider.getToken(HR);
		employeedetailID = GetEmployeedetailID(HR);
		approvalService = new UpdateProfileApprovalService();
	}

	@Test
	public void test_GetAssociateUpdateRequest() {

		Response response = approvalService.GetAssociateUpdateRequest(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().time(Matchers.lessThan(10000L))
		.body("", Matchers.everyItem(Matchers.hasKey("EmployeeId")));

		// List<GetExperience> list = response.jsonPath().getList("",
		// GetExperience.class);

	}
	
	@Test(dependsOnGroups  = "Update Associate Details")
	public void test_GetSectionWiseEmployeeDocuments() {
		
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("employeeid", Emp_id);
		Response response = approvalService.GetSectionWiseEmployeeDocuments(Parsetoken(token), Emp_id, map);
		response.then().statusCode(200).and().time(Matchers.lessThan(10000L));

		// List<GetExperience> list = response.jsonPath().getList("",
		// GetExperience.class);

	}
	

}
