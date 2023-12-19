package hu.cubix.logistics.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cubix.logistics.model.Milestone;
import hu.cubix.logistics.repository.MilestoneRepository;
import jakarta.transaction.Transactional;

@Service
public class MilestoneService {

	@Autowired
	MilestoneRepository milestoneRepository;

	public Optional<Milestone> findById(long milestoneId){
		return milestoneRepository.findById(milestoneId);
	}

	@Transactional
	public Milestone create(Milestone milestone)
	{
		return save(milestone);
	}

	@Transactional
	public Milestone save(Milestone milestone) {

		return milestoneRepository.save(milestone);
	}

}
