package org.home.sample.predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.home.sample.model.response.SearchFlightResponse;

public class SearchFlightResponsePredicate {
	
	public static Predicate<SearchFlightResponse> existsFlightCode (String code) {
		return response -> response.getFlightCode().equalsIgnoreCase(code); 
	}
	
	public static Stream<SearchFlightResponse> filterResponses (List<SearchFlightResponse> responses, Predicate<SearchFlightResponse> predicate) {
        return responses.stream().filter(predicate);
    }
	
}
