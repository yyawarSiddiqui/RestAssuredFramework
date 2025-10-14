package com.api.models.response;

public class LocationDetails {

	private int holidayID;
	private String locationIDs;
	private String locationNames;
	private String departmentIDs;
	private String departmentNames;

	public LocationDetails(int holidayID, String locationIDs, String locationNames, String departmentIDs,
			String departmentNames) {
		super();
		this.holidayID = holidayID;
		this.locationIDs = locationIDs;
		this.locationNames = locationNames;
		this.departmentIDs = departmentIDs;
		this.departmentNames = departmentNames;
	}

	public LocationDetails() {

	}

	public int getHolidayID() {
		return holidayID;
	}

	public void setHolidayID(int holidayID) {
		this.holidayID = holidayID;
	}

	public String getLocationIDs() {
		return locationIDs;
	}

	public void setLocationIDs(String locationIDs) {
		this.locationIDs = locationIDs;
	}

	public String getLocationNames() {
		return locationNames;
	}

	public void setLocationNames(String locationNames) {
		this.locationNames = locationNames;
	}

	public String getDepartmentIDs() {
		return departmentIDs;
	}

	public void setDepartmentIDs(String departmentIDs) {
		this.departmentIDs = departmentIDs;
	}

	public String getDepartmentNames() {
		return departmentNames;
	}

	public void setDepartmentNames(String departmentNames) {
		this.departmentNames = departmentNames;
	}

	@Override
	public String toString() {
		return "LocationDetails [holidayID=" + holidayID + ", locationIDs=" + locationIDs + ", locationNames="
				+ locationNames + ", departmentIDs=" + departmentIDs + ", departmentNames=" + departmentNames + "]";
	}

}
