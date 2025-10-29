package com.api.models.request;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveAccreditation {

	@JsonProperty("SupportStaffLeaveAccrediationDisavled")
	private boolean supportStaffLeaveAccrediationDisavled;

	@JsonProperty("LeaveAllocationJoiningList")
	private List<LeaveAllocationJoining> leaveAllocationJoiningList;

	@JsonProperty("LeaveAllocationLeavingList")
	private List<LeaveAllocationLeaving> leaveAllocationLeavingList;

	@JsonProperty("MaximumPLCarryForwardYearlyList")
	private List<MaximumPLCarryForwardYearly> maximumPLCarryForwardYearlyList;

	@JsonProperty("TotalPLCarryForwardYearlyList")
	private List<TotalPLCarryForwardYearly> totalPLCarryForwardYearlyList;

	@JsonProperty("MonthlyWorkingHoursList")
	private List<MonthlyWorkingHours> monthlyWorkingHoursList;

	@JsonProperty("MaximumContinuousLeavesList")
	private List<MaximumContinuousLeaves> maximumContinuousLeavesList;

	@JsonProperty("MaternityLeavesList")
	private List<MaternityLeaves> maternityLeavesList;

	@JsonProperty("CompOffDetailsList")
	private List<CompOffDetails> compOffDetailsList;

	@JsonProperty("ShortServiceDetailsList")
	private List<ShortServiceDetails> shortServiceDetailsList;

	// --- Inner classes for each list ---

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class LeaveAllocationJoining {
		@JsonProperty("JoiningSlotId")
		private int joiningSlotId;
		@JsonProperty("AssociateTypeId")
		private int associateTypeId;
		@JsonProperty("StartDay")
		private int startDay;
		@JsonProperty("EndDay")
		private int endDay;
		@JsonProperty("AssociateType")
		private String associateType;
		@JsonProperty("LeaveAllocation")
		private String leaveAllocation;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class LeaveAllocationLeaving {
		@JsonProperty("JoiningSlotId")
		private int joiningSlotId;
		@JsonProperty("AssociateTypeId")
		private int associateTypeId;
		@JsonProperty("StartDay")
		private int startDay;
		@JsonProperty("EndDay")
		private int endDay;
		@JsonProperty("AssociateType")
		private String associateType;
		@JsonProperty("LeaveAllocation")
		private String leaveAllocation;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class MaximumPLCarryForwardYearly {
		@JsonProperty("AssociateTypeId")
		private int associateTypeId;
		@JsonProperty("AssociateType")
		private String associateType;
		@JsonProperty("CarryFwrdLeaveYearly")
		private String carryFwrdLeaveYearly;
		@JsonProperty("LeaveCarryFwrdId")
		private int leaveCarryFwrdId;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class TotalPLCarryForwardYearly {
		@JsonProperty("AssociateTypeId")
		private int associateTypeId;
		@JsonProperty("AssociateType")
		private String associateType;
		@JsonProperty("TotalFwrdLeaveYearly")
		private String totalFwrdLeaveYearly;
		@JsonProperty("TotalLeaveCarryFwrdId")
		private int totalLeaveCarryFwrdId;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class MonthlyWorkingHours {
		@JsonProperty("AssociateTypeId")
		private int associateTypeId;
		@JsonProperty("AssociateType")
		private String associateType;
		@JsonProperty("MonthlyWorkingHrs")
		private String monthlyWorkingHrs;
		@JsonProperty("WorkingHourId")
		private int workingHourId;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class MaximumContinuousLeaves {
		@JsonProperty("AssociateTypeId")
		private int associateTypeId;
		@JsonProperty("AssociateType")
		private String associateType;
		@JsonProperty("ContinuousLeave")
		private String continuousLeave;
		@JsonProperty("ContinuousLeaveId")
		private int continuousLeaveId;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class MaternityLeaves {
		@JsonProperty("MaternityLeaveId")
		private int maternityLeaveId;
		@JsonProperty("LeaveDuration")
		private String leaveDuration;
		@JsonProperty("Value")
		private String value;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class CompOffDetails {
		@JsonProperty("CompOffLeaveAllocId")
		private int compOffLeaveAllocId;
		@JsonProperty("MinHour")
		private double minHour;
		@JsonProperty("MaxHour")
		private double maxHour;
		@JsonProperty("LeaveAllocation")
		private String leaveAllocation;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class ShortServiceDetails {
		@JsonProperty("ShtSerLeaveAllocId")
		private int shtSerLeaveAllocId;
		@JsonProperty("MinHour")
		private double minHour;
		@JsonProperty("MaxHour")
		private double maxHour;
		@JsonProperty("LeaveAllocation")
		private String leaveAllocation;
	}
}
