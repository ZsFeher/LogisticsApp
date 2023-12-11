package hu.cubix.logistics.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Milestone {

	@Id
	@GeneratedValue
	private long milestoneId;

	@ManyToOne
	private Address address;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
	private LocalDateTime plannedTime;

	public Milestone() {
	}

	public Milestone(Address address, LocalDateTime plannedTime) {
		this.address = address;
		this.plannedTime = plannedTime;
	}

	public long getMilestoneId() {
		return milestoneId;
	}

	public void setMilestoneId(long milestoneId) {
		this.milestoneId = milestoneId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public LocalDateTime getPlannedTime() {
		return plannedTime;
	}

	public void setPlannedTime(LocalDateTime plannedTime) {
		this.plannedTime = plannedTime;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Milestone milestone = (Milestone) o;
		return milestoneId == milestone.milestoneId && Objects.equals(address, milestone.address) && Objects.equals(plannedTime, milestone.plannedTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(milestoneId, address, plannedTime);
	}

	@Override
	public String toString() {
		return "Milestone{" +
				"milestoneId=" + milestoneId +
				", address=" + address +
				", plannedTime=" + plannedTime +
				'}';
	}
}
