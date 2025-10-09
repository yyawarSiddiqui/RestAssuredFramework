package com.api.base;

import com.api.filters.LoggingFilter;
import static com.api.utils.ConfigManager2.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService { // wrapper for restAssured

	// Base URI
	// Creating the Request
	// Handling the Response

	private final static String BASE_URL = getProperty("Base_URI");
	private RequestSpecification requestSpecification;

	static {

		RestAssured.filters(new LoggingFilter());
	}

	public BaseService() {

		requestSpecification = RestAssured.given().baseUri(BASE_URL);
	}

	protected Response postRequest(Object payload, String endpoint) {

//		Object Datatype is passed here which is OBJECT

		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);

	}

	protected RequestSpecification setAuthtoken(String token) {

		return requestSpecification.header("Authorization", "Bearer " + token);

	}

	protected Response getRequest(String endpoint) {

		return requestSpecification.get(endpoint);

	}

	protected Response putRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);

	}

	protected Response deleteRequest(String endpoint, String paramName, String paramValue) {
		return requestSpecification.queryParam(paramName, paramValue).delete(endpoint);

	}

	protected Response patchRequest(Object Payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(Payload).patch(endpoint);

	}

	protected Response getRequestWithoutAuth(String endpoint) {
		return RestAssured.given().baseUri(BASE_URL).when().get(endpoint).then().extract().response();
	}

}