package org.home.sample.service;

import java.util.stream.Stream;

import org.home.sample.model.request.SearchFlightRequest;
import org.home.sample.model.response.SearchFlightResponse;

public interface SearchFlightService {
	
	public Stream<SearchFlightResponse> findAvailableFlights (SearchFlightRequest request);

}
