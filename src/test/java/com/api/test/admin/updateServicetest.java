package com.api.test.admin;
import static com.api.constant.Roles.HR;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;
import static com.api.utils.ParseToken.Parsetoken;
import static com.api.utils.getEmployeeDetailID.GetEmployeedetailID;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.api.base.UpdateProfileService;
import com.api.models.request.AssociateBasicInfoDetails;
import com.api.models.request.UpdateProfileRequest;
import com.api.models.response.EmployeeDetailsResponse;
import com.api.models.response.JwtDecodedResponse;
import com.api.utils.AuthTokenProvider;
import com.api.utils.JwtDecoder;

import io.restassured.response.Response;

public class updateServicetest {
	private String Emp_id;
	private String token;
	private String employeedetailID;
	private UpdateProfileService updateprofile;
	private JwtDecodedResponse decodedResponse;

	@BeforeClass
	public void setup() {
		decodedResponse = JwtDecoder.DecodedJWTbyUSer(HR);
		Emp_id = getEmployeeID(HR);
		token = AuthTokenProvider.getToken(HR);
		employeedetailID = GetEmployeedetailID(HR);
		updateprofile = new UpdateProfileService();
	}

	@Test
	public void test_GetAssociateDetails() {

		Map<String, Object> mapLOA = new HashMap<String, Object>();
		mapLOA.put("employeeid", Emp_id);

		Response response = updateprofile.GetAssociateDetails(Parsetoken(token), Emp_id, mapLOA);
		response.then().statusCode(200).and().time(Matchers.lessThan(10000L)).body("Data[0]", Matchers.hasKey("RowID"))
				.and().body("Data[0].EmployeeId", Matchers.equalTo(Integer.parseInt(Emp_id)));

		EmployeeDetailsResponse detailsResponse = response.as(EmployeeDetailsResponse.class);

		// List<GetExperience> list = response.jsonPath().getList("",
		// GetExperience.class);

	}

	@Test
	public void test_GetAssociateAddressDetails() {

		Map<String, Object> mapLOA = new HashMap<String, Object>();
		mapLOA.put("employeeid", Emp_id);

		Response response = updateprofile.GetAssociateAddressDetails(Parsetoken(token), Emp_id, mapLOA);
		response.then().statusCode(200).and().time(Matchers.lessThan(10000L))
				.body("[0].EmployeeId", Matchers.equalTo(Integer.parseInt(Emp_id))).and()
				.body("[0].EmployeeName", Matchers.equalTo("Akansha Sharma"));

		// List<GetExperience> list = response.jsonPath().getList("",
		// GetExperience.class);

	}

	@Test
	public void test_GetAssociateDesignationDetails() {

		Map<String, Object> mapLOA = new HashMap<String, Object>();
		mapLOA.put("employeeid", Emp_id);
		Response response = updateprofile.GetAssociateDesignationDetails(Parsetoken(token), Emp_id, mapLOA);
		response.then().statusCode(200).and().time(Matchers.lessThan(10000L)).body("[0].EmployeeID",
				Matchers.equalTo((Integer.parseInt(Emp_id))));

		// List<GetExperience> list = response.jsonPath().getList("",
		// GetExperience.class);

	}

	@Test
	public void test_UpdateAssociateDetails() {

		UpdateProfileRequest updateProfile = UpdateProfileRequest.builder()
				.associateBasicInfoDetails(AssociateBasicInfoDetails.builder().employeeName("Akansha").dob("1987-03-15").sex("F").build()).build();
		Response response = updateprofile.UpdateAssociateDetails(updateProfile, Emp_id, Parsetoken(token));
		response.then().statusCode(200).and().time(Matchers.lessThan(10000L)).body("[0].EmployeeID",
				Matchers.equalTo((Integer.parseInt(Emp_id))));

		// List<GetExperience> list = response.jsonPath().getList("",
		// GetExperience.class);

	}

}
