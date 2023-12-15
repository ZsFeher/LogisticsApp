package hu.cubix.logistics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@PutMapping("/{id}")
	public AddressDto updateAddress(@PathVariable long id, @RequestBody @Valid AddressDto addressDto)
	{
		if (addressDto == null || id != addressDto.getAddressId()){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		Address address = findByIdOrThrow(id);

		Address ad1 = addressMapper.dtoToAddress(addressDto);
		Address updatedAddress = addressService.update(ad1);

		return addressMapper.addressToDto(updatedAddress);
	}

	@PostMapping("/search")
	public ResponseEntity searchAddress(@RequestParam(required = false, value = "pageNumParam", defaultValue = "-1") int pageNumParam,
										  @RequestParam(required = false, value = "pageSizeParam", defaultValue = "0") int pageSizeParam,
										  @RequestParam(required = false, value = "sortByParam") String sortByParam,
										  @RequestBody AddressDto example)
	{
		if(example == null){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		int pageNum = pageNumParam > -1 ? pageNumParam : 0;
		int pageSize = pageSizeParam > 0 ? pageSizeParam : Integer.MAX_VALUE;

		String sortBy = "addressId";
		Sort.Direction sortOrder = Sort.Direction.ASC;

		if(sortByParam != null) {

			String[] orderParams = sortByParam.split(",");

			if (orderParams.length == 2) {
				sortBy = orderParams[0];
				sortOrder = Sort.Direction.fromString(orderParams[1]);
			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
		}
		Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(sortOrder,sortBy));

		Page<Address> page = addressService.searchAddress(example,pageable);

		HttpHeaders headers = new HttpHeaders() {
			{
				add("X-Total-Count", String.valueOf(page.getTotalElements()));
			}
		};
		return new ResponseEntity<>(page, headers, HttpStatus.OK);

	}

	private Address findByIdOrThrow(long id) {
		return addressService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}
