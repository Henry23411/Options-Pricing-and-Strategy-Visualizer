package com.uoft.henry.javatest;

public class normdist {
	static double getNormalProbabilityAtZ(double z) {
	    return Math.exp(-Math.pow(z, 2) / 2) / Math.sqrt(2 * Math.PI);
	}
	static double getAreaUnderNormalCurve(double z1, double z2) {
	    double area = 0.0;
	    final int rectangles = 100000; // Use riemann sum to find area under curve to determine probability
	    final double width = (z2 - z1) / rectangles;
	    for(int i = 0; i < rectangles; i++)
	        area += width * getNormalProbabilityAtZ(width * i + z1);
	    return area;
	}
}