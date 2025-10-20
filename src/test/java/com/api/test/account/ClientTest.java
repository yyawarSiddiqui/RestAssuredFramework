package com.api.test.account;

import static com.api.constant.Roles.*;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;
import static com.api.utils.ParseToken.Parsetoken;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.base.ClientService;
import com.api.utils.AuthTokenProvider;

import io.restassured.response.Response;

public class ClientTest {

	@Test
	public void getClient() {

		String Emp_id = getEmployeeID(ACCOUNT);
		String token = AuthTokenProvider.getToken(ACCOUNT);
		ClientService clientService = new ClientService();
		Response response = clientService.getClient(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("name", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("id", Matchers.everyItem(Matchers.notNullValue()));

		// List<GetExperience> list = response.jsonPath().getList("",
		// GetExperience.class);

	}
	
}
