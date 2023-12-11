package hu.cubix.logistics.dto;

import java.util.List;

import hu.cubix.logistics.model.Section;

public class TransportPlanDto {

	private long transportPlanId;
	private int expectedIncome;
	private List<SectionDto> sections;

	public TransportPlanDto(int expectedIncome, List<SectionDto> sections) {
		this.expectedIncome = expectedIncome;
		this.sections = sections;
	}

	public long getTransportPlanId() {
		return transportPlanId;
	}

	public void setTransportPlanId(long transportPlanId) {
		this.transportPlanId = transportPlanId;
	}

	public int getExpectedIncome() {
		return expectedIncome;
	}

	public void setExpectedIncome(int expectedIncome) {
		this.expectedIncome = expectedIncome;
	}

	public List<SectionDto> getSections() {
		return sections;
	}

	public void setSections(List<SectionDto> sections) {
		this.sections = sections;
	}


}
