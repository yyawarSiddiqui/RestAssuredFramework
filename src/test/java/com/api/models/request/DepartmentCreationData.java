package com.api.models.request;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class DepartmentCreationData {

    @JsonProperty("functionId")
    private int functionId;

    @JsonProperty("functionName")
    private String functionName;

    @JsonProperty("functionCategory")
    private String functionCategory;

    @JsonProperty("functionCode")
    private String functionCode;

    @JsonProperty("departmentEmail")
    private String departmentEmail;

    @JsonProperty("isUsedInTicket")
    private int isUsedInTicket;

    @JsonProperty("isUsedInAMS")
    private Boolean isUsedInAMS;

    @JsonProperty("isFlexibleWeeklyOff")
    private Boolean isFlexibleWeeklyOff;

    @JsonProperty("active")
    private Boolean active;
}
