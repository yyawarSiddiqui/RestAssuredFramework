package com.api.models.response;

public class getProjectbyEmployeeID {

	private int ProjectId;
	private String ProjectName;

	public getProjectbyEmployeeID(int projectId, String projectName) {
		super();
		ProjectId = projectId;
		ProjectName = projectName;
	}

	public int getProjectId() {
		return ProjectId;
	}

	public void setProjectId(int projectId) {
		ProjectId = projectId;
	}

	public String getProjectName() {
		return ProjectName;
	}

	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}

	@Override
	public String toString() {
		return "getProjectbyEmployeeID [ProjectId=" + ProjectId + ", ProjectName=" + ProjectName + "]";
	}

}
