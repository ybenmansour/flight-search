package org.home.sample.predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.home.sample.model.Airline;

public class AirlinePredicate {
	
	public static Predicate<Airline> existsAirline (String code) {
		return airline -> airline.getIataCode().equalsIgnoreCase(code); 
	}
	
	public static List<Airline> filterAirlines (List<Airline> airlines, Predicate<Airline> predicate) {
        return airlines.stream().filter(predicate).collect(Collectors.<Airline>toList());
    }
	

}
