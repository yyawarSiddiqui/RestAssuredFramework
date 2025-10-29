package com.api.models.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LeaveManagementResponse {
    @JsonProperty("AttendanceSubmission")
    private List<AttendanceSubmission> attendanceSubmission;
    
    @JsonProperty("AttendanceInProcess")
    private List<AttendanceInProcess> attendanceInProcess;
    
    @JsonProperty("DocumentApprovalList")
    private List<DocumentApproval> documentApprovalList;
    
    @JsonProperty("CurrentManager")
    private List<CurrentManager> currentManager;
    
    @JsonProperty("LeaveBalance")
    private List<LeaveBalance> leaveBalance;

    @Data
    public static class AttendanceSubmission {
        @JsonProperty("Status")
        private String status;
    }

    @Data
    public static class AttendanceInProcess {
        @JsonProperty("Column1")
        private boolean column1;
    }

    @Data
    public static class DocumentApproval {
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
        
        @JsonProperty("Approved")
        private int approved;
        
        @JsonProperty("Rejected")
        private int rejected;
        
        @JsonProperty("LeaveStatusID")
        private int leaveStatusId;
        
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
        private int hrApprovalStatusId;
        
        @JsonProperty("HRApprovalStatus")
        private String hrApprovalStatus;
        
        @JsonProperty("EmploymentTypeID")
        private int employmentTypeId;
    }

    @Data
    public static class CurrentManager {
        // Add fields as needed when data is available
    }

    @Data
    public static class LeaveBalance {
        @JsonProperty("LeaveBalance")
        private String leaveBalance;
    }
}