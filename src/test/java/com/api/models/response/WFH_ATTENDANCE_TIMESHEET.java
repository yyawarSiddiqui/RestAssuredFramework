package com.api.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WFH_ATTENDANCE_TIMESHEET {

	@JsonProperty("EmployeeId")
	private int employeeId;

	@JsonProperty("AttID")
	private int attId;

	@JsonProperty("WorkFromHomeId")
	private int workFromHomeId;

	@JsonProperty("Datetrn")
	private String datetrn;

	@JsonProperty("WDay")
	private String wDay;

	@JsonProperty("MachineInTime")
	private String machineInTime;

	@JsonProperty("MachineOutTime")
	private String machineOutTime;

	@JsonProperty("MachineWorkHrs")
	private double machineWorkHrs;

	@JsonProperty("InTime")
	private String inTime;

	@JsonProperty("OutTime")
	private String outTime;

	@JsonProperty("TimesheetType")
	private int timesheetType;

	@JsonProperty("OfficeWorkhrs")
	private double officeWorkhrs;

	@JsonProperty("EmployeeComment")
	private String employeeComment;

	@JsonProperty("MissingPType")
	private int missingPType;

	@JsonProperty("IsMissingApproved")
	private boolean isMissingApproved;

	@JsonProperty("WFHWorkingHrs")
	private Double wfhWorkingHrs;

	@JsonProperty("WFHRemarks")
	private String wfhRemarks;

	@JsonProperty("IsNoWork")
	private boolean isNoWork;

	@JsonProperty("IsWFHApproved")
	private Boolean isWfhApproved;

	@JsonProperty("TotalHrs")
	private double totalHrs;

	@JsonProperty("TotalTimesheetHrs")
	private double totalTimesheetHrs;

	@JsonProperty("IsTSSubmitted")
	private int isTsSubmitted;

	@JsonProperty("IsApproved")
	private int isApproved;

	@JsonProperty("ApprovalStatus")
	private String approvalStatus;
}
