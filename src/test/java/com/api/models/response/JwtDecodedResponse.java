package com.api.models.response;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JwtDecodedResponse {

	@JsonProperty("UserID")
	private String UserID;
	
	@JsonProperty("UserName")
	private String UserName
	;
	@JsonProperty("EmployeeID")
	private String EmployeeID;
	
	@JsonProperty("EmploymentTypeID")
	private String EmploymentTypeID;
	
	@JsonProperty("AssignedManagerID")
	private String AssignedManagerID;
	
	@JsonProperty("AssociateTypeID")
	private String AssociateTypeID;
	
	@JsonProperty("TimesheetTypeID")
	private String TimesheetTypeID;
	
	@JsonProperty("RoleIds")
	private String RoleIds;
	
	@JsonProperty("DepartmentID")
	private String DepartmentID;
	
	@JsonProperty("DepartmentName")
	private String DepartmentName;
	
	@JsonProperty("AccessLocationIds")
	private String AccessLocationIds;
	
	@JsonProperty("AccessHiringLocIds")
	private String AccessHiringLocIds;
	
	@JsonProperty("FromDate")
	private String FromDate;
	
	@JsonProperty("ToDate")
	private String ToDate;
	
	@JsonProperty("LocationID")
	private String LocationID;
	
	@JsonProperty("AllowMFA")
	private String AllowMFA;
	
	@JsonProperty("IsTicketManager")
	private String IsTicketManager;
	
	@JsonProperty("IsTicketAgent")
	private String IsTicketAgent;
	
	@JsonProperty("IsMember")
	private String IsMember;
	
	@JsonProperty("IsManager")
	private String IsManager;
	
	@JsonProperty("AdditionalRole")
	private String AdditionalRole;
	
	@JsonProperty("ProfitCenterIDs")
	private String ProfitCenterIDs;
	
	@JsonProperty("iss")
	private String iss;
	
	@JsonProperty("aud")
	private String aud;
	
	@JsonProperty("nbf")
	private int nbf;
	
	@JsonProperty("exp")
	private int exp;
	
	@JsonProperty("iat")
	private int iat;

	public JwtDecodedResponse() {

	}

	public JwtDecodedResponse(String userID, String userName, String employeeID, String employmentTypeID,
			String assignedManagerID, String associateTypeID, String timesheetTypeID, String roleIds,
			String departmentID, String departmentName, String accessLocationIds, String accessHiringLocIds,
			String fromDate, String toDate, String locationID, String allowMFA, String isTicketManager,
			String isTicketAgent, String isMember, String isManager, String additionalRole, String profitCenterIDs,
			String iss, String aud, int nbf, int exp, int iat) {
		super();
		this.UserID = userID;
		this.UserName = userName;
		this.EmployeeID = employeeID;
		this.EmploymentTypeID = employmentTypeID;
		this.AssignedManagerID = assignedManagerID;
		this.AssociateTypeID = associateTypeID;
		this.TimesheetTypeID = timesheetTypeID;
		this.RoleIds = roleIds;
		this.DepartmentID = departmentID;
		this.DepartmentName = departmentName;
		this.AccessLocationIds = accessLocationIds;
		this.AccessHiringLocIds = accessHiringLocIds;
		this.FromDate = fromDate;
		this.ToDate = toDate;
		this.LocationID = locationID;
		this.AllowMFA = allowMFA;
		this.IsTicketManager = isTicketManager;
		this.IsTicketAgent = isTicketAgent;
		this.IsMember = isMember;
		this.IsManager = isManager;
		this.AdditionalRole = additionalRole;
		this.ProfitCenterIDs = profitCenterIDs;
		this.iss = iss;
		this.aud = aud;
		this.nbf = nbf;
		this.exp = exp;
		this.iat = iat;
	}

	public String getUserID() {
		return UserID;
	}

	public String getUserName() {
		return UserName;
	}

	public String getEmployeeID() {
		return EmployeeID;
	}

	public String getEmploymentTypeID() {
		return EmploymentTypeID;
	}

	public String getAssignedManagerID() {
		return AssignedManagerID;
	}

	public String getAssociateTypeID() {
		return AssociateTypeID;
	}

	public String getTimesheetTypeID() {
		return TimesheetTypeID;
	}

	public String getRoleIds() {
		return RoleIds;
	}

	public String getDepartmentID() {
		return DepartmentID;
	}

	public String getDepartmentName() {
		return DepartmentName;
	}

	public String getAccessLocationIds() {
		return AccessLocationIds;
	}

	public String getAccessHiringLocIds() {
		return AccessHiringLocIds;
	}

	public String getFromDate() {
		return FromDate;
	}

	public String getToDate() {
		return ToDate;
	}

	public String getLocationID() {
		return LocationID;
	}

	public String getAllowMFA() {
		return AllowMFA;
	}

	public String getIsTicketManager() {
		return IsTicketManager;
	}

	public String getIsTicketAgent() {
		return IsTicketAgent;
	}

	public String getIsMember() {
		return IsMember;
	}

	public String getIsManager() {
		return IsManager;
	}

	public String getAdditionalRole() {
		return AdditionalRole;
	}

	public String getProfitCenterIDs() {
		return ProfitCenterIDs;
	}

	public String getIss() {
		return iss;
	}

	public String getAud() {
		return aud;
	}

	public int getNbf() {
		return nbf;
	}

	public int getExp() {
		return exp;
	}

	public int getIat() {
		return iat;
	}

	@Override
	public String toString() {
		return "JwtDecodedResponse [UserID=" + UserID + ", UserName=" + UserName + ", EmployeeID=" + EmployeeID
				+ ", EmploymentTypeID=" + EmploymentTypeID + ", AssignedManagerID=" + AssignedManagerID
				+ ", AssociateTypeID=" + AssociateTypeID + ", TimesheetTypeID=" + TimesheetTypeID + ", RoleIds="
				+ RoleIds + ", DepartmentID=" + DepartmentID + ", DepartmentName=" + DepartmentName
				+ ", AccessLocationIds=" + AccessLocationIds + ", AccessHiringLocIds=" + AccessHiringLocIds
				+ ", FromDate=" + FromDate + ", ToDate=" + ToDate + ", LocationID=" + LocationID + ", AllowMFA="
				+ AllowMFA + ", IsTicketManager=" + IsTicketManager + ", IsTicketAgent=" + IsTicketAgent + ", IsMember="
				+ IsMember + ", IsManager=" + IsManager + ", AdditionalRole=" + AdditionalRole + ", ProfitCenterIDs="
				+ ProfitCenterIDs + ", iss=" + iss + ", aud=" + aud + ", nbf=" + nbf + ", exp=" + exp + ", iat=" + iat
				+ "]";
	}

}
