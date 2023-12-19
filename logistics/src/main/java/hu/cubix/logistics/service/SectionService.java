package hu.cubix.logistics.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cubix.logistics.model.Section;
import hu.cubix.logistics.repository.SectionRepository;
import jakarta.transaction.Transactional;

@Service
public class SectionService {

	@Autowired
	SectionRepository sectionRepository;

	public Optional<Section> findById(long sectionId){
		return sectionRepository.findById(sectionId);
	}
	@Transactional
	public Section create(Section section)
	{
		return save(section);
	}

	@Transactional
	public Section save(Section section) {

		return sectionRepository.save(section);
	}
}
