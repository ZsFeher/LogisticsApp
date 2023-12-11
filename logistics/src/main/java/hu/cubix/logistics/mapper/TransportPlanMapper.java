package hu.cubix.logistics.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import hu.cubix.logistics.dto.TransportPlanDto;
import hu.cubix.logistics.model.TransportPlan;

@Mapper(componentModel = "spring")
public interface TransportPlanMapper {

	public TransportPlan dtoToTransportPlan(TransportPlanDto transportPlanDto);

	public TransportPlanDto transportPlanToDto(TransportPlan transportPlan);

	public List<TransportPlan> dtoListToTransportPlan(List<TransportPlanDto> transportPlanDtoList);

	public List<TransportPlanDto> transportPlanListToDto(List<TransportPlan> transportPlanList);

}
