package com.api.base;

import java.util.Map;

import com.api.models.request.UpdateUserProfileData;
import com.api.models.request.patchUpdateUserProfiledata;

import io.restassured.response.Response;

public class ListAssociateService extends BaseService {

	private static final String BASE_PATH = "api/ListOfAssociate/";
	public static final String get_Employee_Basicdetail_EndPoint = "/GetEmployeeBasicDetails";

	public Response getRequestwithParams(String endpoint, Map<String, Object> queryParams, String token) {

		setAuthtoken(token);
		return super.getRequestwithParams(endpoint, queryParams, token);
	}

	public Response modifyProfile(String token, UpdateUserProfileData updateUserProfileData) {
		setAuthtoken(token);

		return putRequest(updateUserProfileData, BASE_PATH + "/profile");

	}

	public Response getListofAssociate(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetListOfAssociate");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetListOfAssociate");

	}

	public Response getRoleHistoryDLL(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetRoleHistoryDDL");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetRoleHistoryDDL");

	}

	public Response getContractCommitment(String token, String EmployeeID, Map<String, Object> headers) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetContractCommitment");
		}

		setHeaders(headers);
		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetContractCommitment");

	}

	public Response GetEmployeeWeeklyOffDetails(String token, String EmployeeID, Map<String, Object> headers) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetEmployeeWeeklyOffDetails");
		}

		setHeaders(headers);
		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetEmployeeWeeklyOffDetails");

	}

	public Response getRequestofPlainText(String token, String EmployeeId, String Endpoint,
			Map<String, Object> headers) {

		setAuthtoken(token);
		setHeaders(headers);
		return super.getRequestofPlainText(BASE_PATH + EmployeeId + Endpoint);
	}

	public Response getRequestofPlainText(String token, String EmployeeId, String Endpoint) {

		setAuthtoken(token);
		return super.getRequestofPlainText(BASE_PATH + EmployeeId + Endpoint);
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
