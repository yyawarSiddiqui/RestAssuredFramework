package com.api.models.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class getHolidayResponse {

	private int id;
	private int year;
	private String dateofHoliday;
	private String dayofHoliday;
	private String nameofHoliday;
	private boolean floating;
	
	@JsonProperty("isAllowEdit")
	private boolean isAllowEdit;
	private List<LocationDetails> locationDetails;

	public getHolidayResponse(int id, int year, String dateofHoliday, String dayofHoliday, String nameofHoliday,
			boolean floating, boolean isAllowEdit, List<LocationDetails> locationDetails) {
		super();
		this.id = id;
		this.year = year;
		this.dateofHoliday = dateofHoliday;
		this.dayofHoliday = dayofHoliday;
		this.nameofHoliday = nameofHoliday;
		this.floating = floating;
		this.isAllowEdit = isAllowEdit;
		this.locationDetails = locationDetails;
	}

	public getHolidayResponse() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDateofHoliday() {
		return dateofHoliday;
	}

	public void setDateofHoliday(String dateofHoliday) {
		this.dateofHoliday = dateofHoliday;
	}

	public String getDayofHoliday() {
		return dayofHoliday;
	}

	public void setDayofHoliday(String dayofHoliday) {
		this.dayofHoliday = dayofHoliday;
	}

	public String getNameofHoliday() {
		return nameofHoliday;
	}

	public void setNameofHoliday(String nameofHoliday) {
		this.nameofHoliday = nameofHoliday;
	}

	public boolean isFloating() {
		return floating;
	}

	public void setFloating(boolean floating) {
		this.floating = floating;
	}

	public boolean isAllowEdit() {
		return isAllowEdit;
	}

	public void setAllowEdit(boolean isAllowEdit) {
		this.isAllowEdit = isAllowEdit;
	}

	public List<LocationDetails> getLocationDetails() {
		return locationDetails;
	}

	public void setLocationDetails(List<LocationDetails> locationDetails) {
		this.locationDetails = locationDetails;
	}

	@Override
	public String toString() {
		return "getHolidayResponse [id=" + id + ", year=" + year + ", dateofHoliday=" + dateofHoliday
				+ ", dayofHoliday=" + dayofHoliday + ", nameofHoliday=" + nameofHoliday + ", floating=" + floating
				+ ", isAllowEdit=" + isAllowEdit + ", locationDetails=" + locationDetails + "]";
	}

}
