package hu.cubix.logistics.dto;

import java.util.List;

import hu.cubix.logistics.model.Milestone;

public class AddressDto {

	private int addressId;
	private String isoCode;
	private String city;
	private String street;
	private int houseNumber;
	private int zipCode;
	private int latitude;
	private int longitude;

	private List<MilestoneDto> milestones;

	public AddressDto(String isoCode, String city, String street, int houseNumber, int zipCode, int latitude, int longitude, List<MilestoneDto> milestones) {
		this.isoCode = isoCode;
		this.city = city;
		this.street = street;
		this.houseNumber = houseNumber;
		this.zipCode = zipCode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.milestones = milestones;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
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

	public List<MilestoneDto> getMilestones() {
		return milestones;
	}

	public void setMilestones(List<MilestoneDto> milestones) {
		this.milestones = milestones;
	}

}
