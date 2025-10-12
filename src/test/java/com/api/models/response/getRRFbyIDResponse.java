package com.api.models.response;

public class getRRFbyIDResponse {

	 private int employeeID;
	    private String employeeName;

	    // Getters
	    public int getEmployeeID() {
	        return employeeID;
	    }

	    public String getEmployeeName() {
	        return employeeName;
	    }

	    // Setters
	    public void setEmployeeID(int employeeID) {
	        this.employeeID = employeeID;
	    }

	    public void setEmployeeName(String employeeName) {
	        this.employeeName = employeeName;
	    }

	    @Override
	    public String toString() {
	        return "Employee{" +
	                "employeeID=" + employeeID +
	                ", employeeName='" + employeeName + '\'' +
	                '}';
	    }
	
}
