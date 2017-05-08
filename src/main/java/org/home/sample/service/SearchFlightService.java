package org.home.sample.service;

import java.util.List;

import org.home.sample.model.request.SearchFlightRequest;
import org.home.sample.model.response.SearchFlightResponse;

public interface SearchFlightService {
	
	public List<SearchFlightResponse> findAvailableFlights (SearchFlightRequest request);

}
