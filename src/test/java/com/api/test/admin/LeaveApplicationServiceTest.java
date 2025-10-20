package com.api.test.admin;
import static com.api.constant.Roles.ADMIN;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;
import static com.api.utils.ParseToken.Parsetoken;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import com.api.base.LeaveApplicationService;
import com.api.utils.AuthTokenProvider;
import io.restassured.response.Response;

public class LeaveApplicationServiceTest {

	@Test
	public void test_getAttendanceMonth() {

		String Emp_id = getEmployeeID(ADMIN);
		String token = AuthTokenProvider.getToken(ADMIN);
		LeaveApplicationService leaveApplicationService = new LeaveApplicationService();
		Response response = leaveApplicationService.getAttendanceMonth(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("attMonth", Matchers.greaterThanOrEqualTo(0));

		response.then().time(Matchers.lessThan(10000L)).and().body("attMonth", Matchers.notNullValue()).and()
				.body("attYear", Matchers.notNullValue());

	}
}
