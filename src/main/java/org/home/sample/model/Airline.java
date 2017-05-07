package org.home.sample.model;

import java.io.Serializable;
import java.util.List;

public class Airline implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String iataCode;
	
	private String name;
	
	private Double infantPrice;
	
	
	public Airline(String iataCode, String name, Double infantPrice) {
		super();
		this.iataCode = iataCode;
		this.name = name;
		this.infantPrice = infantPrice;
	}

	public Airline(List<Object> params) {
		super();
		this.iataCode = String.valueOf(params.get(0));
		this.name = String.valueOf(params.get(1));
		this.infantPrice = Double.valueOf(String.valueOf(params.get(2)));
	}

	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getInfantPrice() {
		return infantPrice;
	}

	public void setInfantPrice(Double infantPrice) {
		this.infantPrice = infantPrice;
	}

	@Override
	public String toString() {
		return "Airline [iataCode=" + iataCode + ", name=" + name + ", infantPrice=" + infantPrice + "]";
	}
	
}
