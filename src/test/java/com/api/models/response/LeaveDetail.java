package com.api.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LeaveDetail {

    @JsonProperty("LeaveId")
    private int leaveId;

    @JsonProperty("EmployeeId")
    private int employeeId;

    @JsonProperty("FromDate")
    private String fromDate;

    @JsonProperty("ToDate")
    private String toDate;

    @JsonProperty("Reason")
    private String reason;

    @JsonProperty("LeaveStatusID")
    private int leaveStatusID;

    @JsonProperty("LeaveStatus")
    private String leaveStatus;

    @JsonProperty("LeaveType")
    private String leaveType;

    @JsonProperty("LeaveTypeName")
    private String leaveTypeName;

    @JsonProperty("ReportingManager")
    private String reportingManager;

    @JsonProperty("EmployeeName")
    private String employeeName;

    @JsonProperty("LeaveDocument")
    private String leaveDocument;

    @JsonProperty("FileName")
    private String fileName;

    @JsonProperty("HRApprovalStatusID")
    private int hrApprovalStatusID;

    @JsonProperty("HRApprovalStatus")
    private String hrApprovalStatus;

    @JsonProperty("lStatus")
    private String lStatus;

    @JsonProperty("lStatusID")
    private int lStatusID;
}
