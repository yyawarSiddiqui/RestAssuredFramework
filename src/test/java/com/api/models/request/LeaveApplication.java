package com.api.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.ALWAYS)
public class LeaveApplication {

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

    @JsonProperty("LeaveStatus")
    private String leaveStatus;

    @JsonProperty("ActionBy")
    private String actionBy;

    @JsonProperty("LeaveType")
    private String leaveType;

    @JsonProperty("LeaveDocument")
    private String leaveDocument;

    @JsonProperty("LeaveStatusID")
    private String leaveStatusID;

    @JsonProperty("LeaveTypeName")
    private String leaveTypeName;

    @JsonProperty("ReportingManager")
    private String reportingManager;

    @JsonProperty("EmployeeName")
    private String employeeName;

    @JsonProperty("FileName")
    private String fileName;

    @JsonProperty("HRApprovalStatusID")
    private String hrApprovalStatusID;

    @JsonProperty("HRApprovalStatus")
    private String hrApprovalStatus;
}

