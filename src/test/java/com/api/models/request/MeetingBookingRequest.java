package com.api.models.request;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeetingBookingRequest {

    @JsonProperty("meetingTitle")
    private String meetingTitle;

    @JsonProperty("projectName")
    private String projectName;

    @JsonProperty("mode")
    private String mode;

    @JsonProperty("attendees")
    private String attendees;

    @JsonProperty("bookingDetailId")
    private int bookingDetailId;

    @JsonProperty("buildingId")
    private int buildingId;

    @JsonProperty("resourceId")
    private String resourceId;

    @JsonProperty("meetingRoomId")
    private int meetingRoomId;

    @JsonProperty("fromTime")
    private String fromTime;

    @JsonProperty("toTime")
    private String toTime;

    @JsonProperty("fromDate")
    private String fromDate;

    @JsonProperty("toDate")
    private String toDate;

    @JsonProperty("bookingStatus")
    private int bookingStatus;

    @JsonProperty("Booked")
    private int booked;

    @JsonProperty("weekdays")
    private String weekdays;

    @JsonProperty("createdBy")
    private String createdBy;
}
