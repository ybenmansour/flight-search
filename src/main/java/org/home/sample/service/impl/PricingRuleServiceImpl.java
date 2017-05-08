package org.home.sample.service.impl;

import java.util.List;
import java.util.stream.Stream;

import org.home.sample.model.Flight;
import org.home.sample.model.PricingRules;
import org.home.sample.model.request.SearchFlightRequest;
import org.home.sample.predicate.PricingRulesPredicate;
import org.home.sample.service.PricingRuleService;
import org.home.sample.util.MathOperation;

public class PricingRuleServiceImpl implements PricingRuleService {
	
	private List<PricingRules> pricingRules;

	public PricingRuleServiceImpl(List<PricingRules> pricingRules) {
		super();
		this.pricingRules = pricingRules;
	}
	
	public Stream<Flight> flightsWithPricingRules (Stream<Flight> flights, SearchFlightRequest request) {
		PricingRules pricingRule = PricingRulesPredicate.filterPricingRules(pricingRules, PricingRulesPredicate.percentageAvailable(request.getDaysTo())).findFirst().get();
		
		return flights.map(flight -> 
		new Flight (flight.getOrigin(), flight.getDestination(), flight.getFlightNumber(), MathOperation.calculePrice(flight.getBasePrice(), pricingRule.getPercentage())));
	}
	

}
