package com.api.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)

public class UpdateProfileRequest {

	@JsonProperty("UpdateProfileId")
	private int updateProfileId;

	@JsonProperty("EmployeeId")
	private String employeeId;

	@JsonProperty("IsBasicInfoUpdated")
	private boolean isBasicInfoUpdated;

	@JsonProperty("BasicInfoUpdateNotes")
	private String basicInfoUpdateNotes;

	@JsonProperty("BasicInfoHRRemarks")
	private String basicInfoHRRemarks;

	@JsonProperty("IsAddressUpdated")
	private boolean isAddressUpdated;

	@JsonProperty("AddressUpdateNotes")
	private String addressUpdateNotes;

	@JsonProperty("AddressHRRemarks")
	private String addressHRRemarks;

	@JsonProperty("IsAcademicDetailsUpdated")
	private boolean isAcademicDetailsUpdated;

	@JsonProperty("AcademicUpdateNotes")
	private String academicUpdateNotes;

	@JsonProperty("AcademicHRRemarks")
	private String academicHRRemarks;

	@JsonProperty("IsEmployementHistoryUpdated")
	private boolean isEmployementHistoryUpdated;

	@JsonProperty("EmployementUpdateNotes")
	private String employementUpdateNotes;

	@JsonProperty("EmployementHRRemarks")
	private String employementHRRemarks;

	@JsonProperty("IsEmployeeDependantUpdated")
	private boolean isEmployeeDependantUpdated;

	@JsonProperty("DependantUpdateNotes")
	private String dependantUpdateNotes;

	@JsonProperty("DependantHRRemarks")
	private String dependantHRRemarks;

	@JsonProperty("IsTechnologyUpdated")
	private boolean isTechnologyUpdated;

	@JsonProperty("TechnologyUpdateNotes")
	private String technologyUpdateNotes;

	@JsonProperty("TechnologyHRRemarks")
	private String technologyHRRemarks;

	@JsonProperty("IsEmployeeIdentityUpdated")
	private boolean isEmployeeIdentityUpdated;

	@JsonProperty("IdentityUpdateNotes")
	private String identityUpdateNotes;

	@JsonProperty("IdentityHRRemarks")
	private String identityHRRemarks;

	@JsonProperty("IsBankDetailsUpdated")
	private boolean isBankDetailsUpdated;

	@JsonProperty("BankUpdateNotes")
	private String bankUpdateNotes;

	@JsonProperty("BankHRRemarks")
	private String bankHRRemarks;

	@JsonProperty("IsEmployeeDesignationUpdated")
	private boolean isEmployeeDesignationUpdated;

	@JsonProperty("DesignationUpdateNotes")
	private String designationUpdateNotes;

	@JsonProperty("DesignationHRRemarks")
	private String designationHRRemarks;

	@JsonProperty("associateBasicInfoDetails")
	private AssociateBasicInfoDetails associateBasicInfoDetails;

	@JsonProperty("addressDetails")
	private Object addressDetails;

	@JsonProperty("designationDetails")
	private Object designationDetails;

	@JsonProperty("technicalSkillsDetails")
	private Object technicalSkillsDetails;

	@JsonProperty("academicDetails")
	private Object academicDetails;

	@JsonProperty("employmentHistoryDetails")
	private Object employmentHistoryDetails;

	@JsonProperty("familyDetails")
	private Object familyDetails;

	@JsonProperty("identityDetails")
	private Object identityDetails;

	@JsonProperty("bankDetails")
	private Object bankDetails;

}
