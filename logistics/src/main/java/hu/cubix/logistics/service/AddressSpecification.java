package hu.cubix.logistics.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;

import hu.cubix.logistics.model.Address;
import hu.cubix.logistics.model.Address_;

public class AddressSpecification {

	public static Specification<Address> hasId(long id)
	{
		return (root, cq, cb) -> cb.equal(root.get(Address_.addressId), id);
	}
	public static Specification<Address> cityStartsWith(String city)
	{
		return (root, cq, cb) -> cb.like(root.get(Address_.city), city + "%"); //TODO check case-insensitive
	}

	public static Specification<Address> streetStartsWith(String street)
	{
		return (root, cq, cb) -> cb.like(root.get(Address_.street), street + "%"); //TODO check case-insensitive
	}

	public static Specification<Address> isoCodeEquals(String country)
	{
		return (root, cq, cb) -> cb.equal(root.get(Address_.isoCode), country);
	}

	public static Specification<Address> zipCodeEquals(int zipCode)
	{
		return (root, cq, cb) -> cb.equal(root.get(Address_.zipCode), zipCode);
	}

}
