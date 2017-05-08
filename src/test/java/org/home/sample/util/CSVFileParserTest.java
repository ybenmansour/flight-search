package org.home.sample.util;

import java.net.URISyntaxException;
import java.util.List;

import org.home.sample.model.Airport;
import org.junit.Assert;
import org.junit.Test;

public class CSVFileParserTest {
	
	@Test
	public void readFile() {
		
		CSVFileParser<Airport> airportCSV = new CSVFileParser<Airport>();
		try {
			List<Airport> airports = airportCSV.readFile(ClassLoader.getSystemResource("data/airports.csv").toURI(), Airport.class);
			Assert.assertTrue(airports.size() == 9);
		} catch (NoSuchMethodException | SecurityException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
