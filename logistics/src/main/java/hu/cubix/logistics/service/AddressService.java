package hu.cubix.logistics.service;

import static hu.cubix.logistics.service.AddressSpecification.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import hu.cubix.logistics.dto.AddressDto;
import hu.cubix.logistics.model.Address;
import hu.cubix.logistics.repository.AddressRepository;
import jakarta.transaction.Transactional;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;

	public List<Address> getAll(){

		return addressRepository.findAll();
	}

	public Optional<Address> findById(long id)
	{
		return addressRepository.findById(id);
	}

	@Transactional
	public Address create(Address address)
	{
		return save(address);
	}

	@Transactional
	public Address save(Address address) {

		return addressRepository.save(address);
	}

	@Transactional
	public void delete(long id) {

		addressRepository.deleteById(id);
	}

	@Transactional
	public Address update(Address address) {
		if (!addressRepository.existsById(address.getAddressId())) {
			return null;
		} else {
			return addressRepository.save(address);
		}
	}

	public List<Address> searchAddress(Address example)
	{
		long id = example.getAddressId();
		String country = example.getIsoCode();
		String city = example.getCity();
		int zipCode = example.getZipCode();
		String street = example.getStreet();

		Specification<Address> specification = Specification.where(null);

		if(id > 0){
			specification = specification.and(hasId(id));
		}

		if(StringUtils.hasText(country)){
			specification = specification.and(isoCodeEquals(country));
		}

		if(StringUtils.hasText(city)){
			specification = specification.and(cityStartsWith(city));
		}

		if(zipCode > 0){
			specification = specification.and(zipCodeEquals(zipCode));
		}

		if(StringUtils.hasText(street)){
			specification = specification.and(streetStartsWith(street));
		}

		return addressRepository.findAll(specification);

	}

}
