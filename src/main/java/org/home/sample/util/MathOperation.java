package org.home.sample.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

public class MathOperation {
	
	public static double CHILD_DISCOUNT = 0.67;
	
	public static NumberFormat formatter = new DecimalFormat("#.00");  
	
	public static double calculePrice (double basePrice, double percentage) {
		return (basePrice * percentage) / 100;
	}
	
	public static double formatPrice (double basePrice) throws ParseException {
		return formatter.parse(formatter.format(basePrice)).doubleValue();
	}
	
	
}
