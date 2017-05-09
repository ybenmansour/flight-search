package org.home.sample.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.home.sample.model.Airline;
import org.home.sample.model.Flight;
import org.home.sample.model.request.SearchFlightRequest;
import org.home.sample.model.response.SearchFlightResponse;
import org.home.sample.predicate.AirlinePredicate;
import org.home.sample.service.PassengerTypeService;
import org.home.sample.util.MathOperation;

public class PassengerTypeServiceImpl implements PassengerTypeService {
	
	private List<Airline> airlines;
	
	public PassengerTypeServiceImpl (List<Airline> airlines) {
		super();
		this.airlines = airlines;
	}
	
	public Stream<SearchFlightResponse> applyPriceToPassenger (Stream<Flight> flights, SearchFlightRequest request) {
		
		List<SearchFlightResponse> response = new ArrayList<SearchFlightResponse>();
		
		flights.forEach(flight -> {
			double totalPrice = calculePriceAdult(flight, request.getNumAdults()) + 
					calculePriceChild(flight, request.getNumChildren()) +
					calculePriceInfant(flight, request.getNumInfants());
			
					try {
						response.add(new SearchFlightResponse(flight.getFlightNumber(), MathOperation.formatPrice(totalPrice)));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		});
		
		return response.stream();
		
	}
	
	
	private double calculePriceAdult (Flight flight, int numAdults) {
		return flight.getBasePrice() * numAdults;
	}
	
	private double calculePriceChild (Flight flight, int numChildren) {
		return flight.getBasePrice() * numChildren * MathOperation.CHILD_DISCOUNT ;
	}
	
	private double calculePriceInfant (Flight flight, int numInfants) {
		Airline airline = AirlinePredicate.filterAirlines(this.airlines,AirlinePredicate.existsAirline(flight.getFlightNumber().substring(0, 2))).findFirst().get();
		return airline.getInfantPrice() * numInfants;
	}
}
