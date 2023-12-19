package hu.cubix.logistics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.cubix.logistics.dto.SectionDto;
import hu.cubix.logistics.mapper.SectionMapper;
import hu.cubix.logistics.model.Section;
import hu.cubix.logistics.service.SectionService;

@RestController
@RequestMapping("api/sections")
public class SectionController {

	@Autowired
	SectionMapper mapper;

	@Autowired
	SectionService sectionservice;

	@PostMapping
	public ResponseEntity<Long> addSection(@RequestBody SectionDto sectionDto)
	{
		Section section = mapper.dtoToSection(sectionDto);

		if(section == null || section.getSectionId() > 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		Section createdsection = sectionservice.create(section);
		return ResponseEntity.ok(createdsection.getSectionId());
	}
}
