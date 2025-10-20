package com.api.test.IT;

import static com.api.constant.Roles.IT;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.base.AssociateMasterReportService;
import com.api.utils.AuthTokenProvider;
import static com.api.utils.ParseToken.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;

public class AssociateMasterReportTest {

	@Test
	public void getAssociateMasterColumntoViewTest() {

		Map<String, Object> values=new HashMap<String,Object>();
		values.put("userType", "ADM");

		String Emp_id = getEmployeeID(IT);
		String token = AuthTokenProvider.getToken(IT);
		AssociateMasterReportService associateMasterReportService = new AssociateMasterReportService();
		Response response = associateMasterReportService.getAssociateMasterColumntoView(Parsetoken(token), Emp_id,values);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("id", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("name", Matchers.everyItem(Matchers.notNullValue()))
				.body("", Matchers.hasSize(Matchers.greaterThanOrEqualTo(10)));

	}

}
