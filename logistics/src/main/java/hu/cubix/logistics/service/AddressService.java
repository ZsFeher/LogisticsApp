package hu.cubix.logistics.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
