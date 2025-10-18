package com.api.test.Rm;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.lessThan;

import org.hamcrest.Matchers;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListeners.class)
public class LoginAPITestispoc {

	@Test(description = "Verify if login page is working", groups = { "Smoke" })
	public void loginTestasAccount() {

		LoginRequest loginRequest = new LoginRequest("INEMP000327", "ibs#2020");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		// System.out.println(System.getProperty("env"));

		LoginResponse loginResponse = response.as(LoginResponse.class);// it returns you new LoginResponse();
		response.then().body(matchesJsonSchemaInClasspath("responseSchema/loginAPIResponseSchema.json")).and()
				.time(lessThan(9000L)).and().body("employeeName", Matchers.equalTo("Satish Kumar"));

	}

	@Test(description = "Verify if login page is working", groups = { "Smoke" })
	public void loginTestasHR() {

		LoginRequest loginRequest = new LoginRequest("INEMP000775", "ibs#2020");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		response.as(LoginResponse.class);// it returns you new LoginResponse();
		response.then().body(matchesJsonSchemaInClasspath("responseSchema/loginAPIResponseSchema.json")).and()
				.time(lessThan(9000L)).and().body("employeeName", Matchers.equalTo("Akansha Sharma"));

	}
	
	@Test(description = "Verify if login page is working", groups = { "Smoke" })
	public void loginTestasAdmin() {

		LoginRequest loginRequest = new LoginRequest("INEMP000410", "ibs#2020");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		response.as(LoginResponse.class);// it returns you new LoginResponse();
		response.then().body(matchesJsonSchemaInClasspath("responseSchema/loginAPIResponseSchema.json")).and()
				.time(lessThan(9000L)).and().body("employeeName", Matchers.equalTo("Abhishek Jaiswal"));

	}

	@Test(description = "Verify if login page is working", groups = { "Smoke" })
	public void loginTestasAssociate() {

		LoginRequest loginRequest = new LoginRequest("INEMP000667", "ibs#2020");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		response.as(LoginResponse.class);// it returns you new LoginResponse();
		response.then().body(matchesJsonSchemaInClasspath("responseSchema/loginAPIResponseSchema.json")).and()
				.time(lessThan(9000L)).and().body("employeeName", Matchers.equalTo("Mohd Yawar Siddique"));

	}
	
	@Test(description = "Verify if login page is working", groups = { "Smoke" })
	public void loginTestasIT() {

		LoginRequest loginRequest = new LoginRequest("INEMP000228", "ibs#2020");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		response.as(LoginResponse.class);// it returns you new LoginResponse();
		response.then().body(matchesJsonSchemaInClasspath("responseSchema/loginAPIResponseSchema.json")).and()
				.time(lessThan(9000L)).and().body("employeeName", Matchers.equalTo("Neeraj Kumar Dixit"));

	}

}
