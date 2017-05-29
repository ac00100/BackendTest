package com.backend.test.dto;

import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.annotation.JsonProperty;

@ComponentScan
public class GeoLocation {
	private String lat;
	private String lng;
	
	/**
	 * @param lat
	 * @param lng
	 */
	public GeoLocation(@JsonProperty("lat") String lat, @JsonProperty("lng") String lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}
	/**
	 * @return the lat
	 */
	public String getLat() {
		return lat;
	}
	/**
	 * @param lat the lat to set
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}
	
	/**
	 * @return the lng
	 */
	public String getLng() {
		return lng;
	}
	/**
	 * @param lng the lng to set
	 */
	public void setLng(String lng) {
		this.lng = lng;
	}
}
