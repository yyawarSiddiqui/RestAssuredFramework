package com.api.test.IT;

import static com.api.constant.Roles.IT;
import static com.api.utils.DateUtility.getDateAfterDays;
import static com.api.utils.DateUtility.getdatebyInput;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;
import static com.api.utils.ParseToken.Parsetoken;
import static com.api.utils.generateRandomString.generateRandomStringvalue;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.api.base.ManageDocument;
import com.api.models.request.TrainingDocument;
import com.api.utils.AuthTokenProvider;
import com.api.utils.JwtDecoder;

import io.restassured.response.Response;

public class ManageDocumentTest {

	private ManageDocument manageDocument;
	private JwtDecoder JwtDecoder;
	private String Emp_id;
	private String token;

	@BeforeClass
	public void setup() {

		Emp_id = getEmployeeID(IT);
		token = AuthTokenProvider.getToken(IT);
		manageDocument = new ManageDocument();
		JwtDecoder = new JwtDecoder();

	}

	@DataProvider(name = "AllCombinationsWithStatus")
	public Object[][] allCombinationsWithStatus() {
		int[] locationIds = { 1, 4, 5, 6, 7, 8 };
		int[] targetAudienceIds = { 1, 2, 3, 4 };
		String[] statusNames = { "Approved", "Pending" };

		Object[][] data = new Object[locationIds.length * targetAudienceIds.length * statusNames.length][3];
		int index = 0;

		for (int loc : locationIds) {
			for (int ta : targetAudienceIds) {
				for (String status : statusNames) {
					data[index][0] = loc;
					data[index][1] = ta;
					data[index][2] = status;
					index++;
				}
			}
		}

		return data;
	}

	@DataProvider(name = "AllCombinationsWithStatusTrainingReport")
	public Object[][] allCombinationsWithStatusTrainingReport() {
		int[] locationIds = { 1, 4, 5, 6, 7, 8 };
		int[] targetAudienceIds = { 1, 2, 3, 4 };
		String[] statusNames = { "Approved", "Pending", "Completed", "Pending For Approval" };
		int[] deptIDs = { 5, 3, 1020, 1026, 1021, 2, 1016, 4, 1031, 1029, 1014, 1022, 1027, 14, 1015, 6, 1025, 1023,
				1024 };

		Object[][] data = new Object[locationIds.length * targetAudienceIds.length * statusNames.length
				* deptIDs.length][4];
		int index = 0;

		for (int loc : locationIds) {
			for (int ta : targetAudienceIds) {
				for (String status : statusNames) {
					for (int deptID : deptIDs) {

						data[index][0] = loc;
						data[index][1] = ta;
						data[index][2] = status;
						data[index][3] = deptID;
						index++;
					}

				}
			}
		}

		return data;
	}

	@DataProvider(name = "allCombinationstoAddUpdateTraining")
	public Object[][] allCombinationstoAddUpdateTraining() {
		int[] locationIds = { 1, 4, 5, 6, 7, 8 };
		int[] targetAudienceIds = { 1, 2, 3, 4 };
		int[] deptIDs = { 5, 3, 1020, 1026, 1021, 2, 1016, 4, 1031, 1029, 1014, 1022, 1027, 14, 1015, 6, 1025, 1023,
				1024 };

		Object[][] data = new Object[locationIds.length * targetAudienceIds.length * deptIDs.length][3];
		int index = 0;

		for (int loc : locationIds) {
			for (int ta : targetAudienceIds) {
				for (int departmentIDs : deptIDs) {
					data[index][0] = String.valueOf(loc);
					data[index][1] = String.valueOf(ta);
					data[index][2] = departmentIDs;
					index++;
				}
			}
		}

		return data;
	}

