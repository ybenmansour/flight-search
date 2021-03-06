package org.home.sample.predicate;

import java.util.ArrayList;
import java.util.List;

import org.home.sample.model.Airport;
import org.junit.Assert;
import org.junit.Test;

public class AirportPredicateTest {
	
	@Test
	public void testAirportPrecicate () {
		List<Airport> airports = new ArrayList<Airport>();
		airports.add(new Airport("IST", "Istanbul"));
		airports.add(new Airport("LHR", "TLondon"));
		
		Assert.assertTrue("The airport code doesn't exist",AirportPredicate.filterAirports(airports, AirportPredicate.existsAirport("IST")).findFirst().isPresent());
	}

}
