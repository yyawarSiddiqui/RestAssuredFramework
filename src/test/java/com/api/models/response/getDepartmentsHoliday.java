package com.api.models.response;

public class getDepartmentsHoliday {

	private String id;
	private String name;

	public getDepartmentsHoliday(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public getDepartmentsHoliday() {
		super();
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
		return "getDepartmentsHoliday [id=" + id + ", name=" + name + "]";
	}

}
