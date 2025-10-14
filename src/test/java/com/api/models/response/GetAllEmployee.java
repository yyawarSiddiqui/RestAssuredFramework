package com.api.models.response;

public class GetAllEmployee {

	private int employeeID;
	private String employeeName;

	public GetAllEmployee(int employeeID, String employeeName) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
	}

	public GetAllEmployee() {

	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	public String toString() {
		return "GetAllEmployee{" + "employeeID=" + employeeID + ", employeeName='" + employeeName + '\'' + '}';
	}
}
