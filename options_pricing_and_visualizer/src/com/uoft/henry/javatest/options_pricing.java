package com.uoft.henry.javatest;
import java.util.Scanner;

public class options_pricing {
	
	public static void main(String args[]) {
		double S, K, t, r, stdev;
		try (Scanner scan = new Scanner (System.in)) {
			System.out.print("Enter option type (call/put): ");
			String option = scan.nextLine();
			option = option.toLowerCase();
			
			System.out.print("Stock Price(S): ");
			S = scan.nextDouble();
			
			System.out.print("Exercise Price(K): ");
			K = scan.nextDouble();
			
			System.out.print("Time to maturity in years (t): ");
			t = scan.nextDouble();
			
			System.out.print("Annual Risk Free Rate (r): ");
			r = scan.nextDouble();
			
			System.out.print("Annualized Volatility (σ): ");
			stdev = scan.nextDouble();
			
			if (option.equals ("call")) {
				double call_price = options_calculations.call_calc (S, K, t, r, stdev);
				System.out.print("Option Price is: " + call_price);	
			}
			
			else if (option.equals("put")) {
				double put_price = options_calculations.put_calc (S, K, t, r, stdev);
				System.out.print("Option Price is: " + put_price);
			}

		}
	}
}
