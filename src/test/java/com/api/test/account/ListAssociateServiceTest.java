package com.api.test.account;

import static com.api.base.ListAssociateService.get_Employee_Basicdetail_EndPoint;
import static com.api.constant.Roles.HR;
import static com.api.utils.GetEmpolyeeID.getEmployeeID;
import static com.api.utils.ParseToken.Parsetoken;
import static com.api.utils.getEmployeeDetailID.GetEmployeedetailID;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.api.base.ListAssociateService;
import com.api.models.request.AssociateProfileUpdateData;
import com.api.utils.AuthTokenProvider;

import io.restassured.response.Response;

public class ListAssociateServiceTest {

	private String Emp_id;
	private String token;
	private String employeedetailID;
	private ListAssociateService listAssociate;

	@DataProvider(name = "associateTypeIds")
	public Object[][] associateTypeIds() {
		return new Object[][] { { 1 }, { 2 }, { 3 }, { 4 } };
	}

	@DataProvider(name = "CommitmentandAssociateTypeids")
	public Object[][] CommitmentTypeIds() {
		return new Object[][] { { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 } };

	}

	@DataProvider(name = "Months")
	public Object[][] months() {

		return new Object[][] {

				{ 1 }, { 2 }, { 3 }, { 4 }, { 5 }, { 6 }, { 7 }, { 8 }, { 9 }, { 10 }, { 11 }, { 12 } };
	}

	@BeforeClass
	public void setup() {

		Emp_id = getEmployeeID(HR);
		token = AuthTokenProvider.getToken(HR);
		listAssociate = new ListAssociateService();
		employeedetailID = GetEmployeedetailID(HR);
	}

	@Test
	public void test_getListofAssociate() {

		String Emp_id = getEmployeeID(HR);
		String token = AuthTokenProvider.getToken(HR);
		ListAssociateService listAssociateService = new ListAssociateService();
		Response response = listAssociateService.getListofAssociate(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("employeeCode", Matchers.everyItem(Matchers.notNullValue()))
				.and().body("employeeName", Matchers.everyItem(Matchers.notNullValue()));

		// List<GetExperience> list = response.jsonPath().getList("",
		// GetExperience.class);

	}

	@Test
	public void test_getRoleHistoryDLL() {

		String Emp_id = getEmployeeID(HR);
		String token = AuthTokenProvider.getToken(HR);
		ListAssociateService listAssociateService = new ListAssociateService();
		Response response = listAssociateService.getRoleHistoryDLL(Parsetoken(token), Emp_id);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("Id", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("ProjectRole", Matchers.everyItem(Matchers.notNullValue()));

		// List<GetExperience> list = response.jsonPath().getList("",
		// GetExperience.class);

	}

	@Test
	public void test_getEmployeeBasicDetail() {

		Map<String, Object> map1 = new HashMap<String, Object>();
		String Emp_id = getEmployeeID(HR);
		String token = AuthTokenProvider.getToken(HR);
		map1.put("employeeid", Emp_id);
		ListAssociateService listAssociateService = new ListAssociateService();
		Response response = listAssociateService.getRequestofPlainText(Parsetoken(token), Emp_id,
				get_Employee_Basicdetail_EndPoint, map1);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThan(0)))
				.time(Matchers.lessThan(10000L)).and().body("AssociateTypeId", (Matchers.notNullValue())).and()
				.body("CommitmentType", (Matchers.notNullValue()));
	}

	@Test(dataProvider = "associateTypeIds")
	public void test_getContractCommitment(int associateTypeId) {

		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("AssociateTypeID", associateTypeId);
		String Emp_id = getEmployeeID(HR);
		String token = AuthTokenProvider.getToken(HR);
		ListAssociateService listAssociateService = new ListAssociateService();
		Response response = listAssociateService.getContractCommitment(Parsetoken(token), Emp_id, map2);
		response.then().statusCode(200).and().body("", Matchers.hasSize(Matchers.greaterThanOrEqualTo(0)))
				.time(Matchers.lessThan(10000L)).and()
				.body("AssociateTypeID", Matchers.everyItem(Matchers.notNullValue())).and()
				.body("AssociateType", Matchers.everyItem(Matchers.notNullValue()));

		if (associateTypeId >= 4) {

			response.then().body("", Matchers.empty());
		}
	}

	@Test(dataProvider = "Months")
	public void test_GetEmployeeWeeklyOffDetails(int month) {

		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("employeeid", Emp_id);
		map3.put("employmentdetailid", employeedetailID);
		map3.put("Month", month);
		map3.put("Year", 2025);

		System.out.println("\n--- Testing Month: " + month + " ---");
		ListAssociateService listAssociateService = new ListAssociateService();

		Response response = listAssociateService.GetEmployeeWeeklyOffDetails(Parsetoken(token), Emp_id, map3);
		response.then().statusCode(200);

	}

