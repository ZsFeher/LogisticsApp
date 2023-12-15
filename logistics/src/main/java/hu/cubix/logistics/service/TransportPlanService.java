package hu.cubix.logistics.service;

import java.net.http.HttpRequest;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cubix.logistics.config.LogisticsConfig;
import hu.cubix.logistics.model.Milestone;
import hu.cubix.logistics.model.Section;
import hu.cubix.logistics.model.TransportPlan;
import hu.cubix.logistics.repository.MilestoneRepository;
import hu.cubix.logistics.repository.TransportPlanRepository;

@Service
public class TransportPlanService {

	@Autowired
	TransportPlanRepository transportPlanRepository;

	@Autowired
	MilestoneRepository milestoneRepository;

	@Autowired
	DelayService delayService;

	public TransportPlan addDelay(TransportPlan transportPlan, Section section, Milestone ms, long delayInMinutes){

		if(section.getStartMileStone().getMilestoneId() == ms.getMilestoneId()){ // milestone is a startmilestone

			Milestone endMileStone = section.getEndMilestone();

			ms.setPlannedTime(ms.getPlannedTime().plusMinutes(delayInMinutes));
			milestoneRepository.save(ms);
			endMileStone.setPlannedTime(endMileStone.getPlannedTime().plusMinutes(delayInMinutes));
			milestoneRepository.save(endMileStone);

		} else {	//milestone is an endmilestone

			ms.setPlannedTime(ms.getPlannedTime().plusMinutes(delayInMinutes));
			milestoneRepository.save(ms);

			Section nextSection = transportPlanRepository.findNextSection(transportPlan.getTransportPlanId(), section.getSectionOrder()+1);

			Milestone nextms = nextSection.getStartMileStone();

			nextms.setPlannedTime(nextms.getPlannedTime().plusMinutes(delayInMinutes));
			milestoneRepository.save(nextms);

		}

		double expectedIncome = transportPlan.getExpectedIncome()*((100-delayService.getDecreasingPercent(delayInMinutes))*0.01);
		transportPlan.setExpectedIncome(expectedIncome);
		transportPlanRepository.save(transportPlan);

		return transportPlan;
	}

	public Optional<TransportPlan> findById(long transportPlanId){
		return transportPlanRepository.findById(transportPlanId);
	}

	public Section checkMilestoneIncludedInSection(long transportId, long mileStoneId){

		return transportPlanRepository.findByMileStoneId(transportId,mileStoneId);
	}

}
