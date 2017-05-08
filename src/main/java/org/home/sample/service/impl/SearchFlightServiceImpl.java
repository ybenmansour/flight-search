package org.home.sample.service.impl;

import java.util.List;
import java.util.stream.Stream;

import org.home.sample.model.Flight;
import org.home.sample.model.request.SearchFlightRequest;
import org.home.sample.model.response.SearchFlightResponse;
import org.home.sample.predicate.FlightPredicate;
import org.home.sample.service.PassengerTypeService;
import org.home.sample.service.PricingRuleService;
import org.home.sample.service.SearchFlightService;

public class SearchFlightServiceImpl implements SearchFlightService {
	
	private List<Flight> flights;
	
	private PricingRuleService pricingRuleService;
	
	private PassengerTypeService passengerTypeService;
	

	public SearchFlightServiceImpl(List<Flight> flights, PricingRuleService pricingRuleService,
			PassengerTypeService passengerTypeService) {
		super();
		this.flights = flights;
		this.pricingRuleService = pricingRuleService;
		this.passengerTypeService = passengerTypeService;
	}


	public List<SearchFlightResponse> findAvailableFlights (SearchFlightRequest request) {
		List<SearchFlightResponse> results = null;
		
		Stream<Flight> availableflights = FlightPredicate.filterFlights(flights, FlightPredicate.existsOriginAndDestination(request.getFrom(), request.getTo()));
		Stream<Flight> availableflightsWithPriceUpdated = pricingRuleService.flightsWithPricingRules(availableflights, request);
		results = passengerTypeService.applyPriceToPassenger(availableflightsWithPriceUpdated, request);
		
		return results;
	}

}
