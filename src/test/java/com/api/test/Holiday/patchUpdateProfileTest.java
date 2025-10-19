//package com.api.test.Holiday;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import com.api.base.AuthService;
//import com.api.base.UserProfileManagementService;
//import com.api.models.request.LoginRequest;
//import com.api.models.request.patchUpdateUserProfiledata;
//import com.api.models.response.LoginResponse;
//import com.api.models.response.patchtUpdateProfiletestResponse;
//
//import io.restassured.response.Response;
//
//public class patchUpdateProfileTest {
//
//	@Test(description = "patch update request")
//	public void updateProfileTest() {
//
//		AuthService authService = new AuthService();
//
//		String token = authService.login(new LoginRequest("yawafrhh", "56756453@E#$")).as(LoginResponse.class)
//				.getToken();
//
//		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
//
//		Response response = userProfileManagementService.patchUpdateProfile(token, new patchUpdateUserProfiledata(
//				"testName", "testname", "dsfs@sfs.sds", "80976546723", "1323 swdsf sfsf"));
//
//		patchtUpdateProfiletestResponse patchtUpdateProfiletestResponse = response
//				.as(patchtUpdateProfiletestResponse.class);
//		Assert.assertEquals(response.statusCode(), 200);
//		Assert.assertEquals(patchtUpdateProfiletestResponse.getAddress(), "1323 swdsf sfsf");
//		
//	}
//
//
//}
