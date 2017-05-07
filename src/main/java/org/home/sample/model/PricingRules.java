package org.home.sample.model;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class PricingRules implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer from;
	
	private Integer to;
	
	private Double percentage;
	
	
	public PricingRules(Integer from, Integer to, Double percentage) {
		super();
		this.from = from;
		this.to = to;
		this.percentage = percentage;
	}

	public PricingRules(List<Object> params) {
		super();
		
		Optional<String> ostr = Optional.ofNullable(String.valueOf(params.get(1))).filter(s -> !s.isEmpty());
		ostr.ifPresent(value -> this.to = Integer.valueOf(value));
		
		this.from = Integer.valueOf(String.valueOf(params.get(0)));
		this.percentage = Double.valueOf(String.valueOf(params.get(2)));
	}


	public Integer getFrom() {
		return from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}

	public Integer getTo() {
		return to;
	}

	public void setTo(Integer to) {
		this.to = to;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}


	@Override
	public String toString() {
		return "PricingRules [from=" + from + ", to=" + to + ", percentage=" + percentage + "]";
	}
	
}
