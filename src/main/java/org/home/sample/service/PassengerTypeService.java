package org.home.sample.service;

import java.util.stream.Stream;

import org.home.sample.model.Flight;
import org.home.sample.model.request.SearchFlightRequest;
import org.home.sample.model.response.SearchFlightResponse;

public interface PassengerTypeService {
	
	public Stream<SearchFlightResponse> applyPriceToPassenger (Stream<Flight> flights, SearchFlightRequest request);

}
