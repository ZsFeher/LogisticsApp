package hu.cubix.logistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.cubix.logistics.dto.MilestoneDto;
import hu.cubix.logistics.mapper.MilestoneMapper;
import hu.cubix.logistics.model.Milestone;
import hu.cubix.logistics.service.MilestoneService;

@RestController
@RequestMapping("api/milestones")
public class MileStoneController {

	@Autowired
	MilestoneMapper mapper;

	@Autowired
	MilestoneService milestoneService;

	@PostMapping
	public ResponseEntity<Long> addMilestone(@RequestBody MilestoneDto milestoneDto)
	{
		Milestone milestone = mapper.dtoToMilestone(milestoneDto);

		if(milestone == null || milestone.getMilestoneId() > 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		Milestone createdmilestone = milestoneService.create(milestone);
		return ResponseEntity.ok(createdmilestone.getMilestoneId());
	}
}
