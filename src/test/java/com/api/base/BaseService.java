package com.api.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService { // wrapper for restAssured

	// Base URI
	// Creating the Request
	// Handling the Response

	private final static String BASE_URL = "http://64.227.160.186:8080/";
	private RequestSpecification requestSpecification;

	public BaseService() {

		requestSpecification = RestAssured.given().baseUri(BASE_URL);
	}

	protected Response postRequest(Object payload, String endpoint) {

		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);

	}

	protected RequestSpecification setAuthtoken(String token) {

		return requestSpecification.header("Authorization","Bearer "+token);

	}

	protected Response getRequest(String endpoint) {

		return requestSpecification.get(endpoint);

	}

}