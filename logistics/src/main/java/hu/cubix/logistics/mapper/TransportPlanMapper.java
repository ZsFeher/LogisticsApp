package hu.cubix.logistics.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import hu.cubix.logistics.dto.SectionDto;
import hu.cubix.logistics.dto.TransportPlanDto;
import hu.cubix.logistics.model.Section;
import hu.cubix.logistics.model.TransportPlan;

@Mapper(componentModel = "spring")
public interface TransportPlanMapper {

	public TransportPlan dtoToTransportPlan(TransportPlanDto transportPlanDto);

	public TransportPlanDto transportPlanToDto(TransportPlan transportPlan);

	public List<TransportPlan> dtoListToTransportPlan(List<TransportPlanDto> transportPlanDtoList);

	public List<TransportPlanDto> transportPlanListToDto(List<TransportPlan> transportPlanList);

	@Mapping(target = "transportPlan", ignore = true)
	public Section dtoToSection(SectionDto sectionDto);

	@Mapping(target = "transportPlan", ignore = true)
	public SectionDto sectionToDto(Section section);


}
