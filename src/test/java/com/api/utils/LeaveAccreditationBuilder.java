package com.api.utils;

import com.api.models.request.LeaveAccreditation;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class LeaveAccreditationBuilder {

	private LeaveAccreditation data;

	
	
	public LeaveAccreditationBuilder() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			data = mapper.readValue(new File("src/test/resources/PayloadjSon/LeaveAccreditationDefault.json"),
					LeaveAccreditation.class);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load default LeaveAccreditation JSON", e);
		}
	}

	public LeaveAccreditationBuilder withSupportStaffDisabled(boolean flag) {
		data.setSupportStaffLeaveAccrediationDisavled(flag);
		return this;
	}

	public LeaveAccreditationBuilder withLeaveAllocationForType(int associateTypeId, String newAllocation) {
		data.getLeaveAllocationJoiningList().stream().filter(item -> item.getAssociateTypeId() == associateTypeId)
				.forEach(item -> item.setLeaveAllocation(newAllocation));
		return this;
	}

	public LeaveAccreditationBuilder withMaternityLeaveValue(String value) {
		data.getMaternityLeavesList().get(0).setValue(value);
		return this;
	}

	public LeaveAccreditationBuilder withWorkingHours(int associateTypeId, String newHours) {
		data.getMonthlyWorkingHoursList().stream().filter(w -> w.getAssociateTypeId() == associateTypeId)
				.forEach(w -> w.setMonthlyWorkingHrs(newHours));
		return this;
	}

	public LeaveAccreditation build() {
		return data;
	}
}
