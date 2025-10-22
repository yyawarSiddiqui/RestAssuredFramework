package com.api.test.hr;

import static com.api.constant.Roles.HR;
import static com.api.utils.JwtDecoder.DecodedJWTbyUSer;

import java.util.Map;

import com.api.base.BaseService;
import com.api.models.request.patchUpdateUserProfiledata;
import com.api.models.response.JwtDecodedResponse;

import io.restassured.response.Response;

public class RoleMaster extends BaseService {

	private static final String BASE_PATH = "api/RoleMaster/";
	public static final String ENDPOINT_RRF_GET_HIRING_LOCATION = "/GetHiringLocations";
	JwtDecodedResponse decodedResponse = new JwtDecodedResponse();
	String Empid;

	public RoleMaster() {

		decodedResponse = DecodedJWTbyUSer(HR);
		this.Empid = decodedResponse.getEmployeeID();
	}

	public Response getRoleListByEMP(String token) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + Empid + "/RoleList");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + Empid + "/RoleList");

	}

	public Response getRequestwithParams(String endpoint, Map<String, Object> queryParams, String token) {

		setAuthtoken(token);
		return super.getRequestwithParams(endpoint, queryParams, token);
	}

	
	public Response Create_OR_UpdateRoleHR(Object payload,String EmployeeId,String token) {

		setAuthtoken(token);
		return postRequest(payload, BASE_PATH + EmployeeId+"/Role/HR");
	}
//	public Response modifyProfile(String token, UpdateUserProfileData updateUserProfileData) {
//		setAuthtoken(token);
//
//		return putRequest(updateUserProfileData, BASE_PATH + "/profile");
//
//	}

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
