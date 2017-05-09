package org.home.sample;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.home.sample.model.Airline;
import org.home.sample.model.Flight;
import org.home.sample.model.PricingRules;
import org.home.sample.model.request.SearchFlightRequest;
import org.home.sample.model.response.SearchFlightResponse;
import org.home.sample.predicate.SearchFlightResponsePredicate;
import org.home.sample.service.PassengerTypeService;
import org.home.sample.service.PricingRuleService;
import org.home.sample.service.SearchFlightService;
import org.home.sample.service.impl.PassengerTypeServiceImpl;
import org.home.sample.service.impl.PricingRuleServiceImpl;
import org.home.sample.service.impl.SearchFlightServiceImpl;
import org.home.sample.util.CSVFileParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//@RunWith(Parameterized.class)
public class SearchFlightsIntTest {
	
	private List<Airline> airlines;
	
	private List<Flight> flights;
	
	private List<PricingRules> pricingRules;
	
	private PassengerTypeService passengerTypeService;
	
	private PricingRuleService pricingRuleService;
	
	private SearchFlightService searchFlightService;
	
	private String from;
	
	private String to;
	
	private Integer daysTo;
		
	private Integer numAdults; 
	
	private Integer numChildren; 
	
	private Integer numInfants;
	
	private String resultFlightCode; 
	
	private Double totalPrice; 
	
	@Parameterized.Parameters
	   public static Collection<Object[]> flights() {
	      return Arrays.asList(new Object[][] {
	         { "AMS", "FRA", 31, 1, 0, 0, "TK2659", 198.4 }, //Correct
	         { "AMS", "XXX", 31, 1, 0, 0, "LH5909", 90.4 },  //Incorrect Destintation
	         { "LHR", "IST", 15, 2, 1, 1, "LH1085", 481.19 },//Correct
	         { "LHR", "IST", 15, 2, 1, 1, "TK8891", 804.87 },//Incorrect Total price
	         { "BCN", "MAD", 2, 1, 2, 0, "IB2171", 909.09 }, //Correct
	         { "BCN", "MAD", 2, 1, 2, 0, "LH5896", 1028.43 }, //Incorrect Flight Number
	         { "CDG", "FRA", 28, 1, 1, 1, "Not Exists", 0.0 },
	   });
	}
	
	   

	   public SearchFlightsIntTest(String from, String to, Integer daysTo, Integer numAdults, Integer numChildren,
				Integer numInfants, String resultFlightCode, Double totalPrice) {
			super();
			this.from = from;
			this.to = to;
			this.daysTo = daysTo;
			this.numAdults = numAdults;
			this.numChildren = numChildren;
			this.numInfants = numInfants;
			this.resultFlightCode = resultFlightCode;
			this.totalPrice = totalPrice;
		}   
	   
	@Before
    public void setup() {
		loadData();
		createServices();
		
    }
	
	
	@Test
	@Parameters
    public void searchFlights() {
		SearchFlightRequest request = null;
		Stream<SearchFlightResponse> response = null;
		SearchFlightResponse existsResponse = null;
		List<SearchFlightResponse> list = null;
		
        Given:
        	 request = new SearchFlightRequest(from, to, daysTo, numAdults, numChildren, numInfants);
        When:
        	 response  = searchFlightService.findAvailableFlights(request);
        Then:
        
        	list = response.collect(Collectors.<SearchFlightResponse>toList());
        	Assert.assertTrue("No flights available with the parameters selected", !list.isEmpty());
		
        	existsResponse = SearchFlightResponsePredicate.filterResponses(list, SearchFlightResponsePredicate.existsFlightCode(this.resultFlightCode)).findFirst().orElse(new SearchFlightResponse("Not Exists",0.0));
        	
        	Assert.assertTrue("The flight code doesn't match the expected one "+ existsResponse.getFlightCode(), existsResponse.getFlightCode().equals(this.resultFlightCode));
        	
        	Assert.assertTrue("The total amount doesn't match the expected one "+ existsResponse.getTotalPrice(), existsResponse.getTotalPrice() == this.totalPrice);

    }
	
	private void loadData () {
		CSVFileParser<Airline> airlineCSV = new CSVFileParser<Airline>();
		CSVFileParser<Flight> flightCSV = new CSVFileParser<Flight>();
		CSVFileParser<PricingRules> pricingRulesCSV = new CSVFileParser<PricingRules>();
			
		try {
			this.airlines = airlineCSV.readFile(ClassLoader.getSystemResource("data/airlines.csv").toURI(), Airline.class);
			this.flights = flightCSV.readFile(ClassLoader.getSystemResource("data/flights.csv").toURI(), Flight.class);
			this.pricingRules = pricingRulesCSV.readFile(ClassLoader.getSystemResource("data/pricing-rules.csv").toURI(), PricingRules.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void createServices () {
		this.passengerTypeService = new PassengerTypeServiceImpl(airlines);
		this.pricingRuleService = new PricingRuleServiceImpl(pricingRules);
		this.searchFlightService = new SearchFlightServiceImpl(this.flights, this.pricingRuleService, this.passengerTypeService);
	}
	

}
