package org.home.sample;

import java.util.List;

import org.home.sample.model.Airline;
import org.home.sample.model.Flight;
import org.home.sample.model.PricingRules;
import org.home.sample.service.PassengerTypeService;
import org.home.sample.service.PricingRuleService;
import org.home.sample.service.impl.PassengerTypeServiceImpl;
import org.home.sample.service.impl.PricingRuleServiceImpl;
import org.home.sample.util.CSVFileParser;
import org.junit.Before;
import org.junit.Test;

public class SearchFlightsTest {
	
	private List<Airline> airlines;
	
	private List<Flight> flights;
	
	private List<PricingRules> pricingRules;
	
	private PassengerTypeService passengerTypeService;
	
	private PricingRuleService pricingRuleService;
	
	@Before
    public void setup() {
		loadData();
		this.passengerTypeService = new PassengerTypeServiceImpl(airlines);
		this.pricingRuleService = new PricingRuleServiceImpl(pricingRules);
    }
	
	@Test
    public void cafeShouldNeverServeCoffeeItDoesntHave() {
        Given:
        cafe.setCoffeesRemaining(1);

        When:
        cafe.serveCoffee();

        Then:
        assertFalse(cafe.canServeCoffee());
    }
	
	
	
	private void loadData () {
		//CSVFileParser<Airport> airportCSV = new CSVFileParser<Airport>();
		CSVFileParser<Airline> airlineCSV = new CSVFileParser<Airline>();
		CSVFileParser<Flight> flightCSV = new CSVFileParser<Flight>();
		CSVFileParser<PricingRules> pricingRulesCSV = new CSVFileParser<PricingRules>();
			
		try {
//			List<Airport> airports = airportCSV.readFile(ClassLoader.getSystemResource("data/airports.csv").toURI(), Airport.class);
			this.airlines = airlineCSV.readFile(ClassLoader.getSystemResource("data/airlines.csv").toURI(), Airline.class);
			this.flights = flightCSV.readFile(ClassLoader.getSystemResource("data/flights.csv").toURI(), Flight.class);
			this.pricingRules = pricingRulesCSV.readFile(ClassLoader.getSystemResource("data/pricing-rules.csv").toURI(), PricingRules.class);
				
//				
//				PassengerTypeService passengerTypeService = new PassengerTypeServiceImpl(airlines);
//				PricingRuleService pricingRuleService = new PricingRuleServiceImpl(pricingRules);
//				SearchFlightService searchFlightService = new SearchFlightServiceImpl(flights, pricingRuleService, passengerTypeService);
//				
//				SearchFlightRequest request = new SearchFlightRequest("CDG", "FRA", 2, 1, 2, 0);
//				
//				List<SearchFlightResponse> response  = searchFlightService.findAvailableFlights(request);
//				System.out.println(response.toString());
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
