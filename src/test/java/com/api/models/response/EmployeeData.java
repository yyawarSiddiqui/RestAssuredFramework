package com.api.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeData {

    @JsonProperty("RowID")
    private int rowID;

    @JsonProperty("ID")
    private int id;

    @JsonProperty("ROWID1")
    private int rowID1;

    @JsonProperty("EmploymentDetailID")
    private int employmentDetailID;

    @JsonProperty("EmployeeId")
    private int employeeId;

    @JsonProperty("EmployeeCode")
    private String employeeCode;

    @JsonProperty("EmployeeName")
    private String employeeName;

    @JsonProperty("TitleFatherName")
    private String titleFatherName;

    @JsonProperty("FatherName")
    private String fatherName;

    @JsonProperty("TitleMotherName")
    private String titleMotherName;

    @JsonProperty("MotherName")
    private String motherName;

    @JsonProperty("DOB")
    private String dob;

    @JsonProperty("Sex")
    private String sex;

    @JsonProperty("MaritalStatus")
    private String maritalStatus;

    @JsonProperty("DOJ")
    private String doj;

    @JsonProperty("SupportingFile")
    private String supportingFile;

    @JsonProperty("CurrentEmployed")
    private String currentEmployed;

    @JsonProperty("WeddingDate")
    private String weddingDate;

    @JsonProperty("LeavingDate")
    private String leavingDate;

    @JsonProperty("InternalEmployeeCode")
    private String internalEmployeeCode;

    @JsonProperty("EmergencyContactNo1")
    private String emergencyContactNo1;

    @JsonProperty("EmergencyContactName1")
    private String emergencyContactName1;

    @JsonProperty("Relationship1")
    private String relationship1;

    @JsonProperty("EmergencyContactNo2")
    private String emergencyContactNo2;

    @JsonProperty("EmergencyContactName2")
    private String emergencyContactName2;

    @JsonProperty("Relationship2")
    private String relationship2;

    @JsonProperty("LocationId")
    private int locationId;

    @JsonProperty("AssignedManager")
    private String assignedManager;

    @JsonProperty("EmployeeLocation")
    private String employeeLocation;

    @JsonProperty("FunctionId")
    private String functionId;

    @JsonProperty("TechnologyIds")
    private String technologyIds;

    @JsonProperty("TechnologyNames")
    private String technologyNames;

    @JsonProperty("ExpatJoinTime")
    private String expatJoinTime;

    @JsonProperty("TotalExp")
    private String totalExp;

    @JsonProperty("PrimaryContactNumber")
    private String primaryContactNumber;

    @JsonProperty("Address1Present")
    private String address1Present;

    @JsonProperty("Address2Present")
    private String address2Present;

    @JsonProperty("PrimaryEmailId")
    private String primaryEmailId;

    @JsonProperty("CityPresent")
    private String cityPresent;

    @JsonProperty("StatePresent")
    private int statePresent;

    @JsonProperty("ZipPresent")
    private String zipPresent;

    @JsonProperty("CountryPresent")
    private String countryPresent;

    @JsonProperty("Address1Permanent")
    private String address1Permanent;

    @JsonProperty("Address2Permanent")
    private String address2Permanent;

    @JsonProperty("CityPermanent")
    private String cityPermanent;

    @JsonProperty("StatePermanent")
    private int statePermanent;

    @JsonProperty("ZipPermanent")
    private String zipPermanent;

    @JsonProperty("CountryPermanent")
    private String countryPermanent;

    @JsonProperty("IsPermanentAddressSame")
    private Boolean isPermanentAddressSame;

    @JsonProperty("AssignedManagerId")
    private int assignedManagerId;

    @JsonProperty("IsManager")
    private Boolean isManager;

    @JsonProperty("IsOwner")
    private Boolean isOwner;

    @JsonProperty("AssociateTypeId")
    private int associateTypeId;

    @JsonProperty("AllowTimeSheet")
    private int allowTimeSheet;

    @JsonProperty("CardNo")
    private String cardNo;

    @JsonProperty("AssociationDate")
    private String associationDate;

    @JsonProperty("LeavingReason")
    private String leavingReason;

    @JsonProperty("IsBioMetricReg")
    private Boolean isBioMetricReg;

    @JsonProperty("FromSupportiveDept")
    private Boolean fromSupportiveDept;

    @JsonProperty("IsPermanentWFH")
    private Boolean isPermanentWFH;

    @JsonProperty("PermanentWFHLocation")
    private int permanentWFHLocation;

    @JsonProperty("EntityName")
    private String entityName;

    @JsonProperty("PointOfContact1")
    private String pointOfContact1;

    @JsonProperty("PointOfContactNo1")
    private String pointOfContactNo1;

    @JsonProperty("PointOfContact2")
    private String pointOfContact2;

    @JsonProperty("PointOfContactNo2")
    private String pointOfContactNo2;

    @JsonProperty("ExpectedLeavingDate")
    private String expectedLeavingDate;

    @JsonProperty("RehireEligibity")
    private String rehireEligibity;

    @JsonProperty("ReasonForNoHire")
    private String reasonForNoHire;

    @JsonProperty("CommitmentTypeID")
    private int commitmentTypeID;

    @JsonProperty("CommitmentType")
    private String commitmentType;

    @JsonProperty("MinCommitedHrs")
    private int minCommitedHrs;

    @JsonProperty("ProfitCenterID")
    private String profitCenterID;

    @JsonProperty("ProfitCenterName")
    private String profitCenterName;

    @JsonProperty("IsMappingApproved")
    private Boolean isMappingApproved;

    @JsonProperty("UpdateProfileId")
    private int updateProfileId;

    @JsonProperty("Document")
    private String document;

    @JsonProperty("ActionDate")
    private String actionDate;

    @JsonProperty("EmployeeEmail")
    private String employeeEmail;
}

