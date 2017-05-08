package org.home.sample.predicate;

import java.util.ArrayList;
import java.util.List;

import org.home.sample.model.PricingRules;
import org.junit.Assert;
import org.junit.Test;

public class PricingRulesPredicateTest {
	
	@Test
	public void testPricingRulesPrecicate () {
		List<PricingRules> pricingRules = new ArrayList<PricingRules>();
		pricingRules.add(new PricingRules(0,3,150.0));
		pricingRules.add(new PricingRules(4,30,120.0));
		pricingRules.add(new PricingRules(31,null,80.0));
		
		Assert.assertTrue(PricingRulesPredicate.filterPricingRules(pricingRules, PricingRulesPredicate.percentageAvailable(45)).findFirst().isPresent()) ;
	}
	

}
