package org.home.sample.predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.home.sample.model.Airport;

public class AirportPredicate {
	
	public static Predicate<Airport> existsAirport (String code) {
		return airport -> airport.getIatacode().startsWith(code); 
	}
	
	public static List<Airport> filterAirports (List<Airport> airports, Predicate<Airport> predicate) {
        return airports.stream().filter(predicate).collect(Collectors.<Airport>toList());
    }

}
