package org.home.sample.model.response;

import java.io.Serializable;

public class SearchFlightResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String flightCode;
	
	private double totalPrice;
	

	public SearchFlightResponse(String flightCode, double totalPrice) {
		super();
		this.flightCode = flightCode;
		this.totalPrice = totalPrice;
	}


	public String getFlightCode() {
		return flightCode;
	}


	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	@Override
	public String toString() {
		return "SearchFlightResponse [flightCode=" + flightCode + ", totalPrice=" + totalPrice + "]";
	}
	
}
