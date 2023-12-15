package hu.cubix.logistics.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TransportPlan {

	@Id
	@GeneratedValue
	private long transportPlanId;
	private double expectedIncome;

	@OneToMany(mappedBy = "transportPlan", fetch = FetchType.EAGER)
	private List<Section> sections;

	public TransportPlan() {
	}

	public TransportPlan(int expectedIncome) {
		this.expectedIncome = expectedIncome;
	}

	public long getTransportPlanId() {
		return transportPlanId;
	}

	public void setTransportPlanId(long transportPlanId) {
		this.transportPlanId = transportPlanId;
	}

	public double getExpectedIncome() {
		return expectedIncome;
	}

	public void setExpectedIncome(double expectedIncome) {
		this.expectedIncome = expectedIncome;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TransportPlan that = (TransportPlan) o;
		return transportPlanId == that.transportPlanId && expectedIncome == that.expectedIncome && Objects.equals(sections, that.sections);
	}

	@Override
	public int hashCode() {
		return Objects.hash(transportPlanId, expectedIncome, sections);
	}

	@Override
	public String toString() {
		return "TransportPlan{" +
				"expectedIncome=" + expectedIncome +
				", sections=" + sections +
				'}';
	}
}