	@Test
	public void test_SaveEmployee() {

		AssociateProfileUpdateData associateProfileUpdateData = new AssociateProfileUpdateData();

		associateProfileUpdateData.setMode("U");
		associateProfileUpdateData.setEmployeeId(5498);
		associateProfileUpdateData.setProfitCenterIds("1");
		associateProfileUpdateData.setEmployeeName("Nayera Mohamed Kamel");
		associateProfileUpdateData.setAssociateTypeId(4);
		associateProfileUpdateData.setCommitmentTypeID(3);
		associateProfileUpdateData.setMinCommitmentHrs(0);
		associateProfileUpdateData.setInternalEmployeeCode("44000028");
		associateProfileUpdateData.setDOB("1987-03-15T00:00:00.000Z");
		associateProfileUpdateData.setLocationId(5);
		associateProfileUpdateData.setFunctionId(6);
		associateProfileUpdateData.setFatherName("LMNOPMNOPQPQRST");
		associateProfileUpdateData.setMotherName("OPQRSQRSTUMNOPQBCDEF");
		associateProfileUpdateData.setSex("F");
		associateProfileUpdateData.setMaritalStatus(null);
		associateProfileUpdateData.setDOJ("2025-06-09T00:00:00.000Z");
		associateProfileUpdateData.setWeddingDate(null);
		associateProfileUpdateData.setPrimaryEmailId("LZS@gmail.com");
		associateProfileUpdateData.setExpectedLeavingDate(null);
		associateProfileUpdateData.setPrimaryContactNumber("8536352746");
		associateProfileUpdateData.setLeavingDate(null);
		associateProfileUpdateData.setEmergencyContactNo1("7233057217");
		associateProfileUpdateData.setEmergencyContactName1("CDEFGVWXYZUVWXYZ");
		associateProfileUpdateData.setRelationship1(null);
		associateProfileUpdateData.setEmergencyContactNo2("6943191388");
		associateProfileUpdateData.setEmergencyContactName2("ABCDETUVWXUVWXY");
		associateProfileUpdateData.setRelationship2(null);
		associateProfileUpdateData.setAssignedManagerId(5507);
		associateProfileUpdateData.setAssociationDate("2025-06-09T00:00:00.000Z");
		associateProfileUpdateData.setIsBioMetricReg(true);
		associateProfileUpdateData.setCardNo(null);
		associateProfileUpdateData.setDayIds(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
		associateProfileUpdateData.setSupportingFile("NoImage.jpg");
		associateProfileUpdateData.setTechnologyIds("3556");
		associateProfileUpdateData.setAllowTimeSheet(2);
		associateProfileUpdateData.setFromSupportiveDept(false);
		associateProfileUpdateData.setIsPermanentWFH(false);
		associateProfileUpdateData.setEntityName("8842825 CANADA INC.");
		associateProfileUpdateData.setPointOfContact1("Nada Manour");
		associateProfileUpdateData.setPointOfContactNo1("+14379873577");
		associateProfileUpdateData.setPointOfContact2(null);
		associateProfileUpdateData.setPointOfContactNo2(null);
		associateProfileUpdateData.setAddress1Present("UVWXYBCDEFYZ");
		associateProfileUpdateData.setAddress2Present("STUVWTUVWX");
		associateProfileUpdateData.setCityPresent(null);
		associateProfileUpdateData.setStatePresent(null);
		associateProfileUpdateData.setCountryPresent(null);
		associateProfileUpdateData.setZipPresent(null);
		associateProfileUpdateData.setIsPermanentAddressSame(null);
		associateProfileUpdateData.setAddress1Permanent("XYZEFGHIWXYZABCDEPQRST");
		associateProfileUpdateData.setAddress2Permanent("YZLMNOP");
		associateProfileUpdateData.setCityPermanent(null);
		associateProfileUpdateData.setStatePermanent(null);
		associateProfileUpdateData.setCountryPermanent(null);
		associateProfileUpdateData.setZipPermanent(null);
		associateProfileUpdateData.setAssignedManager("Reema Dangwal");
		associateProfileUpdateData.setEmployeeLocation("Ontario - Canada");
		associateProfileUpdateData.setTechnologyNames("Snowflake");
		associateProfileUpdateData.setExpatJoinTime(null);
		associateProfileUpdateData.setTotalExp(null);
		associateProfileUpdateData.setIsManager(null);
		associateProfileUpdateData.setIsOwner(false);
		associateProfileUpdateData.setLeavingReason(null);
		associateProfileUpdateData.setPermanentWFHLocation(0);
		associateProfileUpdateData.setRehireEligibity(null);
		associateProfileUpdateData.setReasonForNoHire(null);
		associateProfileUpdateData.setActionBy("2E51ABB1-7844-4B6E-A6DB-C21A33C6705D");
		associateProfileUpdateData.setIsChangeAssociate(false);
		associateProfileUpdateData.setIsApproved(null);
		associateProfileUpdateData.setIsMappingApproved(true);
		associateProfileUpdateData.setIsStandardWeeklyOff(null);
		associateProfileUpdateData.setIsFlexibleWeeklyOff(null);
		associateProfileUpdateData.setFlexibleDates(null);
		associateProfileUpdateData.setWeekoffType(0);
		associateProfileUpdateData.setEffectiveFrom("2025-06-08T18:30:00.000Z");
		associateProfileUpdateData.setOfficialEmail("vishnu.gupta@impressico.com");

		Response response = listAssociate.SaveEmployeeDetails(associateProfileUpdateData, Emp_id, Parsetoken(token));
		response.then().statusCode(200).and().body("message",
				Matchers.equalToIgnoringCase("Associate Basic Information Updated Successfully."));

	}

	@Test(dataProvider = "CommitmentandAssociateTypeids")
	public void test_GetMinimumCommitmentHrs(int associateid, int commitmentids) {

		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("Associatetypeid", associateid);
		map3.put("Commitmenttypeid", commitmentids);

		ListAssociateService listAssociateService = new ListAssociateService();

		Response response = listAssociateService.GetMinimumCommitmentHrs(Parsetoken(token), Emp_id, map3);
		response.then().statusCode(200).and().time(Matchers.lessThan(5000L));

	}
	
	

}
