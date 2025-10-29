package com.api.base;

import java.util.Map;

import com.api.models.request.patchUpdateUserProfiledata;
import com.api.models.response.JwtDecodedResponse;

import io.restassured.response.Response;

public class PerformanceEvaluationService extends BaseService {

	
	JwtDecodedResponse decodedResponse = new JwtDecodedResponse();
	private static final String BASE_PATH = "api/PerformanceEvaluation/";

	public PerformanceEvaluationService() {

	}

	public Response getRequestwithParams(String endpoint, Map<String, Object> queryParams, String token) {

		setAuthtoken(token);
		return super.getRequestwithParams(endpoint, queryParams, token);
	}

//		public Response modifyProfile(String token, UpdateUserProfileData updateUserProfileData) {
//			setAuthtoken(token);
	//
//			return putRequest(updateUserProfileData, BASE_PATH + "/profile");
	//
//		}

	public Response PendingPerformanceEvaluationData(String token, String EmployeeID, Map<String, Object> headers) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetPendingPerformanceEvaluationData");
		}

		setAuthtoken(token);
		setHeaders(headers);
		return getRequest(BASE_PATH + EmployeeID + "/GetPendingPerformanceEvaluationData");

	}
	
	public Response MyMeetingRoomList(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/MyMeetingRoomList");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/MyMeetingRoomList");

	}
	
	public Response AddMeetingRoomBookingDetails(Object payload, String EmployeeId, String token) {

		setAuthtoken(token);
		return postRequest(payload, BASE_PATH + EmployeeId + "/AddMeetingRoomBookingDetails");
	}

	public Response getRequestofPlainText(String token, String EmployeeId) {

		setAuthtoken(token);
		return super.getRequestofPlainText(BASE_PATH + EmployeeId + "/GetRoleBasedUserMenu");
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
