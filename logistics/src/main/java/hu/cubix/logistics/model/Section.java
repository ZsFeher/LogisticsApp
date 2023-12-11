package hu.cubix.logistics.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Section {


	@Id
	@GeneratedValue
	private long sectionId;

	@OneToOne
	private Milestone startMileStone;

	@OneToOne
	private Milestone endMilestone;


	private int sectionOrder;

	@ManyToOne
	private TransportPlan transportPlan;

	public Section() {
	}

	public Section(Milestone startMileStone, Milestone endMilestone, int sectionOrder) {
		this.startMileStone = startMileStone;
		this.endMilestone = endMilestone;
		this.sectionOrder = sectionOrder;
	}

	public long getSectionId() {
		return sectionId;
	}

	public void setSectionId(long sectionId) {
		this.sectionId = sectionId;
	}

	public Milestone getStartMileStone() {
		return startMileStone;
	}

	public void setStartMileStone(Milestone startMileStone) {
		this.startMileStone = startMileStone;
	}

	public Milestone getEndMilestone() {
		return endMilestone;
	}

	public void setEndMilestone(Milestone endMilestone) {
		this.endMilestone = endMilestone;
	}

	public int getSectionOrder() {
		return sectionOrder;
	}

	public void setSectionOrder(int sectionOrder) {
		this.sectionOrder = sectionOrder;
	}

	public TransportPlan getTransportPlan() {
		return transportPlan;
	}

	public void setTransportPlan(TransportPlan transportPlan) {
		this.transportPlan = transportPlan;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Section section = (Section) o;
		return sectionId == section.sectionId && sectionOrder == section.sectionOrder && Objects.equals(startMileStone, section.startMileStone) && Objects.equals(endMilestone, section.endMilestone);
	}

	@Override
	public int hashCode() {
		return Objects.hash(sectionId, startMileStone, endMilestone, sectionOrder);
	}

	@Override
	public String toString() {
		return "Section{" +
				"startMileStone=" + startMileStone +
				", endMilestone=" + endMilestone +
				", sectionOrder=" + sectionOrder +
				'}';
	}
}
