package com.api.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class getAssociateTypeResponse {

	@JsonProperty("AssociateTypeId")
	private int AssociateTypeId;
	
	@JsonProperty("AssociateType")
	private String AssociateType;
	
	public getAssociateTypeResponse(int associateTypeId, String associateType) {
		super();
		AssociateTypeId = associateTypeId;
		AssociateType = associateType;
	}
	
	public getAssociateTypeResponse() {
		
	}

	public int getAssociateTypeId() {
		return AssociateTypeId;
	}

	public void setAssociateTypeId(int associateTypeId) {
		AssociateTypeId = associateTypeId;
	}

	public String getAssociateType() {
		return AssociateType;
	}

	public void setAssociateType(String associateType) {
		AssociateType = associateType;
	}

	@Override
	public String toString() {
		return "getAssociateTypeResponse [AssociateTypeId=" + AssociateTypeId + ", AssociateType=" + AssociateType
				+ "]";
	}
	
	
	
}
