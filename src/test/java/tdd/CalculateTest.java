package tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.simplemath.Calculate;
import com.simplemath.Triangle;


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
		Assert.assertTrue("Success", calculation.printValues(limit));
	}
	
	/**
	 * Negative test to check if the IllegalArgumentException is thrown when given wrong input
	 */
	@Test
	public void printNumberNegativeTest() {	
		Assert.assertFalse("The limit is not correct", calculation.printValues(-10));
	}
	
	/**
	 * Negative test to check if the IllegalArgumentException is thrown when given wrong input
	 */
	@Test
	public void printNumberwithZeroAsInput() {	
		Assert.assertFalse("The limit is not correct", calculation.printValues(0));
	}
		
	/**
	 * Negative test to check if the IllegalArgumentException is thrown when given wrong input
	 */
	@Test
	public void printNumberwithOneAsInput() {	
		Assert.assertTrue("The limit is not correct", calculation.printValues(1));
	}
	/**
	 * Positive test to check , Area of triangle
	 */
	@Test
	public void areaOfTriangleTest() {
		double breadth=3.0;
		double height=4.0;
		double area= 0.5 *breadth * height;
		Triangle triangle=new Triangle(breadth,height);
		double returnValue=calculation.calculateArea(triangle);
		System.out.println("Area of triagle with breadth : "+breadth+" height :"+height+" is "+returnValue);
		Assert.assertEquals(area, returnValue,0.0);
	}
	
	
	/**
	 * Negative test to check if the IllegalArgumentException is thrown when given wrong input
	 */
	@Test(expected = IllegalArgumentException.class)
	public void areaOfTriangleWithNegativeInputTest() {
		Triangle triangle=new Triangle(-2.0,4.0);
		calculation.calculateArea(triangle);
	}
	
}
