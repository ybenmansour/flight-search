package org.home.sample.predicate;

import java.util.ArrayList;
import java.util.List;

import org.home.sample.model.Flight;
import org.junit.Assert;
import org.junit.Test;

public class FlightPredicateTest {
	
	@Test
	public void testFlightPredicate () {
		List<Flight> flights = new ArrayList<Flight>();
		flights.add(new Flight("LHR","FCO","LH5174",251.0));
		flights.add(new Flight("FRA","CPH","BA4369",109.6));
		flights.add(new Flight("AMS","CPH","TK4927",290.15));
		flights.add(new Flight("LHR","CDG","IB2771",289.07));
		
		Assert.assertTrue("The airline code doens't match any flight number",FlightPredicate.filterFlights(flights, FlightPredicate.existsAirline("RY")).findFirst().isPresent());
		
		Assert.assertTrue("There's no flight number for the origin and destination selected",FlightPredicate.filterFlights(flights, FlightPredicate.existsOriginAndDestination("AMS", "CPH")).findFirst().isPresent());
	}

}
