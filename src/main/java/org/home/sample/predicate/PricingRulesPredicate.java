package org.home.sample.predicate;

import java.util.Optional;
import java.util.function.Predicate;

import org.home.sample.model.PricingRules;

public class PricingRulesPredicate {
	
	public static Predicate<PricingRules> percentageAvailable (Integer from, Integer to) {
		Optional<Integer> oint = Optional.ofNullable(to);
		return pricingRules -> pricingRules.getFrom() <= from &&
				 ((oint.isPresent() && oint.get() <= pricingRules.getTo()) || !oint.isPresent()) ; 
	}
	

}
