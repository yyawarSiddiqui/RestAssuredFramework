package com.api.models.response;

public class getRRFdetailResponse {

	private int id;
	private String name;

	public getRRFdetailResponse(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public getRRFdetailResponse() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		return "getRRFdetailResponse [id=" + id + ", name=" + name + "]";
	}

}
