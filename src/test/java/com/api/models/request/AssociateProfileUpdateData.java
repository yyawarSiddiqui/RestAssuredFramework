package com.api.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class AssociateProfileUpdateData {

	@JsonProperty("Mode")
	private String Mode;

	@JsonProperty("EmployeeId")
	private int EmployeeId;

	@JsonProperty("ProfitCenterIds")
	private String ProfitCenterIds;

	@JsonProperty("EmployeeName")
	private String EmployeeName;

	@JsonProperty("AssociateTypeId")
	private int AssociateTypeId;

	@JsonProperty("CommitmentTypeID")
	private int CommitmentTypeID;

	@JsonProperty("MinCommitmentHrs")
	private int MinCommitmentHrs;

	@JsonProperty("InternalEmployeeCode")
	private String InternalEmployeeCode;

	@JsonProperty("DOB")
	private String DOB;

	@JsonProperty("LocationId")
	private int LocationId;

	@JsonProperty("FunctionId")
	private int FunctionId;

	@JsonProperty("FatherName")
	private String FatherName;

	@JsonProperty("MotherName")
	private String MotherName;

	@JsonProperty("Sex")
	private String Sex;

	@JsonProperty("MaritalStatus")
	private String MaritalStatus;

	@JsonProperty("DOJ")
	private String DOJ;

	@JsonProperty("WeddingDate")
	private String WeddingDate;

	@JsonProperty("PrimaryEmailId")
	private String PrimaryEmailId;

	@JsonProperty("ExpectedLeavingDate")
	private String ExpectedLeavingDate;

	@JsonProperty("PrimaryContactNumber")
	private String PrimaryContactNumber;

	@JsonProperty("LeavingDate")
	private String LeavingDate;

	@JsonProperty("EmergencyContactNo1")
	private String EmergencyContactNo1;

	@JsonProperty("EmergencyContactName1")
	private String EmergencyContactName1;

	@JsonProperty("Relationship1")
	private String Relationship1;

	@JsonProperty("EmergencyContactNo2")
	private String EmergencyContactNo2;

	@JsonProperty("EmergencyContactName2")
	private String EmergencyContactName2;

	@JsonProperty("Relationship2")
	private String Relationship2;

	@JsonProperty("AssignedManagerId")
	private int AssignedManagerId;

	@JsonProperty("AssociationDate")
	private String AssociationDate;

	@JsonProperty("IsBioMetricReg")
	private Boolean IsBioMetricReg;

	@JsonProperty("CardNo")
	private String CardNo;

	@JsonProperty("DayIds")
	private List<Integer> DayIds;

	@JsonProperty("SupportingFile")
	private String SupportingFile;

	@JsonProperty("TechnologyIds")
	private String TechnologyIds;

	@JsonProperty("AllowTimeSheet")
	private int AllowTimeSheet;

	@JsonProperty("FromSupportiveDept")
	private Boolean FromSupportiveDept;

	@JsonProperty("IsPermanentWFH")
	private Boolean IsPermanentWFH;

	@JsonProperty("EntityName")
	private String EntityName;

	@JsonProperty("PointOfContact1")
	private String PointOfContact1;

	@JsonProperty("PointOfContactNo1")
	private String PointOfContactNo1;

	@JsonProperty("PointOfContact2")
	private String PointOfContact2;

	@JsonProperty("PointOfContactNo2")
	private String PointOfContactNo2;

	@JsonProperty("Address1Present")
	private String Address1Present;

	@JsonProperty("Address2Present")
	private String Address2Present;

	@JsonProperty("CityPresent")
	private String CityPresent;

	@JsonProperty("StatePresent")
	private String StatePresent;

	@JsonProperty("CountryPresent")
	private String CountryPresent;

	@JsonProperty("ZipPresent")
	private String ZipPresent;

	@JsonProperty("IsPermanentAddressSame")
	private Boolean IsPermanentAddressSame;

	@JsonProperty("Address1Permanent")
	private String Address1Permanent;

	@JsonProperty("Address2Permanent")
	private String Address2Permanent;

	@JsonProperty("CityPermanent")
	private String CityPermanent;

	@JsonProperty("StatePermanent")
	private String StatePermanent;

	@JsonProperty("CountryPermanent")
	private String CountryPermanent;

	@JsonProperty("ZipPermanent")
	private String ZipPermanent;

	@JsonProperty("AssignedManager")
	private String AssignedManager;

	@JsonProperty("EmployeeLocation")
	private String EmployeeLocation;

	@JsonProperty("TechnologyNames")
	private String TechnologyNames;

	@JsonProperty("ExpatJoinTime")
	private String ExpatJoinTime;

	@JsonProperty("TotalExp")
	private String TotalExp;

	@JsonProperty("IsManager")
	private Boolean IsManager;

	@JsonProperty("IsOwner")
	private Boolean IsOwner;

	@JsonProperty("LeavingReason")
	private String LeavingReason;

	@JsonProperty("PermanentWFHLocation")
	private int PermanentWFHLocation;

	@JsonProperty("RehireEligibity")
	private Boolean RehireEligibity;

	@JsonProperty("ReasonForNoHire")
	private String ReasonForNoHire;

	@JsonProperty("ActionBy")
	private String ActionBy;

	@JsonProperty("IsChangeAssociate")
	private Boolean IsChangeAssociate;

	@JsonProperty("isApproved")
	private Boolean isApproved;

	@JsonProperty("IsMappingApproved")
	private Boolean IsMappingApproved;

	@JsonProperty("IsStandardWeeklyOff")
	private Boolean IsStandardWeeklyOff;

	@JsonProperty("IsFlexibleWeeklyOff")
	private Boolean IsFlexibleWeeklyOff;

	@JsonProperty("FlexibleDates")
	private String FlexibleDates;

	@JsonProperty("WeekoffType")
	private int WeekoffType;

	@JsonProperty("EffectiveFrom")
	private String EffectiveFrom;

	@JsonProperty("OfficialEmail")
	private String OfficialEmail;



	public String getMode() {
		return Mode;
	}

	public void setMode(String mode) {
		Mode = mode;
	}

	public int getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}

	public String getProfitCenterIds() {
		return ProfitCenterIds;
	}

	public void setProfitCenterIds(String profitCenterIds) {
		ProfitCenterIds = profitCenterIds;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public int getAssociateTypeId() {
		return AssociateTypeId;
	}

	public void setAssociateTypeId(int associateTypeId) {
		AssociateTypeId = associateTypeId;
	}

	public int getCommitmentTypeID() {
		return CommitmentTypeID;
	}

	public void setCommitmentTypeID(int commitmentTypeID) {
		CommitmentTypeID = commitmentTypeID;
	}

	public int getMinCommitmentHrs() {
		return MinCommitmentHrs;
	}

	public void setMinCommitmentHrs(int minCommitmentHrs) {
		MinCommitmentHrs = minCommitmentHrs;
	}

	public String getInternalEmployeeCode() {
		return InternalEmployeeCode;
	}

	public void setInternalEmployeeCode(String internalEmployeeCode) {
		InternalEmployeeCode = internalEmployeeCode;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public int getLocationId() {
		return LocationId;
	}

	public void setLocationId(int locationId) {
		LocationId = locationId;
	}

	public int getFunctionId() {
		return FunctionId;
	}

	public void setFunctionId(int functionId) {
		FunctionId = functionId;
	}

	public String getFatherName() {
		return FatherName;
	}

	public void setFatherName(String fatherName) {
		FatherName = fatherName;
	}

	public String getMotherName() {
		return MotherName;
	}

	public void setMotherName(String motherName) {
		MotherName = motherName;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getMaritalStatus() {
		return MaritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		MaritalStatus = maritalStatus;
	}

	public String getDOJ() {
		return DOJ;
	}

	public void setDOJ(String dOJ) {
		DOJ = dOJ;
	}

	public String getWeddingDate() {
		return WeddingDate;
	}

	public void setWeddingDate(String weddingDate) {
		WeddingDate = weddingDate;
	}

	public String getPrimaryEmailId() {
		return PrimaryEmailId;
	}

	public void setPrimaryEmailId(String primaryEmailId) {
		PrimaryEmailId = primaryEmailId;
	}

	public String getExpectedLeavingDate() {
		return ExpectedLeavingDate;
	}

	public void setExpectedLeavingDate(String expectedLeavingDate) {
		ExpectedLeavingDate = expectedLeavingDate;
	}

	public String getPrimaryContactNumber() {
		return PrimaryContactNumber;
	}

	public void setPrimaryContactNumber(String primaryContactNumber) {
		PrimaryContactNumber = primaryContactNumber;
	}

	public String getLeavingDate() {
		return LeavingDate;
	}

	public void setLeavingDate(String leavingDate) {
		LeavingDate = leavingDate;
	}

	public String getEmergencyContactNo1() {
		return EmergencyContactNo1;
	}

	public void setEmergencyContactNo1(String emergencyContactNo1) {
		EmergencyContactNo1 = emergencyContactNo1;
	}

	public String getEmergencyContactName1() {
		return EmergencyContactName1;
	}

	public void setEmergencyContactName1(String emergencyContactName1) {
		EmergencyContactName1 = emergencyContactName1;
	}

	public String getRelationship1() {
		return Relationship1;
	}

	public void setRelationship1(String relationship1) {
		Relationship1 = relationship1;
	}

	public String getEmergencyContactNo2() {
		return EmergencyContactNo2;
	}

	public void setEmergencyContactNo2(String emergencyContactNo2) {
		EmergencyContactNo2 = emergencyContactNo2;
	}

	public String getEmergencyContactName2() {
		return EmergencyContactName2;
	}

	public void setEmergencyContactName2(String emergencyContactName2) {
		EmergencyContactName2 = emergencyContactName2;
	}

	public String getRelationship2() {
		return Relationship2;
	}

	public void setRelationship2(String relationship2) {
		Relationship2 = relationship2;
	}

	public int getAssignedManagerId() {
		return AssignedManagerId;
	}

	public void setAssignedManagerId(int assignedManagerId) {
		AssignedManagerId = assignedManagerId;
	}

	public String getAssociationDate() {
		return AssociationDate;
	}

	public void setAssociationDate(String associationDate) {
		AssociationDate = associationDate;
	}

	public Boolean getIsBioMetricReg() {
		return IsBioMetricReg;
	}

	public void setIsBioMetricReg(Boolean isBioMetricReg) {
		IsBioMetricReg = isBioMetricReg;
	}

	public String getCardNo() {
		return CardNo;
	}

	public void setCardNo(String cardNo) {
		CardNo = cardNo;
	}

	public List<Integer> getDayIds() {
		return DayIds;
	}

	public void setDayIds(List<Integer> dayIds) {
		DayIds = dayIds;
	}

	public String getSupportingFile() {
		return SupportingFile;
	}

	public void setSupportingFile(String supportingFile) {
		SupportingFile = supportingFile;
	}

	public String getTechnologyIds() {
		return TechnologyIds;
	}

	public void setTechnologyIds(String technologyIds) {
		TechnologyIds = technologyIds;
	}

	public int getAllowTimeSheet() {
		return AllowTimeSheet;
	}

	public void setAllowTimeSheet(int allowTimeSheet) {
		AllowTimeSheet = allowTimeSheet;
	}

	public Boolean getFromSupportiveDept() {
		return FromSupportiveDept;
	}

	public void setFromSupportiveDept(Boolean fromSupportiveDept) {
		FromSupportiveDept = fromSupportiveDept;
	}

	public Boolean getIsPermanentWFH() {
		return IsPermanentWFH;
	}

	public void setIsPermanentWFH(Boolean isPermanentWFH) {
		IsPermanentWFH = isPermanentWFH;
	}

	public String getEntityName() {
		return EntityName;
	}

	public void setEntityName(String entityName) {
		EntityName = entityName;
	}

	public String getPointOfContact1() {
		return PointOfContact1;
	}

	public void setPointOfContact1(String pointOfContact1) {
		PointOfContact1 = pointOfContact1;
	}

	public String getPointOfContactNo1() {
		return PointOfContactNo1;
	}

	public void setPointOfContactNo1(String pointOfContactNo1) {
		PointOfContactNo1 = pointOfContactNo1;
	}

	public String getPointOfContact2() {
		return PointOfContact2;
	}

	public void setPointOfContact2(String pointOfContact2) {
		PointOfContact2 = pointOfContact2;
	}

	public String getPointOfContactNo2() {
		return PointOfContactNo2;
	}

	public void setPointOfContactNo2(String pointOfContactNo2) {
		PointOfContactNo2 = pointOfContactNo2;
	}

	public String getAddress1Present() {
		return Address1Present;
	}

	public void setAddress1Present(String address1Present) {
		Address1Present = address1Present;
	}

	public String getAddress2Present() {
		return Address2Present;
	}

	public void setAddress2Present(String address2Present) {
		Address2Present = address2Present;
	}

	public String getCityPresent() {
		return CityPresent;
	}

	public void setCityPresent(String cityPresent) {
		CityPresent = cityPresent;
	}

	public String getStatePresent() {
		return StatePresent;
	}

	public void setStatePresent(String statePresent) {
		StatePresent = statePresent;
	}

	public String getCountryPresent() {
		return CountryPresent;
	}

	public void setCountryPresent(String countryPresent) {
		CountryPresent = countryPresent;
	}

	public String getZipPresent() {
		return ZipPresent;
	}

	public void setZipPresent(String zipPresent) {
		ZipPresent = zipPresent;
	}

	public Boolean getIsPermanentAddressSame() {
		return IsPermanentAddressSame;
	}

	public void setIsPermanentAddressSame(Boolean isPermanentAddressSame) {
		IsPermanentAddressSame = isPermanentAddressSame;
	}

	public String getAddress1Permanent() {
		return Address1Permanent;
	}

	public void setAddress1Permanent(String address1Permanent) {
		Address1Permanent = address1Permanent;
	}

	public String getAddress2Permanent() {
		return Address2Permanent;
	}

	public void setAddress2Permanent(String address2Permanent) {
		Address2Permanent = address2Permanent;
	}

	public String getCityPermanent() {
		return CityPermanent;
	}

	public void setCityPermanent(String cityPermanent) {
		CityPermanent = cityPermanent;
	}

	public String getStatePermanent() {
		return StatePermanent;
	}

	public void setStatePermanent(String statePermanent) {
		StatePermanent = statePermanent;
	}

	public String getCountryPermanent() {
		return CountryPermanent;
	}

	public void setCountryPermanent(String countryPermanent) {
		CountryPermanent = countryPermanent;
	}

	public String getZipPermanent() {
		return ZipPermanent;
	}

	public void setZipPermanent(String zipPermanent) {
		ZipPermanent = zipPermanent;
	}

	public String getAssignedManager() {
		return AssignedManager;
	}

	public void setAssignedManager(String assignedManager) {
		AssignedManager = assignedManager;
	}

	public String getEmployeeLocation() {
		return EmployeeLocation;
	}

	public void setEmployeeLocation(String employeeLocation) {
		EmployeeLocation = employeeLocation;
	}

	public String getTechnologyNames() {
		return TechnologyNames;
	}

	public void setTechnologyNames(String technologyNames) {
		TechnologyNames = technologyNames;
	}

	public String getExpatJoinTime() {
		return ExpatJoinTime;
	}

	public void setExpatJoinTime(String expatJoinTime) {
		ExpatJoinTime = expatJoinTime;
	}

	public String getTotalExp() {
		return TotalExp;
	}

	public void setTotalExp(String totalExp) {
		TotalExp = totalExp;
	}

	public Boolean getIsManager() {
		return IsManager;
	}

	public void setIsManager(Boolean isManager) {
		IsManager = isManager;
	}

	public Boolean getIsOwner() {
		return IsOwner;
	}

	public void setIsOwner(Boolean isOwner) {
		IsOwner = isOwner;
	}

	public String getLeavingReason() {
		return LeavingReason;
	}

	public void setLeavingReason(String leavingReason) {
		LeavingReason = leavingReason;
	}

	public int getPermanentWFHLocation() {
		return PermanentWFHLocation;
	}

	public void setPermanentWFHLocation(int permanentWFHLocation) {
		PermanentWFHLocation = permanentWFHLocation;
	}

	public Boolean getRehireEligibity() {
		return RehireEligibity;
	}

	public void setRehireEligibity(Boolean rehireEligibity) {
		RehireEligibity = rehireEligibity;
	}

	public String getReasonForNoHire() {
		return ReasonForNoHire;
	}

	public void setReasonForNoHire(String reasonForNoHire) {
		ReasonForNoHire = reasonForNoHire;
	}

	public String getActionBy() {
		return ActionBy;
	}

	public void setActionBy(String actionBy) {
		ActionBy = actionBy;
	}

	public Boolean getIsChangeAssociate() {
		return IsChangeAssociate;
	}

	public void setIsChangeAssociate(Boolean isChangeAssociate) {
		IsChangeAssociate = isChangeAssociate;
	}

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	public Boolean getIsMappingApproved() {
		return IsMappingApproved;
	}

	public void setIsMappingApproved(Boolean isMappingApproved) {
		IsMappingApproved = isMappingApproved;
	}

	public Boolean getIsStandardWeeklyOff() {
		return IsStandardWeeklyOff;
	}

	public void setIsStandardWeeklyOff(Boolean isStandardWeeklyOff) {
		IsStandardWeeklyOff = isStandardWeeklyOff;
	}

	public Boolean getIsFlexibleWeeklyOff() {
		return IsFlexibleWeeklyOff;
	}

	public void setIsFlexibleWeeklyOff(Boolean isFlexibleWeeklyOff) {
		IsFlexibleWeeklyOff = isFlexibleWeeklyOff;
	}

	public String getFlexibleDates() {
		return FlexibleDates;
	}

	public void setFlexibleDates(String flexibleDates) {
		FlexibleDates = flexibleDates;
	}

	public int getWeekoffType() {
		return WeekoffType;
	}

	public void setWeekoffType(int weekoffType) {
		WeekoffType = weekoffType;
	}

	public String getEffectiveFrom() {
		return EffectiveFrom;
	}

	public void setEffectiveFrom(String effectiveFrom) {
		EffectiveFrom = effectiveFrom;
	}

	public String getOfficialEmail() {
		return OfficialEmail;
	}

	public void setOfficialEmail(String officialEmail) {
		OfficialEmail = officialEmail;
	}

}
