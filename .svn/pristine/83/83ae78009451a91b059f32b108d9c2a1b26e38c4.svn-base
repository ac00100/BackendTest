package com.backend.test.dto;

import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.annotation.JsonProperty;

@ComponentScan
public class AddressBlock {
	private Address address;
	private double distance;
	private String type;

	/**
	 * @param address
	 * @param distance
	 * @param type
	 */
	public AddressBlock(@JsonProperty("address") Address address, @JsonProperty("distance") double distance,
			@JsonProperty("type") String type) {
		super();
		this.address = address;
		this.distance = distance;
		this.type = type;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * @param distance
	 *            the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
