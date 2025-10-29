package com.api.models.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Employee {

	@JsonProperty("id")
	private int id;

	@JsonProperty("projectRole")
	private String projectRole;

	@JsonProperty("isActive")
	private Boolean isActive; 
}
