package hu.cubix.logistics.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import hu.cubix.logistics.dto.AddressDto;
import hu.cubix.logistics.dto.MilestoneDto;
import hu.cubix.logistics.model.Address;
import hu.cubix.logistics.model.Milestone;

@Mapper(componentModel = "spring")
public interface AddressMapper {

		public AddressDto addressToDto(Address address);

		public Address dtoToAddress(AddressDto addressDto);

		public List<AddressDto> addressToDtoList(List<Address> addressList);

		public List<Address> dtoListToAddress(List<AddressDto> addressDtoList);

		@Mapping(target = "address", ignore = true)
		public Milestone dtoToMilestone(MilestoneDto milestoneDto);

		@InheritInverseConfiguration
		public MilestoneDto milestoneToDto(Milestone milestone);
}
