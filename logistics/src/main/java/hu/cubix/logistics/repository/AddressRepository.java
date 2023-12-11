package hu.cubix.logistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.cubix.logistics.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
