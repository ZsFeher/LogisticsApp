package hu.cubix.logistics.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cubix.logistics.model.Address;
import hu.cubix.logistics.model.Milestone;
import hu.cubix.logistics.model.Section;
import hu.cubix.logistics.model.TransportPlan;
import hu.cubix.logistics.repository.AddressRepository;
import hu.cubix.logistics.repository.MilestoneRepository;
import hu.cubix.logistics.repository.SectionRepository;
import hu.cubix.logistics.repository.TransportPlanRepository;

@Service
public class InitDbService {

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	MilestoneRepository milestoneRepository;

	@Autowired
	SectionRepository sectionRepository;

	@Autowired
	TransportPlanRepository transportPlanRepository;

	public void clearDB()
	{
		addressRepository.deleteAllInBatch();
	}

	public void insertTestData()
	{
		Address address1 = new Address("HU", "Békéscsaba", "Kazinczy út", 777, 5600, 12000, 24000);
		Address address2 = new Address("HU", "Szeged", "Kárász utca", 777, 6722, 14000, 22000);
		Address address3 = new Address("NO", "Krinstiansand", "Park veien", 777, 13653, 30000, 30000);
		Address address4 = new Address("SE", "Malmö", "Rundelsgatan", 777, 24555, 23000, 23000);
		Address address5 = new Address("NO", "Krinstiansand", "Sommer gata", 777, 13652, 30000, 30000);

		addressRepository.save(address1);
		addressRepository.save(address2);
		addressRepository.save(address3);
		addressRepository.save(address4);
		addressRepository.save(address5);

		TransportPlan tp1 = new TransportPlan(1000);

		transportPlanRepository.save(tp1);

		Milestone milestone1 = new Milestone(address1, LocalDateTime.of(2024,1,3, 10, 10));
		Milestone milestone2 = new Milestone(address2, LocalDateTime.of(2024,1,3, 12, 20));
		Milestone milestone3 = new Milestone(address3, LocalDateTime.of(2024,1,3, 15, 5));
		Milestone milestone4 = new Milestone(address4, LocalDateTime.of(2024,1,3, 16, 20));

		milestoneRepository.save(milestone1);
		milestoneRepository.save(milestone2);
		milestoneRepository.save(milestone3);
		milestoneRepository.save(milestone4);

		Section section1 = new Section(milestone1,milestone2,1);
		Section section2 = new Section(milestone3,milestone4,2);
		section1.setTransportPlan(tp1);
		section2.setTransportPlan(tp1);

		sectionRepository.save(section1);
		sectionRepository.save(section2);

	}

}
