package com.api.base;

import java.util.Map;

import com.api.models.request.patchUpdateUserProfiledata;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LeaveApplicationService extends BaseService {

	private static final String BASE_PATH = "api/LeaveApplication/";
	private static final String Endpoint_GetLeaveApplicationDetails = "";

	public Response getRequestwithParams(String endpoint, Map<String, Object> queryParams, String token) {

		setAuthtoken(token);
		return super.getRequestwithParams(endpoint, queryParams, token);
	}

	public Response AddUpdateLeaveApplication(Object payload, String EmployeeId, String token) {

		setAuthtoken(token);
		return postRequest(payload, BASE_PATH + EmployeeId + "/AddUpdateLeaveApplication");
	}

//	public Response modifyProfile(String token, UpdateUserProfileData updateUserProfileData) {
//		setAuthtoken(token);
//
//		return putRequest(updateUserProfileData, BASE_PATH + "/profile");
//
//	}

	public Response getEmpMgrDetails(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/EmpMgrDetails");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/EmpMgrDetails");

	}

	public Response getLeaveType(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/BindLeaveType");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/BindLeaveType");

	}

	public Response getLeaveAdjustmentCategory(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/LeaveAdjustmentCategory");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/LeaveAdjustmentCategory");

	}

	public Response getLeaveMsg(String token, String EmployeeID, Map<String, Object> headers) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/ShowLeaveMessage");
		}

		setHeaderswithinstanceWithHeader(headers);
		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/ShowLeaveMessage");

	}

	public Response getLeaveAdjustmentReport(String token, String EmployeeID, Map<String, Object> headers) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/LeaveAdjustmentReport");
		}

		setHeaderswithinstanceWithHeader(headers);
		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/LeaveAdjustmentReport");

	}

	public Response getLeaveAdjustmentType(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/LeaveAdjustmentType");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/LeaveAdjustmentType");

	}

	public Response getAttandanceMonth(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/AttendanceMonth");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/AttendanceMonth");

	}

	public Response get_LeaveAdjustmentReport(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/LeaveAdjustmentReport");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/LeaveAdjustmentReport");

	}

	public Response get_LeaveStatus(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetLeaveStatus");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetLeaveStatus");

	}

	public Response get_LeaveApprovalData(String token, String EmployeeID, Map<String, Object> headers) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/LeaveApprovalData");
		}

		setAuthtoken(token);
		setHeaders(headers);
		return getRequest(BASE_PATH + EmployeeID + "/LeaveApprovalData");

	}

	public Response get_FinancialYearDetail(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetFinancialYearDetail");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetFinancialYearDetail");

	}

	public Response get_Acturial_LeavesDetai_Report(String token, String EmployeeID, Map<String, Object> headers) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetActuarialLeaveDetailsReport");
		}

		setAuthtoken(token);
		setHeaders(headers);
		return getRequest(BASE_PATH + EmployeeID + "/GetActuarialLeaveDetailsReport");

	}

	public Response GetLeaveBalanceB4LeaveGeneration(String token, String EmployeeID, Map<String, Object> headers) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetLeaveBalanceB4LeaveGeneration");
		}

		setAuthtoken(token);
		setHeaders(headers);
		return getRequest(BASE_PATH + EmployeeID + "/GetLeaveBalanceB4LeaveGeneration");

	}

	public Response GetLeaveDocumentList(String token, String EmployeeID, Map<String, Object> headers) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetLeaveDocumentList");
		}

		setAuthtoken(token);
		setHeaders(headers);
		return getRequest(BASE_PATH + EmployeeID + "/GetLeaveDocumentList");

	}

	public Response GetLeaveEncashmentYearDD(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/LeaveEncashmentYearDD");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/LeaveEncashmentYearDD");

	}

	public Response getLeaveEncashmentReport(String token, String EmployeeID, Map<String, Object> headers) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/LeaveEncashmentReport/ADM");
		}

		setAuthtoken(token);
		setHeaders(headers);
		return getRequest(BASE_PATH + EmployeeID + "/LeaveEncashmentReport/ADM");

	}

	public Response SaveLeavePolicy(Object payload, String EmployeeId, String token) {

		setAuthtoken(token);
		return postRequest(payload, BASE_PATH + EmployeeId + "/SaveLeavePolicy");
	}

	public Response ViewCompOFF_Report(String token, String EmployeeID, Map<String, Object> headers) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/ViewPendingLeaves");
		}

		setAuthtoken(token);
		setHeaders(headers);
		return getRequest(BASE_PATH + EmployeeID + "/ViewPendingLeaves");

	}
	

	public Response get_ViewPendingLeaves(String token, String EmployeeID, Map<String, Object> headers) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/ViewPendingLeaves");
		}

		setAuthtoken(token);
		setHeaders(headers);
		return getRequest(BASE_PATH + EmployeeID + "/ViewPendingLeaves");

	}

	public Response deleteProfile(String token) {
		setAuthtoken(token);

		return deleteRequest(BASE_PATH + "/profile", "confirmationCode", "dfdfdg");

	}

	public Response patchUpdateProfile(String token, patchUpdateUserProfiledata patchUpdateUserProfiledata) {
		setAuthtoken(token);

		return patchRequest(patchUpdateUserProfiledata, BASE_PATH + "/profile");

	}

	public static String getBasePath() {
		return BASE_PATH;
	}
}
