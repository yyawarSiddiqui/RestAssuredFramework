package com.api.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrainingResponsePOJO {

    @JsonProperty("documentID")
    private int documentID;

    @JsonProperty("departmentID")
    private int departmentID;

    @JsonProperty("department")
    private String department;

    @JsonProperty("trainingName")
    private String trainingName;

    @JsonProperty("targetAudienceIDs")
    private String targetAudienceIDs;

    @JsonProperty("targetAudience")
    private String targetAudience;

    @JsonProperty("locationIDs")
    private String locationIDs;

    @JsonProperty("location")
    private String location;

    @JsonProperty("trainingLaunchDate")
    private String trainingLaunchDate;

    @JsonProperty("trainingClosureDate")
    private String trainingClosureDate;

    @JsonProperty("trainingDeadline")
    private String trainingDeadline;

    @JsonProperty("popupRecurrenceDays")
    private int popupRecurrenceDays;

    //  Boolean flags (true/false in JSON)
    @JsonProperty("isMandatoryForNewJoiners")
    private boolean isMandatoryForNewJoiners;

    @JsonProperty("isMandatoryForExtendedLeave")
    private boolean isMandatoryForExtendedLeave;

    @JsonProperty("isTrainingSubmitted")
    private boolean isTrainingSubmitted;

    //  String flags ("Yes"/"No" in JSON)
    @JsonProperty("mandatoryForNewJoiners")
    private String mandatoryForNewJoiners;

    @JsonProperty("mandatoryForExtendedLeave")
    private String mandatoryForExtendedLeave;

    @JsonProperty("createdBy")
    private String createdBy;

    @JsonProperty("isApproved")
    private String isApproved;

    @JsonProperty("trainingStatus")
    private String trainingStatus;

    @JsonProperty("reSubmitRemarks")
    private String reSubmitRemarks;
}
