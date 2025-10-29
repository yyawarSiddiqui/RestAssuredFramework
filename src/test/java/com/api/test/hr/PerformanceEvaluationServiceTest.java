package com.api.test.hr;

import static com.api.constant.Roles.HR;
import static com.api.utils.DateUtility.getCustomDate;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;
import static com.api.utils.ParseToken.Parsetoken;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.api.base.MeetingRoom;
import com.api.base.PerformanceEvaluationService;
import com.api.utils.AuthTokenProvider;
import com.api.utils.JwtDecoder;

import io.restassured.response.Response;

public class PerformanceEvaluationServiceTest {

	private PerformanceEvaluationService evaluationService;
	private JwtDecoder JwtDecoder;
	private String Emp_id;
	private String token;

	@BeforeClass
	public void setup() {

		Emp_id = getEmployeeID(HR);
		token = AuthTokenProvider.getToken(HR);
		evaluationService = new PerformanceEvaluationService();
		JwtDecoder = new JwtDecoder();

	}

	@DataProvider(name = "AllCombinations")
	public Object[][] allCombinations() {
		boolean[] IsSelfiRating = { false, true };
		int[] status = { 1, 2, 3 };

		Object[][] data = new Object[IsSelfiRating.length * status.length][2];
		int index = 0;

		for (boolean b : IsSelfiRating) {
			for (int r : status) {
				data[index][0] = b;
				data[index][1] = r;
				index++;
			}
		}

		return data;
	}

	@Test(dataProvider = "AllCombinations")
	public void GetPendingPerformanceEvaluationData(Boolean IsSelfiRating, int status) {

		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("isselfrating", IsSelfiRating);
		headers.put("status", status);
		headers.put("month", 7);
		headers.put("year", 2025);

		PerformanceEvaluationService evaluationService = new PerformanceEvaluationService();
		Response response = evaluationService.PendingPerformanceEvaluationData(Parsetoken(token), Emp_id, headers);
		response.then().statusCode(200).and().time(Matchers.lessThan(5000L));

		if (!response.getBody().asString().isEmpty()) {

			response.then().body("", Matchers.everyItem(Matchers.hasKey("EmployeeName")));
			response.then().body("", Matchers.everyItem(Matchers.hasKey("EmployeeCode")));
			response.then().body("", Matchers.everyItem(Matchers.hasKey("EmployeeID")));
			response.then().body("", Matchers.everyItem(Matchers.hasKey("Status")));
			response.then().body("", Matchers.everyItem(Matchers.hasKey("StatusValue")));
		}

	}

}
