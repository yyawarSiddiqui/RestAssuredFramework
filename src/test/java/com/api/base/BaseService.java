package com.api.base;

import static com.api.utils.ConfigManager2.getProperty;

import java.io.File;
import java.util.Map;

import com.api.filters.LoggingFilter;

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
		RestAssured.registerParser("text/plain", io.restassured.parsing.Parser.JSON);
	}

	public BaseService() {

		requestSpecification = RestAssured.given().baseUri(BASE_URL);
	}

	protected Response postRequest(Object payload, String endpoint) {

		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);

	}
	
	protected Response postRequest( String endpoint) {

		return requestSpecification.contentType(ContentType.JSON).body("").post(endpoint);

	}
	

	protected Response postRequestforMultiPart( String endpoint) {

		return requestSpecification.contentType(ContentType.MULTIPART).post(endpoint);

	}

	protected RequestSpecification setAuthtoken(String token) {

		return requestSpecification.header("Authorization", "Bearer " + token);

	}

	protected RequestSpecification setHeaders(Map<String,Object> headers) {

		return requestSpecification.headers(headers);

	}

	protected Response getRequest(String endpoint) {

		return requestSpecification.get(endpoint);

	}

	public Response getRequestofPlainText(String endpoint) {

		return requestSpecification.contentType("text/plain").get(endpoint);

	}

	public Response getRequestwithParams(String endpoint, Map<String, Object> queryParams, String token) {

		setAuthtoken(token);
		return requestSpecification.queryParams(queryParams).get(endpoint);

	}
	
	protected RequestSpecification setMultipart(Map<String, Object> parts) {
	    for (Map.Entry<String, Object> entry : parts.entrySet()) {
	        Object value = entry.getValue();

	        if (value instanceof File) {
	            requestSpecification.multiPart(entry.getKey(), (File) value);
	        } else if (value instanceof String) {
	            requestSpecification.multiPart(entry.getKey(), value.toString());
	        } else {
	            throw new IllegalArgumentException("Unsupported multipart type for key: " + entry.getKey());
	        }
	    }
	    return requestSpecification;
	}
	
	protected RequestSpecification setHeaderswithinstanceQueryParam(Map<String, Object> parts) {
	    for (Map.Entry<String, Object> entry : parts.entrySet()) {
	        Object value = entry.getValue();

	        if (value instanceof Integer) {
	            requestSpecification.queryParam(entry.getKey(), (int) value);
	        } else if (value instanceof String) {
	            requestSpecification.queryParam(entry.getKey(), value.toString());
	        } else if (value instanceof Boolean) {
	            requestSpecification.queryParam(entry.getKey(), (Boolean)value);
	        } else {
	            throw new IllegalArgumentException("Unsupported multipart type for key: " + entry.getKey());
	        }
	    }
	    return requestSpecification;
	}
	
	protected RequestSpecification setHeaderswithinstanceWithHeader(Map<String, Object> parts) {
	 
		
		for (Map.Entry<String, Object> entry : parts.entrySet()) {
	        Object value = entry.getValue();

	        if (value instanceof Integer) {
	            requestSpecification.header(entry.getKey(), (int) value);
	        } else if (value instanceof String) {
	            requestSpecification.header(entry.getKey(), value.toString());
	        } else if (value instanceof Boolean) {
	            requestSpecification.header(entry.getKey(), (Boolean)value);
	        } else {
	            throw new IllegalArgumentException("Unsupported multipart type for key: " + entry.getKey());
	        }
	    }
	    return requestSpecification;
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

	public static String getBaseUrl() {
		return BASE_URL;
	}

}