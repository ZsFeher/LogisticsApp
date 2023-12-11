package hu.cubix.logistics.dto;

import java.time.LocalDateTime;

import hu.cubix.logistics.model.Address;

public class MilestoneDto {

	private long milestoneId;
	private AddressDto address;
	private LocalDateTime plannedTime;

	public MilestoneDto(AddressDto address, LocalDateTime plannedTime) {
		this.address = address;
		this.plannedTime = plannedTime;
	}

	public long getMilestoneId() {
		return milestoneId;
	}

	public void setMilestoneId(long milestoneId) {
		this.milestoneId = milestoneId;
	}

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

	public LocalDateTime getPlannedTime() {
		return plannedTime;
	}

	public void setPlannedTime(LocalDateTime plannedTime) {
		this.plannedTime = plannedTime;
	}

}
