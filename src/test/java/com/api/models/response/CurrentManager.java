package com.api.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CurrentManager {

    @JsonProperty("Name")
    private String name;
}
