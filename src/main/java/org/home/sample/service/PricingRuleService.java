package org.home.sample.service;

import java.util.stream.Stream;

import org.home.sample.model.Flight;
import org.home.sample.model.request.SearchFlightRequest;

public interface PricingRuleService {
	
	public Stream<Flight> flightsWithPricingRules (Stream<Flight> flights, SearchFlightRequest request);

}
