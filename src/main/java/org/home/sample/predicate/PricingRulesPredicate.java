package org.home.sample.predicate;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.home.sample.model.PricingRules;

public class PricingRulesPredicate {
	
	public static Predicate<PricingRules> percentageAvailable (Integer numDays) {
		return pricingRules -> pricingRules.getFrom() <= numDays &&
				 ((Optional.ofNullable(pricingRules.getTo()).isPresent() && Optional.ofNullable(pricingRules.getTo()).get() >= numDays) 
						 || !Optional.ofNullable(pricingRules.getTo()).isPresent()) ; 
	}
	
	public static List<PricingRules> filterPricingRules (List<PricingRules> pricingRules, Predicate<PricingRules> predicate) {
        return pricingRules.stream().filter(predicate).collect(Collectors.<PricingRules>toList());
    }

}
