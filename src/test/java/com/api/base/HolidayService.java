package com.api.base;

import java.util.Map;

import com.api.models.response.JwtDecodedResponse;

import io.restassured.response.Response;

public class HolidayService extends BaseService {

	JwtDecodedResponse decodedResponse = new JwtDecodedResponse();
	private static final String BASE_PATH = "api/Holiday/";
	public static final String ENDPOINT_RRF_GET_DEPARTMENTS = "/GetDepartments";
	public static final String ENDPOINT_GETLOCATIONS = "/GetLocations";
	public static final String ENDPOINT_GETHOLIDAYS = "/GetHolidays";

	public HolidayService() {

		
	}

	public Response getRequestwithParams(String endpoint, Map<String, Object> queryParams, String token) {

		setAuthtoken(token);
		return super.getRequestwithParams(endpoint, queryParams, token);
	}
	
	public Response getDepartments(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetDepartments");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetDepartments");

	}
	
	public Response getHolidays(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetHolidays");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetHolidays");

	}
	
	public static String getBasePath() {
		return BASE_PATH;
	}

}
