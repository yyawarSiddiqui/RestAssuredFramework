package com.api.base;

import java.util.Map;

import com.api.models.request.patchUpdateUserProfiledata;
import com.api.models.response.JwtDecodedResponse;

import io.restassured.response.Response;

public class CommonService extends BaseService {

	JwtDecodedResponse decodedResponse = new JwtDecodedResponse();
	private static final String BASE_PATH = "api/common/";
	public static final String ENDPOINT_RRF_GET_ROLEWISE_TITLE = "/GetRolewiseEmployees";
	public static final String ENDPOINT_GetAllReportingMgr = "/GetAllReportingMgr";
	public static final String ENDPOINT_GetROLE_BASEDUSER_MENU = "/GetAllReportingMgr";
	public static final String ENDPOINT_GetAllEMPLOYEE = "/GetAllEmployees";
	public static final String ENDPOINT_GetRoleBasedUserMenu = "/GetRoleBasedUserMenu";

	public CommonService() {

	}

	public Response getRequestwithParams(String endpoint, Map<String, Object> queryParams, String token) {

		setAuthtoken(token);
		return super.getRequestwithParams(endpoint, queryParams, token);
	}

//	public Response modifyProfile(String token, UpdateUserProfileData updateUserProfileData) {
//		setAuthtoken(token);
//
//		return putRequest(updateUserProfileData, BASE_PATH + "/profile");
//
//	}

	public Response getRoleBasedUserMenu(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetRoleBasedUserMenu");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetRoleBasedUserMenu");

	}

	public Response getExperience(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetExperience");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetExperience");

	}

	public Response getTechnonlogy(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetTechnology");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetTechnology");

	}

	public Response getAssociateType(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetAssociateType");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetAssociateType");

	}

	public Response GetGender(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetGender");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetGender");

	}

	public Response GetMartialStatus(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetMaritalStatus");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetMaritalStatus");

	}

	public Response GetEducation(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetEducation");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetEducation");

	}

	public Response GetProfitCentre(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/ProfitCenterMappingList");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/ProfitCenterMappingList");

	}

	public Response GetTimesheet(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetTimeSheet");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetTimeSheet");

	}

	public Response GetBioMetricCardNumber(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetBioMetricCardNo");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetBioMetricCardNo");

	}

	public Response GetStandardWeekDays(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetStandardWeekDays");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetStandardWeekDays");

	}

	public Response GetStates(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetStates");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetStates");

	}

	public Response GetDegreeLevel(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetDegreeLevel");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetDegreeLevel");

	}

	public Response GetRelationship(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetRelationship");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetRelationship");

	}

	public Response GetTypesOfAccount(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetTypesOfAccount");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetTypesOfAccount");

	}

	public Response GetYears(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetYears");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetYears");

	}

	public Response GetIdentityName(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetIdentityName");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetIdentityName");

	}

	public Response ISFlexibleWeekoffAllowBYdept(String token, String EmployeeID, Map<String, Object> headers) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/ISFlexibleWeekoffAllow");
		}

		setHeaders(headers);
		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/ISFlexibleWeekoffAllow");

	}

	public Response getTypeofAccount(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetTypesOfAccount");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetTypesOfAccount");

	}
	
	public Response getIdentityName(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetIdentityName");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetIdentityName");

	}
	
	public Response getTimeZone(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/TimeZoneDD");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/TimeZoneDD");

	}
	
	public Response getDays(String token, String EmployeeID) {

		if (token == null || token.isEmpty()) {

			return getRequestWithoutAuth(BASE_PATH + EmployeeID + "/GetDays");
		}

		setAuthtoken(token);
		return getRequest(BASE_PATH + EmployeeID + "/GetDays");

	}
	
	public Response UploadImage(Map<String,Object> obj,String EmployeeId,String token) {

		setAuthtoken(token);
		setMultipart(obj);
		return postRequestforMultiPart(BASE_PATH + EmployeeId+"/UploadFile");
	}
	
	public Response Uploadfiles(String EmployeeId,String token) {

		setAuthtoken(token);
		//setMultipart(obj);
		return postRequest(BASE_PATH + EmployeeId+"/UploadFiles");
	}
	
	public Response getRequestofPlainText(String token, String EmployeeId, String Endpoint) {

		setAuthtoken(token);
		return super.getRequestofPlainText(BASE_PATH + EmployeeId + Endpoint);
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
