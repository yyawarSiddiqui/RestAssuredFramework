package com.api.test.hr;

import static com.api.constant.Roles.HR;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.api.base.MeetingRoom;
import com.api.models.request.MeetingBookingRequest;
import com.api.utils.AuthTokenProvider;
import com.api.utils.JwtDecoder;

import static com.api.utils.ParseToken.*;

import static com.api.utils.DateUtility.*;

import io.restassured.response.Response;

public class MeetingRoomTest {

	private MeetingRoom meetingRoom;
	private JwtDecoder JwtDecoder;
	private String Emp_id;
	private String token;

	@BeforeClass
	public void setup() {

		Emp_id = getEmployeeID(HR);
		token = AuthTokenProvider.getToken(HR);
		meetingRoom = new MeetingRoom();
		JwtDecoder = new JwtDecoder();

	}

	@DataProvider(name = "BuilidingIDs")
	public Object[][] BuildingFloorids() {

		return new Object[][] {

				{ 8 }, { 9 }, { 10 }, { 11 }, { 12 }, { 13 }, { 14 }

		};
	}

	@DataProvider(name = "ResourceIds")
	public Object[][] ResourceIds() {

		return new Object[][] {

				{ 1 }, { 2 }, { 3 }, { 4 }, { 5 }, { 6 }, { 7 }, { 8 }, { 9 }, { 10 }, { 11 }, { 12 }, { 13 }, { 14 },
				{ 15 }, { 16 }, { 17 }, { 18 }, { 19 }

		};
	}

	@DataProvider(name = "AllCombinations")
	public Object[][] allCombinations() {
		int[] buildingIds = { 8, 9, 10, 11, 12, 13, 14 };
		int[] resourceIds = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };

		Object[][] data = new Object[buildingIds.length * resourceIds.length][2];
		int index = 0;

		for (int b : buildingIds) {
			for (int r : resourceIds) {
				data[index][0] = b;
				data[index][1] = r;
				index++;
			}
		}

		return data;
	}

	@Test(dataProvider = "AllCombinations")
	public void test_CheckRoomAvailability(int buildingid, int ResourceIds) {

		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("buildingid", buildingid);
		headers.put("resourcesid", ResourceIds);
		headers.put("fromdate", getCustomDate(2025, 11, 5));
		headers.put("todate", getCustomDate(2025, 11, 5));
		headers.put("fromtime", 10.00);
		headers.put("totime", 10.30);

		MeetingRoom meetingRoom = new MeetingRoom();
		Response response = meetingRoom.checkRoomAvailability(Parsetoken(token), Emp_id, headers);

		response.then().statusCode(200).and().body("meetingRoomId", Matchers.everyItem(Matchers.notNullValue()))
				.body("buildingId", Matchers.everyItem(Matchers.notNullValue()));

	}

	@Test
	public void test_AddMeetingRoomBookingDetails() {

		MeetingBookingRequest bookingRequest = new MeetingBookingRequest("dwsewwe", // meetingTitle
				"wdwdd", // projectName
				"A", // mode
				"3", // attendees
				0, // bookingDetailId
				9, // buildingId
				"", // resourceId
				9, // meetingRoomId
				"10.00", // fromTime
				"10.30", // toTime
				"2025-10-31", // fromDate
				"2025-10-31", // toDate
				1, // bookingStatus
				1, // booked
				"", // weekdays
				"2E51ABB1-7844-4B6E-A6DB-C21A33C6705D" // createdBy
		);

		Response response = meetingRoom.AddMeetingRoomBookingDetails(bookingRequest, Emp_id, Parsetoken(token));

		response.then().statusCode(200).and().body("message", Matchers.notNullValue()).body("success",
				Matchers.notNullValue());

	}

	@Test
	public void test_MyMeetingRoomList() {

		MeetingRoom meetingRoom = new MeetingRoom();
		Response response = meetingRoom.MyMeetingRoomList(Parsetoken(token), Emp_id);

		response.then().statusCode(200).and().body("meetingRoomIdentity", Matchers.everyItem(Matchers.notNullValue()))
				.body("dateRange", Matchers.everyItem(Matchers.notNullValue()))
				.body("timeRange", Matchers.everyItem(Matchers.notNullValue()))
				.body("meetingTitle", Matchers.everyItem(Matchers.notNullValue()))
				.body("projectName", Matchers.everyItem(Matchers.notNullValue()))
				.body("attendees", Matchers.everyItem(Matchers.notNullValue()))
				.body("bookingStatus", Matchers.everyItem(Matchers.notNullValue()))
				.body("bookedBy", Matchers.everyItem(Matchers.notNullValue()));

	}

}
