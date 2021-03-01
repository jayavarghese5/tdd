package com.simplemath;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Calculate{
	
	/**
	 * This Function takes integer as input and return Boolean as output
	 */
	Function<Integer,Boolean> printNumbers=limit->{
		if(limit<1) return false;
		else {
		IntStream.range(1, limit+1).forEach(System.out::println);
		return true;
		}
	   };
	

	 public Function<Triangle,Double>  areaCalculation=triangle->{
		 double result = 0;
		 if(triangle.height>0 && triangle.breadth>0 )
		    result=0.5*triangle.breadth*triangle.height;   
		 else
			 throw new IllegalArgumentException("Negative numbers");
		 return result;
	 };
	
	/**
	 * This is a higher order Funtion taking Funtion as input and 
	 * returning function as output
	 * @param raw
	 * @return
	 */
	public Function<Integer,Boolean> printNumbersIn(Function<Integer,Boolean> raw){
		return from->{
			return raw.apply(from);
		};
	}	


	/**
	 * calculates the area of triangle Area = 0.5 * height * breadth
	 * @param raw
	 * @return
	 */
	public Function<Triangle,Double> areaOfTriangle(Function<Triangle,Double> raw){
		return from->{
		Double result=raw.apply(from);
		return result;
		};
	}
		
	
	   
	/**
	 * @param limit --The input to print numbers.
	 */
	public Boolean printValues(Integer limit) {
       return handleError(printNumbersIn(printNumbers)).apply(limit);
	}
	
	public double calculateArea(Triangle triangle) {
		return handleError(areaOfTriangle(areaCalculation)).apply(triangle);
	}
	

	
	/*
	 * Handle error
	 */
	public <T, R> Function<T,R> handleError(Function<T,R> raw){
		 return from -> {
	            try {
	                R result = raw.apply(from);
	                return result;
	            }catch(Exception e){
	                System.out.println("***Unexpected error "+e);
	                throw e;
	            }
				
	        };
	}
	
}
