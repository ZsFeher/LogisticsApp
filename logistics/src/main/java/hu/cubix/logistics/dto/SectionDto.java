package hu.cubix.logistics.dto;

import hu.cubix.logistics.model.Milestone;
import hu.cubix.logistics.model.TransportPlan;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class SectionDto {

	private long sectionId;
	private MilestoneDto startMileStone;
	private MilestoneDto endMilestone;
	private int sectionOrder;
	private TransportPlanDto transportPlan;

	public SectionDto(MilestoneDto startMileStone, MilestoneDto endMilestone, int sectionOrder, TransportPlanDto transportPlan) {
		this.startMileStone = startMileStone;
		this.endMilestone = endMilestone;
		this.sectionOrder = sectionOrder;
		this.transportPlan = transportPlan;
	}

	public long getSectionId() {
		return sectionId;
	}

	public void setSectionId(long sectionId) {
		this.sectionId = sectionId;
	}

	public MilestoneDto getStartMileStone() {
		return startMileStone;
	}

	public void setStartMileStone(MilestoneDto startMileStone) {
		this.startMileStone = startMileStone;
	}

	public MilestoneDto getEndMilestone() {
		return endMilestone;
	}

	public void setEndMilestone(MilestoneDto endMilestone) {
		this.endMilestone = endMilestone;
	}

	public int getSectionOrder() {
		return sectionOrder;
	}

	public void setSectionOrder(int sectionOrder) {
		this.sectionOrder = sectionOrder;
	}

	public TransportPlanDto getTransportPlan() {
		return transportPlan;
	}

	public void setTransportPlan(TransportPlanDto transportPlan) {
		this.transportPlan = transportPlan;
	}


}
