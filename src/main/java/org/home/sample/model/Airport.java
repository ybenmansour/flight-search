package org.home.sample.model;

import java.io.Serializable;
import java.util.List;

public class Airport implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String iatacode;
	
	private String city;
	
	
	public Airport(String iatacode, String city) {
		super();
		this.iatacode = iatacode;
		this.city = city;
	}

	public Airport(List<Object> params) {
		super();
		this.iatacode = String.valueOf(params.get(0));
		this.city = String.valueOf(params.get(1));
	}

	public String getIatacode() {
		return iatacode;
	}

	public void setIatacode(String iatacode) {
		this.iatacode = iatacode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Airport [iatacode=" + iatacode + ", city=" + city + "]";
	}
	
}
