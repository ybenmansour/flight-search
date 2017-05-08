package org.home.sample.model.request;

import java.io.Serializable;

public class SearchFlightRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String from;
	
	private String to;
	
	private int daysTo;
	
	private int numAdults;
	
	private int numChildren;
	
	private int numInfants;
	
	
	public SearchFlightRequest(String from, String to, int daysTo, int numAdults, int numChildren, int numInfants) {
		super();
		this.from = from;
		this.to = to;
		this.daysTo = daysTo;
		this.numAdults = numAdults;
		this.numChildren = numChildren;
		this.numInfants = numInfants;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getDaysTo() {
		return daysTo;
	}

	public void setDaysTo(int daysTo) {
		this.daysTo = daysTo;
	}

	public int getNumAdults() {
		return numAdults;
	}

	public void setNumAdults(int numAdults) {
		this.numAdults = numAdults;
	}

	public int getNumChildren() {
		return numChildren;
	}

	public void setNumChildren(int numChildren) {
		this.numChildren = numChildren;
	}

	public int getNumInfants() {
		return numInfants;
	}

	public void setNumInfants(int numInfants) {
		this.numInfants = numInfants;
	}
	
}
