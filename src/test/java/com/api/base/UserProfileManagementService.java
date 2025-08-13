package com.api.base;

import com.api.models.request.UpdateUserProfileData;

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

}
