package com.api.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class LeaveResponse {

    @JsonProperty("Leave Details")
    private List<LeaveDetail> leaveDetails;

    @JsonProperty("CurrentLeaveBalanceStatus")
    private List<CurrentLeaveBalanceStatus> currentLeaveBalanceStatus;

    @JsonProperty("CurrentManager")
    private List<CurrentManager> currentManager;
}
