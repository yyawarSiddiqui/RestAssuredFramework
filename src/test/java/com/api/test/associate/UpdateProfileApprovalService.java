package com.api.test.associate;

import java.util.Map;

import com.api.base.BaseService;
import com.api.models.request.patchUpdateUserProfiledata;

import io.restassured.response.Response;

public class UpdateProfileApprovalService extends BaseService {

	private static final String BASE_PATH = "api/UpdateProfileApproval/";
	public static final String get_Employee_Basicdetail_EndPoint = "";

	public Response getRequestwithParams(String endpoint, Map<String, Object> queryParams, String token) {

		setAuthtoken(token);
		return super.getRequestwithParams(endpoint, queryParams, token);
	}

	public Response GetSectionWiseEmployeeDocuments(String token, String EmployeeID, Map<String, Object> headers) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetSectionWiseEmployeeDocuments");
		}

		setHeaders(headers);
		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetSectionWiseEmployeeDocuments");

	}

	public Response SaveEmployeeDetails(Object payload, String EmployeeId, String token) {

		setAuthtoken(token);
		return postRequest(payload, BASE_PATH + EmployeeId + "/SaveEmployeeBasicDetailsCTE");
	}

	public Response UpdateAssociateDetails(Object payload, String EmployeeId, String token) {

		setAuthtoken(token);
		return postRequest(payload, BASE_PATH + EmployeeId + "/UpdateAssociateDetails");
	}

	public Response getRequestofPlainText(String token, String EmployeeId, String Endpoint,
			Map<String, Object> headers) {

		setAuthtoken(token);
		setHeaders(headers);
		return super.getRequestofPlainText(BASE_PATH + EmployeeId + Endpoint);
	}
	
	public Response GetAssociateUpdateRequest(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetAssociateUpdateRequest");
		}
		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetAssociateUpdateRequest");

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