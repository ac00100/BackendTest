package com.backend.test.dto;

import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.annotation.JsonProperty;

@ComponentScan
public class Address {
	private String street;
	private String housenumber;
	private String postalcode;
	private String city;
	private GeoLocation geoLocation;

	/**
	 * @param street
	 * @param housenumber
	 * @param postalcode
	 * @param city
	 * @param geoLocation
	 */
	public Address(@JsonProperty("street") String street, @JsonProperty("housenumber") String housenumber,
			@JsonProperty("postalcode") String postalcode, @JsonProperty("city") String city,
			@JsonProperty("geoLocation") GeoLocation geoLocation) {
		super();
		this.street = street;
		this.housenumber = housenumber;
		this.postalcode = postalcode;
		this.city = city;
		this.geoLocation = geoLocation;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the housenumber
	 */
	public String getHousenumber() {
		return housenumber;
	}

	/**
	 * @param housenumber
	 *            the housenumber to set
	 */
	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}

	/**
	 * @return the postalcode
	 */
	public String getPostalcode() {
		return postalcode;
	}

	/**
	 * @param postalcode
	 *            the postalcode to set
	 */
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the geoLocation
	 */
	public GeoLocation getGeoLocation() {
		return geoLocation;
	}

	/**
	 * @param geoLocation
	 *            the geoLocation to set
	 */
	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}

}
