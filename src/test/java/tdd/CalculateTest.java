package tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.simplemath.Calculate;



public class CalculateTest {
	Calculate calculation;
	@Before
	public void setUp() {
	   calculation=new Calculate();
	}
	
	/**
	 * Positive test to check , printing of numbers
	 */
	@Test
	public void printNumbersTest() {
		int limit=10;		
		Assert.assertTrue("The limit is not correct", calculation.printNumbers(limit));
	}
	
	/**
	 * Negative test to check if the IllegalArgumentException is thrown when given wrong input
	 */
	@Test(expected = IllegalArgumentException.class)
	public void printNumberWrongInputTest() {	
		Assert.assertTrue("The limit is not correct", calculation.printNumbers(-10));
	}
	
	/**
	 * Positive test to check , Area of triangle
	 */
	@Test
	public void areaOfTriangleTest() {
		double breadth=3.0;
		double height=4.0;
		double area= 0.5 *breadth * height;
		double returnValue=calculation.areaOfTriangle(breadth,height);
		System.out.println("Area of triagle with breadth : "+breadth+" height :"+height+" is "+returnValue);
		Assert.assertEquals(area, returnValue,0.0);
	}
	
	/**
	 * Negative test to check if the IllegalArgumentException is thrown when given wrong input
	 */
	@Test(expected = IllegalArgumentException.class)
	public void areaOfTriangleWithNegativeInputTest() {
		double returnValue=calculation.areaOfTriangle(0,4);
		System.out.println(" Return value="+returnValue);
		Assert.assertEquals(0, returnValue,0.0);
	}
}
