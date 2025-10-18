package com.api.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssociateBasicInfoDetails {

	@JsonProperty("EmployeeId")
	private int employeeId;

	@JsonProperty("EmployeeName")
	private String employeeName;

	@JsonProperty("AssociateTypeId")
	private int associateTypeId;

	@JsonProperty("InternalEmployeeCode")
	private String internalEmployeeCode;

	@JsonProperty("DOB")
	private String dob;

	@JsonProperty("LocationId")
	private int locationId;

	@JsonProperty("FunctionId")
	private int functionId;

	@JsonProperty("FatherName")
	private String fatherName;

	@JsonProperty("MotherName")
	private String motherName;

	@JsonProperty("Sex")
	private String sex;

	@JsonProperty("MaritalStatus")
	private String maritalStatus;

	@JsonProperty("DOJ")
	private String doj;

	@JsonProperty("WeddingDate")
	private String weddingDate;

	@JsonProperty("PrimaryEmailId")
	private String primaryEmailId;

	@JsonProperty("LeavingDate")
	private String leavingDate;

	@JsonProperty("ExpectedLeavingDate")
	private String expectedLeavingDate;

	@JsonProperty("PrimaryContactNumber")
	private String primaryContactNumber;

	@JsonProperty("EmergencyContactNo1")
	private String emergencyContactNo1;

	@JsonProperty("EmergencyContactName1")
	private String emergencyContactName1;

	@JsonProperty("EmergencyContactNo2")
	private String emergencyContactNo2;

	@JsonProperty("EmergencyContactName2")
	private String emergencyContactName2;

	@JsonProperty("Relationship1")
	private String relationship1;

	@JsonProperty("Relationship2")
	private String relationship2;

	@JsonProperty("AssociationDate")
	private String associationDate;

	@JsonProperty("AssignedManagerId")
	private int assignedManagerId;

	@JsonProperty("DayIds")
	private List<Integer> dayIds;

	@JsonProperty("CardNo")
	private String cardNo;

	@JsonProperty("AllowTimeSheet")
	private int allowTimeSheet;

	@JsonProperty("SupportingFile")
	private String supportingFile;

	@JsonProperty("Document")
	private String document;
}
