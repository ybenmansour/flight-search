package org.home.sample.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.home.sample.model.Airline;
import org.home.sample.model.Airport;
import org.home.sample.model.Flight;
import org.home.sample.model.PricingRules;
import org.home.sample.model.request.SearchFlightRequest;
import org.home.sample.model.response.SearchFlightResponse;
import org.home.sample.service.PassengerTypeService;
import org.home.sample.service.PricingRuleService;
import org.home.sample.service.SearchFlightService;
import org.home.sample.service.impl.PassengerTypeServiceImpl;
import org.home.sample.service.impl.PricingRuleServiceImpl;
import org.home.sample.service.impl.SearchFlightServiceImpl;

public class CSVFileParser<E> {
	
	public List<E> readFile (URI uri, Class<E> clazz) throws NoSuchMethodException, SecurityException {
		Constructor<E> constructor = clazz.getConstructor(List.class);
		List<E> entities = new ArrayList<>();
		
		try (Stream<String> lines = Files.lines(Paths.get(uri))){
			List<List<String>> values = lines.map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());
			values.forEach(value -> {
				try {
					entities.add(constructor.newInstance(value));
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
		return entities;
	}
	
	public static void main (String[] args) {
		CSVFileParser<Airport> airportCSV = new CSVFileParser<Airport>();
		CSVFileParser<Airline> airlineCSV = new CSVFileParser<Airline>();
		CSVFileParser<Flight> flightCSV = new CSVFileParser<Flight>();
		CSVFileParser<PricingRules> pricingRulesCSV = new CSVFileParser<PricingRules>();
		
		try {
			List<Airport> airports = airportCSV.readFile(ClassLoader.getSystemResource("data/airports.csv").toURI(), Airport.class);
			List<Airline> airlines = airlineCSV.readFile(ClassLoader.getSystemResource("data/airlines.csv").toURI(), Airline.class);
			List<Flight> flights = flightCSV.readFile(ClassLoader.getSystemResource("data/flights.csv").toURI(), Flight.class);
			List<PricingRules> pricingRules = pricingRulesCSV.readFile(ClassLoader.getSystemResource("data/pricing-rules.csv").toURI(), PricingRules.class);
			
//			airports.forEach(val -> System.out.println(val));
//			airlines.forEach(val -> System.out.println(val));
//			flights.forEach(val -> System.out.println(val));
//			pricingRules.forEach(val -> System.out.println(val));
			
			
			PassengerTypeService passengerTypeService = new PassengerTypeServiceImpl(airlines);
			PricingRuleService pricingRuleService = new PricingRuleServiceImpl(pricingRules);
			SearchFlightService searchFlightService = new SearchFlightServiceImpl(flights, pricingRuleService, passengerTypeService);
			
			SearchFlightRequest request = new SearchFlightRequest("CDG", "FRA", 2, 1, 2, 0);
			
			Stream<SearchFlightResponse> response  = searchFlightService.findAvailableFlights(request);
			System.out.println(response.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
