package com.api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter {

	private static final Logger logger = LogManager.getLogger(LoggingFilter.class);

	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {

		logRequest(requestSpec);
		Response response = ctx.next(requestSpec, responseSpec);// Request is executed here
		logResponse(response);

		return response;// for further assertion
	}

	public void logRequest(FilterableRequestSpecification requestSpec) {

		logger.info("BASE URI:" + requestSpec.getBaseUri());
		logger.info("Request Header:" + requestSpec.getHeaders());
		logger.info("Request Payload:" + requestSpec.getBody());
		logger.info("Request Payload:" + requestSpec.getURI());
	}

	public void logResponse(Response response) {

		logger.info("Status Code:" + response.getStatusCode());
		logger.info("Response Body" + response.getBody().prettyPrint());
		logger.info("Response Header" + response.getBody().prettyPrint());
	}
}
