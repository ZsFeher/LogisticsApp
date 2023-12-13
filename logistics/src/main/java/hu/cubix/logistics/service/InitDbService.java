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
		Address address1 = new Address("HU", "Békéscsaba", "Kazinczy út", 777, 5600, 12000, 24000);
		Address address2 = new Address("HU", "Szeged", "Kárász utca", 777, 6722, 14000, 22000);
		Address address3 = new Address("NO", "Krinstiansand", "Park veien", 777, 13653, 30000, 30000);
		Address address4 = new Address("SE", "Malmö", "Rundelsgatan", 777, 24555, 23000, 23000);
		Address address5 = new Address("NO", "Krinstiansand", "Sommer gata", 777, 13652, 30000, 30000);

		addressRepository.save(address1);
		addressRepository.save(address2);
		addressRepository.save(address3);
		addressRepository.save(address4);
		addressRepository.save(address5);
	}

}
