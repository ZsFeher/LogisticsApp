package hu.cubix.logistics.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import hu.cubix.logistics.dto.SectionDto;
import hu.cubix.logistics.model.Section;

@Mapper(componentModel = "spring")
public interface SectionMapper {

	public Section dtoToSection(SectionDto sectionDto);

	public SectionDto sectionToDto(Section section);

	public List<Section> dtoListToSection(List<SectionDto> sectionDtoList);

	public List<SectionDto> sectionListToDto(List<Section> sectionList);

}
