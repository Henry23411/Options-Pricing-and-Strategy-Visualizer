package com.uoft.henry.javatest;
import java.lang.Math;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class options_calculations {
	
	public static double call_calc (double S, double X, double t, double q,double r, double stdev) {
		double a = Math.log(S/X); // ln(S0/K)
		double b = ((r + ((stdev * stdev) / 2)) * t); // (r+σ2/2)t
		double c = stdev * Math.sqrt(t); // σ√t
		double d1 = (a+b)/c;
		double d2 = d1 - c;
		double nd1 = normdist.getAreaUnderNormalCurve(-5, d1);
		double nd2 = normdist.getAreaUnderNormalCurve(-5, d2);
		double e1 = Math.exp(-q * t);
		double e2 = Math.exp(-r * t);
		
		double price = (S * e1 * nd1) - (X * e2 * nd2);
		
		BigDecimal bd = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP);
        return price = bd.doubleValue(); // rounding price to hearest hundredth	
	}
	
	public static double put_calc (double S, double X, double t, double q, double r, double stdev) {
		double a = Math.log(S/X); // ln(S0/K)
		double b = ((r + ((stdev * stdev) / 2)) * t); // (r+σ2/2)t
		double c = stdev * Math.sqrt(t); // σ√t
		double d1 = (a+b)/c;
		double d2 = d1 - c;
		double nd1 = normdist.getAreaUnderNormalCurve(-5, -d1);
		double nd2 = normdist.getAreaUnderNormalCurve(-5, -d2);
		double e1 = Math.exp(-r * t);
		double e2 = Math.exp(-q * t);
		
		double price = (X * e1 * nd2) - (S * e2 * nd1);
		
		BigDecimal bd = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP);
        return price = bd.doubleValue(); // rounding price to hearest hundredth
	}
	
	public static double call_delta_calc (double S, double X, double t, double q,double r, double stdev) {
		double a = Math.log(S/X);
		double b = ((r + ((stdev * stdev) / 2)) * t);
		double c = stdev * Math.sqrt(t);
		double d1 = (a+b)/c;
		double nd1 = normdist.getAreaUnderNormalCurve(-5, d1);
		double e1 = Math.exp(-q * t);
		double call_delta_calc = e1 * nd1;
		
		BigDecimal bd = new BigDecimal(call_delta_calc).setScale(2, RoundingMode.HALF_UP);
        return call_delta_calc = bd.doubleValue(); // rounding price to hearest hundredth	
	}
	
	public static double put_delta_calc (double S, double X, double t, double q,double r, double stdev) {
		double a = Math.log(S/X);
		double b = ((r + ((stdev * stdev) / 2)) * t);
		double c = stdev * Math.sqrt(t);
		double d1 = (a+b)/c;
		double nd1 = normdist.getAreaUnderNormalCurve(-5, d1);
		double e1 = Math.exp(-q * t);
		double put_delta_calc = e1 * (nd1 - 1);
		
		BigDecimal bd = new BigDecimal(put_delta_calc).setScale(2, RoundingMode.HALF_UP);
        return put_delta_calc = bd.doubleValue(); // rounding price to hearest hundredth
	}
	
	public static double gamma_calc (double S, double X, double t, double q,double r, double stdev) {
		double a = Math.log(S/X); // ln(S0/K)
		double b = ((r + ((stdev * stdev) / 2)) * t); // (r+σ2/2)t
		double c = stdev * Math.sqrt(t); // σ√t
		double d1 = (a+b)/c;
		double e1 = Math.exp(-q * t);
		double e3 = Math.exp(-((d1 * d1) / 2));
		
		double gamma_calc = (e1 / (S * c)) * (1 / Math.sqrt(2 * Math.PI)) * e3;
		
		BigDecimal bd = new BigDecimal(gamma_calc).setScale(2, RoundingMode.HALF_UP);
        return gamma_calc = bd.doubleValue(); // rounding price to hearest hundredth
	}
	
	public static double call_theta_calc (double S, double X, double t, double q,double r, double stdev) {
		double a = Math.log(S/X); // ln(S0/K)
		double b = ((r + ((stdev * stdev) / 2)) * t); // (r+σ2/2)t
		double c = stdev * Math.sqrt(t); // σ√t
		double d1 = (a+b)/c;
		double d2 = d1 - c;
		double nd1 = normdist.getAreaUnderNormalCurve(-5, d1);
		double nd2 = normdist.getAreaUnderNormalCurve(-5, d2);
		double e1 = Math.exp(-q * t);
		double e2 = Math.exp(-r * t);
		double e3 = Math.exp((-(d1 * d1) / 2));
		
		double a1 = ((S * stdev * e1) / (2 * Math.sqrt(t))) * (1 / (Math.sqrt(2 * Math.PI))) * e3;
		double a2 = r * X * e2 * nd2;
		double a3 = q * S * e1 * nd1;
		
		double theta_calc = (-a1 - a2 + a3);
		
		BigDecimal bd = new BigDecimal(theta_calc).setScale(2, RoundingMode.HALF_UP);
        return theta_calc = bd.doubleValue(); // rounding price to hearest hundredth
	}
	
	public static double put_theta_calc (double S, double X, double t, double q,double r, double stdev) {
		double a = Math.log(S/X); // ln(S0/K)
		double b = ((r + ((stdev * stdev) / 2)) * t); // (r+σ2/2)t
		double c = stdev * Math.sqrt(t); // σ√t
		double d1 = (a+b)/c;
		double d2 = d1 - c;
		double nd1 = normdist.getAreaUnderNormalCurve(-5, d1);
		double nd2 = normdist.getAreaUnderNormalCurve(-5, d2);
		double e1 = Math.exp(-q * t);
		double e2 = Math.exp(-r * t);
		double e3 = Math.exp((-(d1 * d1) / 2));
		
		double a1 = ((S * stdev * e1) / (2 * Math.sqrt(t))) * (1 / (Math.sqrt(2 * Math.PI))) * e3;
		double a2 = r * X * e2 * nd2;
		double a3 = q * S * e1 * nd1;
		
		double theta_calc = (-a1 + a2 - a3);
		
		BigDecimal bd = new BigDecimal(theta_calc).setScale(2, RoundingMode.HALF_UP);
        return theta_calc = bd.doubleValue(); // rounding price to hearest hundredth
	}
}
