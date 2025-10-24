package com.api.test.hr;

import static com.api.constant.Roles.HR;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;
import static com.api.utils.ParseToken.Parsetoken;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.api.base.LeaveApplicationService;
import com.api.models.request.LeaveApplication;
import com.api.models.response.LeaveResponse;
import com.api.models.response.LeaveType;

import static com.api.base.LeaveApplicationService.*;
import com.api.utils.AuthTokenProvider;
import static com.api.utils.DateUtility.*;

import io.restassured.response.Response;

public class LeaveApplicationServiceTest {

	private LeaveApplicationService applicationService;
	private String Emp_id;
	private String token;

	@DataProvider(name = "Leave Types")
	public Object[][] Leaveids() {

		return new Object[][] {

				{ "CL" }, { "HD" }, { "MDL" }, { "WL" } };
	}

	@BeforeMethod
	public void setup() {

		Emp_id = getEmployeeID(HR);
		token = AuthTokenProvider.getToken(HR);
		applicationService = new LeaveApplicationService();

	}

	@Test
	public void test_getEmpMgrDetails() {

		Response response = applicationService.getEmpMgrDetails(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("attMonth", Matchers.greaterThanOrEqualTo(0));

		response.then().time(Matchers.lessThan(10000L)).and().body("", Matchers.notNullValue());

	}

	@Test
	public void test_getLeaveDetails() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("empId", Emp_id);
		Response response = applicationService
				.getRequestwithParams(getBasePath() + Emp_id + "/GetLeaveApplicationDetails", map, Parsetoken(token));
		response.then().statusCode(200);

		LeaveResponse leaveResponse = response.as(LeaveResponse.class);

		assertEquals(leaveResponse.getLeaveDetails().get(0).getEmployeeId(), Integer.parseInt(Emp_id));

	}

	@Test
	public void test_Bind_Leave_Type() {

		Response response = applicationService.getLeaveType(Parsetoken(token), Emp_id);
		response.then().statusCode(200);
		LeaveType[] leavetype = response.as(LeaveType[].class);
		assertTrue(leavetype.length > 0, "");

		for (LeaveType leavedata : leavetype) {

			assertNotNull(leavedata.getId(), "Leave ID should not be null");
			assertFalse(leavedata.getId().isBlank(), "Leave ID should not be blank");

		}
	}

	@Test(dataProvider = "Leave Types")
	public void test_ShowLeaveMessage(String LeaveTypes) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Leaveid", 0);
		map.put("Fromdate", getTodayDate());
		map.put("Todate", getDateAfterDays(5));
		map.put("Selectedleavetype", LeaveTypes);
		Response response = applicationService.getLeaveMsg(Parsetoken(token), Emp_id, map);
		response.then().statusCode(200);

		Map<String, Object> respMap = response.as(Map.class);
		assertTrue(respMap.containsKey("leaveMessage"), "Response should contain 'leaveMessage' key");

		assertNotNull(respMap.get("leaveMessage"), "'leaveMessage' should not be null");
		assertFalse(respMap.get("leaveMessage").toString().isBlank(), "'leaveMessage' should not be blank");

		assertTrue(respMap.containsKey("noOfDays"), "Response should contain 'noOfDays' key");
		assertTrue(respMap.containsKey("uploadRequired"), "Response should contain 'uploadRequired' key");

	}

	@Test
	public void test_Update_Leave_Application() {

		LeaveApplication application = LeaveApplication.builder().leaveId(0).employeeId(4775)
				.fromDate("2025-10-28T00:00:00.000Z").toDate("2025-10-29T00:00:00.000Z").reason("sds").leaveStatus("0")
				.actionBy("Akansha Sharma").leaveType("CL").leaveDocument(null).leaveStatusID("0").leaveTypeName("")
				.reportingManager("Amit Kumar").employeeName(null).fileName("").hrApprovalStatusID("0")
				.hrApprovalStatus("").build();
		;

		Response response = applicationService.AddUpdateLeaveApplication(application, Emp_id, Parsetoken(token));
		response.then().statusCode(200);

	}

	@Test
	public void test_get_LeaveAdjustmentCategory() {

		Response response = applicationService.getLeaveAdjustmentCategory(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.everyItem(Matchers.hasKey("id"))).and()
				.body("", Matchers.everyItem(Matchers.hasKey("name"))).and()
				.body("", Matchers.everyItem(Matchers.notNullValue()));

	}

	@Test
	public void test_get_LeaveAdjustmentType() {

		Response response = applicationService.getLeaveAdjustmentType(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.everyItem(Matchers.hasKey("id"))).and()
				.body("", Matchers.everyItem(Matchers.hasKey("name"))).and()
				.body("", Matchers.everyItem(Matchers.notNullValue()));

	}

	@Test
	public void test_get_AttendanceMonth() {

		Response response = applicationService.getAttandanceMonth(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasKey("attMonth")).and()
				.body("", Matchers.hasKey("attYear")).and().body("", Matchers.hasKey("isReportGenerated"));

	}

	@Test
	public void test_getLeaveAdjustmentReport() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isdownload", 0);
		// map.put("Adjustmentcategory", "");
		// map.put("Adjustmenttype", "");
		// map.put("Empid", "");
		// map.put("Mgrid", "");
		map.put("Frommonth", "2025-06-01");
		map.put("Tomonth", "2025-06-01");

		Response response = applicationService.getLeaveAdjustmentReport(Parsetoken(token), Emp_id, map);
		response.then().statusCode(200).and().body("", Matchers.everyItem(Matchers.hasKey("EmployeeName"))).and()
				.body("", Matchers.everyItem(Matchers.hasKey("ManagerName"))).and()
				.body("", Matchers.everyItem(Matchers.hasKey("AdjustmentType")));

	}

	@Test
	public void test_GetLeaveStatus() {

		Response response = applicationService.get_LeaveStatus(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.everyItem(Matchers.hasKey("statusId"))).and()
				.body("", Matchers.everyItem(Matchers.hasKey("statusDescription"))).and()
				.body("statusId", Matchers.everyItem(Matchers.greaterThanOrEqualTo(0)))
				.body("statusDescription", Matchers.hasItems("Pending", "Approved", "Rejected", "Cancelled",
						"No-Action", "Partially Approved"));

	}
	
	@Test
	public void test_GetLeaveApprovaData() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusid", 0);
		Response response = applicationService.get_LeaveApprovalData(Parsetoken(token), Emp_id, map);
		response.then().statusCode(200);

	}

}
