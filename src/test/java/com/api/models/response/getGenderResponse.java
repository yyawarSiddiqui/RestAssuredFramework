package com.api.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class getGenderResponse {

	@JsonProperty("id")
	private String id;

	@JsonProperty("name")
	private String name;

	public getGenderResponse(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public getGenderResponse() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "getGender [id=" + id + ", name=" + name + "]";
	}

}
