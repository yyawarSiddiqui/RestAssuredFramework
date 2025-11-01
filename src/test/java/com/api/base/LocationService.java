package com.api.base;

import java.util.Map;

import com.api.models.request.patchUpdateUserProfiledata;

import io.restassured.response.Response;

public class LocationService extends BaseService {

	private static final String BASE_PATH = "api/Location/";

	public Response getRequestwithParams(String endpoint, Map<String, Object> queryParams, String token) {

		setAuthtoken(token);
		return super.getRequestwithParams(endpoint, queryParams, token);
	}

//	public Response modifyProfile(String token, UpdateUserProfileData updateUserProfileData) {
//		setAuthtoken(token);
//
//		return putRequest(updateUserProfileData, BASE_PATH + "/profile");
//
//	}

	public Response getLocationList(String token, String EmployeeID, Map<String, Object> val) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/LocationList");
		}

		setAuthtoken(token);
		setHeaders(val);
		return getRequest(BASE_PATH + EmployeeID + "/LocationList");

	}

	public Response deleteProfile(String token) {
		setAuthtoken(token);

		return deleteRequest(BASE_PATH + "/profile", "confirmationCode", "dfdfdg");

	}

	public Response patchUpdateProfile(String token, patchUpdateUserProfiledata patchUpdateUserProfiledata) {
		setAuthtoken(token);

		return patchRequest(patchUpdateUserProfiledata, BASE_PATH + "/profile");

	}
	
	public Response SaveEmployeeDetails(Object payload,String EmployeeId,String token) {

		setAuthtoken(token);
		return postRequest(payload, BASE_PATH + EmployeeId+"/SaveEmployeeBasicDetailsCTE");
	}

	public static String getBasePath() {
		return BASE_PATH;
	}
}
