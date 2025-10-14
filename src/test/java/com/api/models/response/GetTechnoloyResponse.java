package com.api.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetTechnoloyResponse {

	@JsonProperty("ID")
	private int ID;
	
	@JsonProperty("Technology")
	private String Technology;
	
	public GetTechnoloyResponse(int iD, String technology) {
		super();
		ID = iD;
		Technology = technology;
	}
	
	public GetTechnoloyResponse() {
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTechnology() {
		return Technology;
	}

	public void setTechnology(String technology) {
		Technology = technology;
	}

	@Override
	public String toString() {
		return "GetTechnoloyResponse [ID=" + ID + ", Technology=" + Technology + "]";
	}

	
}
