package com.api.base;

import com.api.models.request.UpdateUserProfileData;
import com.api.models.request.patchUpdateUserProfiledata;

import io.restassured.response.Response;

public class UserProfileManagementService extends BaseService {

	private static final String BASE_PATH = "api/users";

	public Response getProfile(String token) {

		setAuthtoken(token);
		return getRequest(BASE_PATH + "/profile");

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
