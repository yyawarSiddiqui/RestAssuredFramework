package com.api.base;

import java.util.Map;

import com.api.models.request.UpdateUserProfileData;
import com.api.models.request.patchUpdateUserProfiledata;
import com.api.models.response.JwtDecodedResponse;

import io.restassured.response.Response;

public class CommonService extends BaseService {

	JwtDecodedResponse decodedResponse = new JwtDecodedResponse();
	private static final String BASE_PATH = "api/common/";
	public static final String ENDPOINT_RRF_GET_ROLEWISE_TITLE = "/GetRolewiseEmployees";
	public static final String ENDPOINT_GetAllReportingMgr = "/GetAllReportingMgr";

	public CommonService() {

	}

	public Response getRequestwithParams(String endpoint, Map<String, Object> queryParams, String token) {

		setAuthtoken(token);
		return super.getRequestwithParams(endpoint, queryParams, token);
	}

	public Response modifyProfile(String token, UpdateUserProfileData updateUserProfileData) {
		setAuthtoken(token);

		return putRequest(updateUserProfileData, BASE_PATH + "/profile");

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