	@Test(dataProvider = "AllCombinationsWithStatus")
	public void test_MyMeetingRoomList(int locationIds, int targetAudienceIds, String statusNames) {

		Map<String, Object> map = new HashMap<String, Object>();
		// int documentid = 0;

		map.put("IsDownload", false);
		map.put("LocationIDs", locationIds);
		map.put("StatusIDs", statusNames);
		map.put("TargetAudienceIDs", targetAudienceIds);
		map.put("FromDate", getdatebyInput(2025, 10, 30));
		map.put("ToDate", getDateAfterDays(180));

		ManageDocument manageDocument = new ManageDocument();
		Response response = manageDocument.getGetAssessmentTrainingListMGR(Parsetoken(token), Emp_id, map);

//		TrainingResponsePOJO[] trResponse = response.as(TrainingResponsePOJO[].class);
//
//		for (TrainingResponsePOJO trainingResponse : trResponse) {
//			if (documentid != 0) {
//				documentid = trainingResponse.getDocumentID();
//				
//			}
//			break;
//
//		}

		response.then().statusCode(200).and().body("documentID", Matchers.everyItem(Matchers.notNullValue()))
				.body("departmentID", Matchers.everyItem(Matchers.notNullValue()))
				.body("department", Matchers.everyItem(Matchers.notNullValue()))
				.body("trainingName", Matchers.everyItem(Matchers.notNullValue()))
				.body("trainingStatus", Matchers.everyItem(Matchers.notNullValue()))
				.body("targetAudience", Matchers.everyItem(Matchers.notNullValue()))
				.body("locationIDs", Matchers.everyItem(Matchers.notNullValue()))
				.body("location", Matchers.everyItem(Matchers.notNullValue()));
	}

	@Test
	public void test_getAssesmentQuestion() {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("documentid", 0);

		Response response = manageDocument.getGetAssessmentQuestions(Parsetoken(token), Emp_id, map);

		response.then().statusCode(200);
	}

	@Test(dataProvider = "allCombinationstoAddUpdateTraining")
	public void test_AddUpdateTraining(String locationIds, String targetAudienceIds, int deptIDs) {
		TrainingDocument document = new TrainingDocument(0, // documentID
				deptIDs, // departmentID
				generateRandomStringvalue(11), // trainingName
				targetAudienceIds, // targetAudienceIDs
				locationIds, // locationIDs
				"2025-11-01T17:48:43.990Z", // trainingLaunchDate
				null, // trainingClosureDate
				"2026-04-11T00:00:00.000Z", // trainingDeadline
				15, // popupRecurrenceDays
				true, // isMandatoryForNewJoiners
				true, // isMandatoryForExtendedLeave
				"MANAGE_DOCUMENT" // actionFrom
		);

		ManageDocument manageDocument = new ManageDocument();
		Response response = manageDocument.AddUpdateTraining(document, Emp_id, Parsetoken(token));

		response.then().statusCode(200).body("success", (Matchers.notNullValue()))
				.body("statusCode", (Matchers.notNullValue())).body("message", (Matchers.notNullValue()))
				.body("data", (Matchers.notNullValue()))
				.body("message", (Matchers.containsStringIgnoringCase("Training saved successfully.")))
				.body("success", (Matchers.equalTo(true)));
	}

	@Test(dataProvider = "AllCombinationsWithStatusTrainingReport")// NEED TO RETEST
	public void test_GetTrainingStatus(int locationIds, int targetAudienceIds, String statusNames, int deptIDs) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isDownload", 0);
		map.put("locationId", locationIds);
		map.put("trainingStatus", statusNames);
		map.put("targetAudienceId", targetAudienceIds);
		map.put("departmentId", deptIDs);
		map.put("startDate", getdatebyInput(2025, 10, 30));
		map.put("endDate", getDateAfterDays(180));

		ManageDocument manageDocument = new ManageDocument();
		Response response = manageDocument.getTrainingStatusReportMGR(Parsetoken(token), Emp_id, map);
		if (response != null) {

			response.then().statusCode(200).and().body("S.No.", Matchers.everyItem(Matchers.notNullValue()))
					.body("TrainingTopic", Matchers.everyItem(Matchers.notNullValue()))
					.body("DateOfCreation", Matchers.everyItem(Matchers.notNullValue()))
					.body("TrainingLaunchDate", Matchers.everyItem(Matchers.notNullValue()))
					.body("Department", Matchers.everyItem(Matchers.notNullValue()))
					.body("TargetAudience", Matchers.everyItem(Matchers.notNullValue()))
					.body("Locations", Matchers.everyItem(Matchers.notNullValue()))
					.body("TotalTargetedAudience", Matchers.everyItem(Matchers.notNullValue()))
					.body("CompletedCount", Matchers.everyItem(Matchers.notNullValue()))
					.body("PendingCount", Matchers.everyItem(Matchers.notNullValue()))
					.body("TrainingStatus", Matchers.everyItem(Matchers.notNullValue()));
		}

	}

}
