package com.api.models.request;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.ALWAYS)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingDocument {

    @JsonProperty("documentID")
    private int documentID;

    @JsonProperty("departmentID")
    private int departmentID;

    @JsonProperty("trainingName")
    private String trainingName;

    @JsonProperty("targetAudienceIDs")
    private String targetAudienceIDs;

    @JsonProperty("locationIDs")
    private String locationIDs;

    @JsonProperty("trainingLaunchDate")
    private String trainingLaunchDate;

    @JsonProperty("trainingClosureDate")
    private String trainingClosureDate;

    @JsonProperty("trainingDeadline")
    private String trainingDeadline;

    @JsonProperty("popupRecurrenceDays")
    private int popupRecurrenceDays;

    @JsonProperty("isMandatoryForNewJoiners")
    private boolean isMandatoryForNewJoiners;

    @JsonProperty("isMandatoryForExtendedLeave")
    private boolean isMandatoryForExtendedLeave;

    @JsonProperty("actionFrom")
    private String actionFrom;
}
