package hu.cubix.logistics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.cubix.logistics.model.Address;
import hu.cubix.logistics.repository.AddressRepository;

@Service
public class InitDbService {

	@Autowired
	AddressRepository addressRepository;

	public void clearDB()
	{
		addressRepository.deleteAllInBatch();
	}

	public void insertTestData()
	{
		Address address1 = new Address("HU", "Békéscsaba", "Fő út", 4, 5600, 12000, 24000);
		Address address2 = new Address("HU", "Szeged", "Kárász utca", 777, 6722, 14000, 22000);

		addressRepository.save(address1);
		addressRepository.save(address2);
	}

}
