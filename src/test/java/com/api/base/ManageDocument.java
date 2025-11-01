package com.api.base;

import java.util.Map;

import com.api.models.request.patchUpdateUserProfiledata;

import io.restassured.response.Response;

public class ManageDocument extends BaseService {

	private static final String BASE_PATH = "api/ManageDocument/";

	public Response getRequestwithParams(String endpoint, Map<String, Object> queryParams, String token) {

		setAuthtoken(token);
		return super.getRequestwithParams(endpoint, queryParams, token);
	}

	public Response getGetAssessmentTrainingListMGR(String token, String EmployeeID, Map<String, Object> val) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetAssessmentTrainingList/MGR");
		}

		setAuthtoken(token);
		setHeaders(val);
		return getRequest(BASE_PATH + EmployeeID + "/GetAssessmentTrainingList/MGR");

	}
	
	public Response getGetAssessmentTrainingListADM(String token, String EmployeeID, Map<String, Object> val) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetAssessmentTrainingList/ADM");
		}

		setAuthtoken(token);
		setHeaders(val);
		return getRequest(BASE_PATH + EmployeeID + "/GetAssessmentTrainingList/ADM");

	}
	
	public Response getGetAssessmentQuestions(String token, String EmployeeID, Map<String, Object> val) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetAssessmentQuestions");
		}

		setAuthtoken(token);
		setHeaders(val);
		return getRequest(BASE_PATH + EmployeeID + "/GetAssessmentQuestions");

	}
	
	public Response getTrainingStatusReportMGR(String token, String EmployeeID, Map<String, Object> val) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetTrainingStatusReport/MGR");
		}

		setAuthtoken(token);
		setHeaders(val);
		return getRequest(BASE_PATH + EmployeeID + "/GetTrainingStatusReport/MGR");

	}
	
	public Response getTrainingStatusReportADM(String token, String EmployeeID, Map<String, Object> val) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetTrainingStatusReport/ADM");
		}

		setAuthtoken(token);
		setHeaders(val);
		return getRequest(BASE_PATH + EmployeeID + "/GetTrainingStatusReport/ADM");

	}
	
	public Response GetAssessmentTrainingByID(String token, String EmployeeID, Map<String, Object> val) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetAssessmentTrainingByID");
		}

		setAuthtoken(token);
		setHeaders(val);
		return getRequest(BASE_PATH + EmployeeID + "/GetAssessmentTrainingByID");

	}
	
	public Response getGetAssessmentDocumentsList(String token, String EmployeeID, Map<String, Object> val) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetAssessmentDocumentsList");
		}

		setAuthtoken(token);
		setHeaders(val);
		return getRequest(BASE_PATH + EmployeeID + "/GetAssessmentDocumentsList");

	}
	public Response AddUpdateTraining(Object payload, String EmployeeId, String token) {

		setAuthtoken(token);
		return postRequest(payload, BASE_PATH + EmployeeId + "/AddUpdateTraining/MGR");
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
