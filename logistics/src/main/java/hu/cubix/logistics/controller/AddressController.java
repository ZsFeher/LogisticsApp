package hu.cubix.logistics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.cubix.logistics.dto.AddressDto;
import hu.cubix.logistics.mapper.AddressMapper;
import hu.cubix.logistics.model.Address;
import hu.cubix.logistics.service.AddressService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/addresses")
public class AddressController {

	@Autowired
	AddressService addressService;

	@Autowired
	AddressMapper addressMapper;

	@GetMapping
	public List<AddressDto> listEmployees()
	{
		List<Address> addresses = addressService.getAll();
		return addressMapper.addressToDtoList(addresses);
	}

	@GetMapping("/{id}")
	public AddressDto getAddressById(@PathVariable long id)
	{
		Address address = findByIdOrThrow(id);
		return addressMapper.addressToDto(address);
	}

	@PostMapping
	public ResponseEntity<Long> addAddress(@RequestBody @Valid AddressDto address)
	{
		Address a1 = addressMapper.dtoToAddress(address);

		if(address == null || address.getAddressId() > 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		Address createdAddress = addressService.create(a1);
		return ResponseEntity.ok(createdAddress.getAddressId()); //TODO json-ben
	}

	@DeleteMapping("/{id}")
	public void deleteAddress(@PathVariable long id)
	{
		addressService.delete(id);
	}

	private Address findByIdOrThrow(long id) {
		return addressService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}
