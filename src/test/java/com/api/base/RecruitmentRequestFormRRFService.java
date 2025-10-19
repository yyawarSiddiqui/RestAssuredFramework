package com.api.base;

import static com.api.constant.Roles.HR;
import java.util.Map;
import com.api.models.request.patchUpdateUserProfiledata;
import com.api.models.response.JwtDecodedResponse;
import static com.api.utils.JwtDecoder.*;

import io.restassured.response.Response;

public class RecruitmentRequestFormRRFService extends BaseService {

	JwtDecodedResponse decodedResponse = new JwtDecodedResponse();

	private static final String BASE_PATH = "api/rrf/";
	public static final String ENDPOINT_RRF_JOB_TITLE = "/GetRRFNoWithJobTitle";
	public static final String ENDPOINT_RRF_BYRRFID = "/GetRRFByRRFID";
	String Empid;

	public RecruitmentRequestFormRRFService(String token) {
		decodedResponse = DecodedJWTbyUSer(HR);
		this.Empid = decodedResponse.getEmployeeID();

	}

	public RecruitmentRequestFormRRFService() {

	}

	public Response getTechnologies(String token) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + Empid + "/Technologies");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + Empid + "/Technologies");

	}

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

	public String getEmpID() {
		return Empid;
	}

}
