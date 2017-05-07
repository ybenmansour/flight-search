package org.home.sample.model;

import java.io.Serializable;
import java.util.List;


public class Flight implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String origin;
	
	private String destination;
	
	private String flightNumber;
	
	private Double basePrice;
	
	
	public Flight(String origin, String destination, String flightNumber,
			Double basePrice) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.flightNumber = flightNumber;
		this.basePrice = basePrice;
	}

	public Flight(List<Object> params) {
		super();
		this.origin = String.valueOf(params.get(0));
		this.destination = String.valueOf(params.get(1));
		this.flightNumber = String.valueOf(params.get(2));
		this.basePrice = Double.valueOf(String.valueOf(params.get(3)));
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}

	@Override
	public String toString() {
		return "Flight [origin=" + origin + ", destination=" + destination + ", flightNumber=" + flightNumber
				+ ", basePrice=" + basePrice + "]";
	}
	
}
