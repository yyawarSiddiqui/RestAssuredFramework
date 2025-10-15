package com.api.models.response;

public class ApprovedDepartmentList {

	private int id;
	private String name;

	public ApprovedDepartmentList() {
		super();
	}

	public ApprovedDepartmentList(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

}
