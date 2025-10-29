package com.api.test.hr;

import static com.api.base.LeaveApplicationService.getBasePath;
import static com.api.constant.Roles.HR;
import static com.api.utils.DateUtility.getCustomDate;
import static com.api.utils.DateUtility.getDateAfterDays;
import static com.api.utils.DateUtility.getTodayDate;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;
import static com.api.utils.ParseToken.Parsetoken;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.api.base.LeaveApplicationService;
import com.api.models.request.LeaveAccreditation;
import com.api.models.request.LeaveApplication;
import com.api.models.response.LeaveManagementResponse;
import com.api.models.response.LeaveManagementResponse.AttendanceSubmission;
import com.api.models.response.LeaveResponse;
import com.api.models.response.LeaveType;
import com.api.utils.AuthTokenProvider;
import com.api.utils.LeaveAccreditationBuilder;

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
		response.then().statusCode(200).and().body("MgrName", Matchers.notNullValue());

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

	@Test
	public void test_GetFinancialYearDetail() {

		Response response = applicationService.get_FinancialYearDetail(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.everyItem(Matchers.hasKey("Description"))).and()
				.body("", Matchers.everyItem(Matchers.hasKey("FINYear"))).and().time(Matchers.lessThan(7000L));

	}

	@Test
	public void test_GetActuarialLeaveDetailsReport() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Locationid", "0");
		map.put("isdownload", false);
		map.put("Employeeids", "");
		map.put("finyear", 2025);

		Response response = applicationService.get_Acturial_LeavesDetai_Report(Parsetoken(token), Emp_id, map);
		response.then().statusCode(200).and().body("", Matchers.everyItem(Matchers.hasKey("EmployeeName"))).and()
				.body("", Matchers.everyItem(Matchers.hasKey("EmployeeCode")))
				.body("", Matchers.everyItem(Matchers.hasKey("CurrentLocation")))
				.body("", Matchers.everyItem(Matchers.hasKey("LastWorkingDate")));

	}

	@Test
	public void test_GetLeaveBalanceB4LeaveGeneration() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isdownload", false);
		map.put("frommonth", "2025-06-01");
		map.put("tomonth", "2025-06-01");

		Response response = applicationService.GetLeaveBalanceB4LeaveGeneration(Parsetoken(token), Emp_id, map);
		response.then().statusCode(200).and().body("", Matchers.everyItem(Matchers.hasKey("ROWID"))).and()
				.body("", Matchers.everyItem(Matchers.hasKey("EmployeeId")))
				.body("", Matchers.everyItem(Matchers.hasKey("EmployeeCode")))
				.body("", Matchers.everyItem(Matchers.hasKey("EmployeeName")))
				.body("", Matchers.everyItem(Matchers.hasKey("ManagerName")))
				.body("", Matchers.everyItem(Matchers.hasKey("DOJ")))
				.body("", Matchers.everyItem(Matchers.hasKey("LeaveBalanceMonth")))
				.body("", Matchers.everyItem(Matchers.hasKey("TotalLeaveTaken")))
				.body("", Matchers.everyItem(Matchers.hasKey("PL_OpeningBal")))
				.body("", Matchers.everyItem(Matchers.hasKey("CO_OpeningBal")))
				.body("", Matchers.everyItem(Matchers.hasKey("PL_Earned")))
				.body("", Matchers.everyItem(Matchers.hasKey("CO_Earned")))
				.body("", Matchers.everyItem(Matchers.hasKey("PL_Consumed")))
				.body("", Matchers.everyItem(Matchers.hasKey("CO_Consumed")))
				.body("", Matchers.everyItem(Matchers.hasKey("LWP")))
				.body("", Matchers.everyItem(Matchers.hasKey("PL_ClosingBal")))
				.body("", Matchers.everyItem(Matchers.hasKey("CO_ClosingBal")))
				.body("", Matchers.everyItem(Matchers.hasKey("Prev_Month_Sandwich")))
				.body("", Matchers.everyItem(Matchers.hasKey("ProRateLeave")))
				.body("", Matchers.everyItem(Matchers.hasKey("AbsDate")))
				.body("", Matchers.everyItem(Matchers.hasKey("HalfDays")))
				.body("", Matchers.everyItem(Matchers.hasKey("HalfDays")));

	}

	@Test
	public void test_GetLeaveDocumentList() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Empid", "0");

		Response response = applicationService.GetLeaveDocumentList(Parsetoken(token), Emp_id, map);
		response.then().statusCode(200);

		LeaveManagementResponse leaveManagementResponses = response.as(LeaveManagementResponse.class);

		Assert.assertNotNull(leaveManagementResponses, "Response should not be null");

		for (AttendanceSubmission data : leaveManagementResponses.getAttendanceSubmission()) {

			assertNotNull(data.getStatus(), "Should have a value yes or no");
		}

	}

	@Test
	public void test_GetLeaveEncashmentReport() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isdownload", 0);
		Response response = applicationService.getLeaveEncashmentReport(Parsetoken(token), Emp_id, map);
		response.then().statusCode(200).and().body("", Matchers.everyItem(Matchers.hasKey("AssociateName"))).body("",
				Matchers.everyItem(Matchers.hasKey("Year")));

	}

	@Test
	public void test_SaveLeavePolicy() {

		LeaveAccreditation requestData = new LeaveAccreditationBuilder().withSupportStaffDisabled(false)
				.withMaternityLeaveValue("30.00").withWorkingHours(1, "170.00").withLeaveAllocationForType(2, "2.00")
				.build();
		Response response = applicationService.SaveLeavePolicy(requestData, Emp_id, Parsetoken(token));
		response.then().statusCode(200).body("message", Matchers.equalTo("Leave Policy updated successfully!"));

	}

	@Test
	public void test_ViewCompOffReport() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("associateid", Emp_id);
		map.put("isdownload", 0);
		map.put("fromdate", getCustomDate(2021, 6, 21));
		map.put("todate", getCustomDate(2024, 6, 30));

		Response response = applicationService.ViewCompOFF_Report(Parsetoken(token), Emp_id, map);
		response.then().statusCode(200).and().body("", Matchers.everyItem(Matchers.hasKey("CO_Earned"))).body("",
				Matchers.everyItem(Matchers.hasKey("CoType")));

	}

	
	@Test
	public void test_ViewPendingLeaves() {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusid", 0);
	
		Response response = applicationService.ViewCompOFF_Report(Parsetoken(token), Emp_id, map);
		response.then().statusCode(200).and().body("", Matchers.everyItem(Matchers.hasKey("LeaveId"))).body("",
				Matchers.everyItem(Matchers.hasKey("LeaveTypeName")));

	}

}
