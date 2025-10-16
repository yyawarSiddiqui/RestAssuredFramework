package com.api.base;

import java.util.Map;

import com.api.models.request.UpdateUserProfileData;
import com.api.models.request.patchUpdateUserProfiledata;

import io.restassured.response.Response;

public class DepartmentService extends BaseService{

	
	private static final String BASE_PATH = "api/Department/";


	public Response getRequestwithParams(String endpoint, Map<String, Object> queryParams, String token) {

		setAuthtoken(token);
		return super.getRequestwithParams(endpoint, queryParams, token);
	}

	public Response modifyProfile(String token, UpdateUserProfileData updateUserProfileData) {
		setAuthtoken(token);

		return putRequest(updateUserProfileData, BASE_PATH + "/profile");

	}

	public Response getApprovedDepartmentList(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/ApprovedDepartmentList");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/ApprovedDepartmentList");

	}
	
	public Response getAllDepartmentList(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetAllDepartmentList");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetAllDepartmentList");

	}

	public Response SaveDepartmentDetails(Object payload,String EmployeeId,String token) {

		setAuthtoken(token);
		return postRequest(payload, BASE_PATH + EmployeeId+"/Department/HR");
	}
	
	public Response deleteProfile(String token) {
		setAuthtoken(token);

		return deleteRequest(BASE_PATH + "/profile", "confirmationCode", "dfdfdg");

	}

	public Response patchUpdateProfile(String token, patchUpdateUserProfiledata patchUpdateUserProfiledata) {
		setAuthtoken(token);

		return patchRequest(patchUpdateUserProfiledata, BASE_PATH + "/profile");

	}

	public static String getBasePath() {
		return BASE_PATH;
	}

}
