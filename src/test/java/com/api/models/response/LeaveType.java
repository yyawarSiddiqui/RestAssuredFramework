package com.api.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LeaveType {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;
}
