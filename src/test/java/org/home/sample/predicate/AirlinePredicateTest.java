package org.home.sample.predicate;

import java.util.ArrayList;
import java.util.List;

import org.home.sample.model.Airline;
import org.junit.Assert;
import org.junit.Test;

public class AirlinePredicateTest {
	
	@Test
	public void testAirlinePrecicate () {
		List<Airline> airlines = new ArrayList<Airline>();
		airlines.add(new Airline("IB", "Iberia", 5.0));
		airlines.add(new Airline("TK", "Turkish Airlines", 8.72));
		
		Assert.assertTrue(AirlinePredicate.filterAirlines(airlines, AirlinePredicate.existsAirline("IB")).isEmpty());
	}

}
