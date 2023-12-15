package hu.cubix.logistics.dto;

import java.util.List;

import hu.cubix.logistics.model.Milestone;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class AddressDto {

	private long addressId;
	@NotEmpty
	private String isoCode;
	@NotEmpty
	private String city;
	@NotEmpty
	private String street;
	@Positive
	@NotNull
	private int houseNumber;
	@Positive
	@NotNull
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

	public List<MilestoneDto> getMilestones() {
		return milestones;
	}

	public void setMilestones(List<MilestoneDto> milestones) {
		this.milestones = milestones;
	}

}
