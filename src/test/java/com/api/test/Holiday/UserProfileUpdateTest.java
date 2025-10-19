//package com.api.test.Holiday;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import com.api.base.AuthService;
//import com.api.base.UserProfileManagementService;
//import com.api.models.request.LoginRequest;
//import com.api.models.request.UpdateUserProfileData;
//import com.api.models.response.LoginResponse;
//import com.api.models.response.UserProfileUpdateTestResponse;
//
//import io.restassured.response.Response;
//
//public class UserProfileUpdateTest {
//
//	@Test(description = "Update Profile Update Test")
//
//	public void userProfileUpdattionTest() {
//
//		AuthService authService = new AuthService();
//		Response response = authService.login(new LoginRequest("yawafrhh", "56756453@E#$"));
//
//		LoginResponse loginResponse = response.as(LoginResponse.class);
//		String token = loginResponse.getToken();
//		UserProfileManagementService managementService = new UserProfileManagementService();
//
//		UpdateUserProfileData updateUserProfileData = new UpdateUserProfileData("yawafrhh", "56756453@E#$",
//				"yawarsdq@gmail.com", "8279937319");
//
//		Response response3 = managementService.modifyProfile(token, updateUserProfileData);
//		UserProfileUpdateTestResponse userProfileUpdateTestResponse = response3.as(UserProfileUpdateTestResponse.class);
//		response3.then().statusCode(200);
//		
//		Assert.assertEquals(userProfileUpdateTestResponse.getStatus(), 200);
//
//	}
//
//}
