package hu.cubix.logistics.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private long addressId;
	private String isoCode;
	private String city;
	private String street;
	private int houseNumber;
	private int zipCode;
	private int latitude;
	private int longitude;

	@OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
	private List<Milestone> milestones;

	public Address() {
	}

	public Address(String isoCode, String city, String street, int houseNumber, int zipCode, int latitude, int longitude) {
		this.isoCode = isoCode;
		this.city = city;
		this.street = street;
		this.houseNumber = houseNumber;
		this.zipCode = zipCode;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Address address = (Address) o;
		return addressId == address.addressId && houseNumber == address.houseNumber && zipCode == address.zipCode && latitude == address.latitude && longitude == address.longitude && Objects.equals(isoCode, address.isoCode) && Objects.equals(city, address.city) && Objects.equals(street, address.street);
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressId, isoCode, city, street, houseNumber, zipCode, latitude, longitude);
	}

	@Override
	public String toString() {
		return "Address{" +
				"addressId=" + addressId +
				", isoCode='" + isoCode + '\'' +
				", city='" + city + '\'' +
				", street='" + street + '\'' +
				", houseNumber=" + houseNumber +
				", zipCode=" + zipCode +
				", latitude=" + latitude +
				", longitude=" + longitude +
				'}';
	}
}
