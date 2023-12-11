package hu.cubix.logistics.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import hu.cubix.logistics.dto.MilestoneDto;
import hu.cubix.logistics.model.Milestone;

@Mapper(componentModel = "spring")
public interface MilestoneMapper {

	public Milestone dtoToMilestone(MilestoneDto milestoneDto);

	public MilestoneDto milestoneToDto(Milestone milestone);

	public List<Milestone> dtoListToMilestone(List<MilestoneDto> milestoneDtos);

	public List<MilestoneDto> milestoneListToDto(List<Milestone> milestones);


}
