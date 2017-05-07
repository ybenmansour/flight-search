package org.home;

import java.net.URISyntaxException;
import java.util.List;

import org.home.sample.model.Airline;
import org.home.sample.model.Airport;
import org.home.sample.model.Flight;
import org.home.sample.model.PricingRules;
import org.home.sample.util.CSVFileParser;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class FlightSearchApplicationTests {

	@Before
	public void loadData() throws Exception {
		
		CSVFileParser<Airport> airportCSV = new CSVFileParser<Airport>();
		CSVFileParser<Airline> airlineCSV = new CSVFileParser<Airline>();
		CSVFileParser<Flight> flightCSV = new CSVFileParser<Flight>();
		CSVFileParser<PricingRules> pricingRulesCSV = new CSVFileParser<PricingRules>();
		
		List<Airport> airports = airportCSV.readFile(ClassLoader.getSystemResource("data/airports.csv").toURI(), Airport.class);
		List<Airline> airlines = airlineCSV.readFile(ClassLoader.getSystemResource("data/airlines.csv").toURI(), Airline.class);
		List<Flight> flights = flightCSV.readFile(ClassLoader.getSystemResource("data/flights.csv").toURI(), Flight.class);
		List<PricingRules> pricingRules = pricingRulesCSV.readFile(ClassLoader.getSystemResource("data/pricing-rules.csv").toURI(), PricingRules.class);
		
    } 

}
