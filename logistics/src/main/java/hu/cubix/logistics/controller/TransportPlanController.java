package hu.cubix.logistics.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.cubix.logistics.dto.TransportPlanDto;
import hu.cubix.logistics.mapper.TransportPlanMapper;
import hu.cubix.logistics.model.Milestone;
import hu.cubix.logistics.model.Section;
import hu.cubix.logistics.model.TransportPlan;
import hu.cubix.logistics.service.MilestoneService;
import hu.cubix.logistics.service.TransportPlanService;

@RestController
@RequestMapping("api/transportPlans")
public class TransportPlanController {

	@Autowired
	TransportPlanService transportPlanService;

	@Autowired
	MilestoneService milestoneService;

	@Autowired
	TransportPlanMapper transportPlanMapper;

	@PostMapping("/{id}/delay")
	public TransportPlanDto addDelay(@PathVariable long id, @RequestBody Map<String, Long> delay){

		long mileStoneId = delay.get("mileStoneId");
		long delayInMinutes = delay.get("delay");

		//check existence
		TransportPlan tp = transportPlanService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		Milestone ms = milestoneService.findById(mileStoneId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		//check if ms included
		Section section = transportPlanService.checkMilestoneIncludedInSection(id,mileStoneId);

		if(section == null){
			new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		TransportPlan t = transportPlanService.addDelay(tp,section,ms,delayInMinutes);

		return transportPlanMapper.transportPlanToDto(t); //200 ok
	}

	@PostMapping
	public ResponseEntity<Long> addTransportPlan(@RequestBody TransportPlanDto transportPlanDto)
	{
		TransportPlan transportPlan = transportPlanMapper.dtoToTransportPlan(transportPlanDto);

		if(transportPlan == null || transportPlan.getTransportPlanId() > 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		TransportPlan createdTP = transportPlanService.create(transportPlan);
		return ResponseEntity.ok(createdTP.getTransportPlanId());
	}
}
