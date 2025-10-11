package com.api.base;

import static com.api.constant.Roles.*;

import java.util.List;
import java.util.Map;

import com.api.models.request.UpdateUserProfileData;

import com.api.models.request.patchUpdateUserProfiledata;
import com.api.models.response.JwtDecodedResponse;
import com.api.utils.JwtDecoder;

import io.restassured.response.Response;

public class RecruitmentRequestFormRRFService extends BaseService {

	JwtDecodedResponse decodedResponse = new JwtDecodedResponse();

	private static final String BASE_PATH = "api/rrf/";

	public Response getTechnologies(String token) {

		decodedResponse = JwtDecoder.DecodedJWTbyUSer(HR);
		String Empid = decodedResponse.getEmployeeID();

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + Empid + "/Technologies");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + Empid + "/Technologies");

	}

	@Override
	protected Response getRequestwithParams(String endpoint, Map<String, Object> queryParams, String token) {

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

}
