package com.api.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@ToString
public class EmployeeDetailsResponse {

    @JsonProperty("Data")
    private List<EmployeeData> data;

    @JsonProperty("FlagDetails")
    private List<Object> flagDetails; // Keep it Object if structure unknown
}

