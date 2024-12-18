package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest {

	@Test(description = "Verify if login page is working", groups = { "Smoke" })
	public void loginTest() {

		

		RequestSpecification SpecificationofRequest = given().baseUri("http://64.227.160.186:8080/");

		RequestSpecification SpecificationofRequest2 = SpecificationofRequest.header("Content-Type",
				"application/json");

		RequestSpecification SpecificationofRequest3 = SpecificationofRequest2
				.body("{\r\n" + "  \"username\": \"uday1234\",\r\n" + "  \"password\": \"uday1234\"\r\n" + "}");

		Response response = SpecificationofRequest3.post("api/auth/login");

		Assert.assertEquals(response.getStatusCode(), 200);

		System.out.println(response.asPrettyString());

	}
}
