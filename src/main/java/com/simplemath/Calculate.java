package com.simplemath;

public class Calculate implements CalculateInterface {

	
	public Boolean printNumbers(int limit) {
		if (limit > 0) {
			for (int i = 0; i < limit; i++) {
				System.out.print(i + " ");
			}
			return true;
		} else
			 throw new IllegalArgumentException("The value to print should be greater than 0");
	}

	public Double areaOfTriangle(double breadth, double height) {
		double area = 0.0;
		if (breadth > 0 && height > 0)
			area = 0.5 * breadth * height;
		else
			throw new IllegalArgumentException("Breadth and Height of triangle should be greater than 0");
		return area;
	}

}
