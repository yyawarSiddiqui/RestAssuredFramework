package com.api.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CurrentLeaveBalanceStatus {

    @JsonProperty("Message")
    private String message;
}
