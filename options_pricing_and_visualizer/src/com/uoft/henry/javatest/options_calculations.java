package com.uoft.henry.javatest;
import java.lang.Math;

public class options_calculations {
	public static double call_calc (double S, double K, double t, double r, double stdev) {
		double price;
		double a = Math.log(S/K); // ln(S0/K)
		double b = ((r + ((stdev * stdev) / 2)) * t); // (r+σ2/2)t
		double c = stdev * Math.sqrt(t); // σ√t
		double d1 = (a+b)/c;
		double d2 = d1 - c;
		double nd1 = normdist.getAreaUnderNormalCurve(-5, d1);
		double nd2 = normdist.getAreaUnderNormalCurve(-5, d2);
		double e = Math.exp(-r * t);
		
		return price = (nd1 * S) - (nd2 * K * e);
	}
	
	public static double put_calc (double S, double K, double t, double r, double stdev) {
		double price;
		double a = Math.log(S/K); // ln(S0/K)
		double b = ((r + ((stdev * stdev) / 2)) * t); // (r+σ2/2)t
		double c = stdev * Math.sqrt(t); // σ√t
		double d1 = (a+b)/c;
		double d2 = d1 - c;
		double nd1 = normdist.getAreaUnderNormalCurve(-5, -d1);
		double nd2 = normdist.getAreaUnderNormalCurve(-5, -d2);
		double e = Math.exp(-r * t);
		
		return price = (K * e * nd2) - (S * nd1);
	}
}
