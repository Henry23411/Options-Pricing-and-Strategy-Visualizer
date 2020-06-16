package com.uoft.henry.javatest;
import java.util.Scanner;

public class options_pricing {
	
	public static void main(String args[]) {
		double S, X, t, q, r, stdev;
		try (Scanner scan = new Scanner (System.in)) {
			System.out.print("Enter option type (call/put): ");
			String option = scan.nextLine();
			option = option.toLowerCase();
			
			System.out.print("Underlying Price: ");
			S = scan.nextDouble();
			
			System.out.print("Strike Price: ");
			X = scan.nextDouble();
			
			System.out.print("Time to exprations (in years): ");
			t = scan.nextDouble();
			
			System.out.print("Dividend Yield (compounded continuously): ");
			q = scan.nextDouble();
			
			System.out.print("Annual Risk Free Rate: ");
			r = scan.nextDouble();
			
			System.out.print("Annualized Volatility: ");
			stdev = scan.nextDouble();
			
			System.out.println("----------");
			
			if (option.equals ("call")) {
				double call_price = options_calculations.call_calc (S, X, t, q, r, stdev);
				System.out.println("Option Price is: " + call_price);	
				double call_delta = options_calculations.call_delta_calc (S, X, t, q, r, stdev);
				System.out.print("Delta: " + call_delta);
				double gamma = options_calculations.gamma_calc (S, X, t, q, r, stdev);
				System.out.print("\tGamma: " + gamma);
				double call_theta = options_calculations.call_theta_calc (S, X, t, q, r, stdev);
				System.out.print("\tTheta: " + call_theta);
			}
			
			else if (option.equals("put")) {
				double put_price = options_calculations.put_calc (S, X, t, q, r, stdev);
				System.out.println("Option Price is: " + put_price);
				double put_delta = options_calculations.put_delta_calc (S, X, t, q, r, stdev);
				System.out.print("Delta: " + put_delta);
				double gamma = options_calculations.gamma_calc (S, X, t, q, r, stdev);
				System.out.print("\tGamma: " + gamma);
			}
			
			
			
			

		}
	}
}
