package org.home.sample.predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.home.sample.model.Flight;

public class FlightPredicate {
	
	public static Predicate<Flight> existsOriginAndDestination (String origin, String destination) {
		return flight -> flight.getOrigin().equalsIgnoreCase(origin) 
				&& flight.getDestination().equalsIgnoreCase(destination); 
	}
	
	public static Predicate<Flight> existsAirline (String code) {
		return flight -> flight.getFlightNumber().startsWith(code); 
	}
	
	public static Stream<Flight> filterFlights (List<Flight> flights, Predicate<Flight> predicate) {
        return flights.stream().filter(predicate);
    }

}
