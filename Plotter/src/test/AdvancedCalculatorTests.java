package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.maths.AdvancedCalculator;
import com.maths.Calculator;

public class AdvancedCalculatorTests {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSimpsonIntegral() {
		double simpson = AdvancedCalculator.SimpsonIntegral(new MockCalculator(0, 0));
		
		assertEquals(82.95, simpson, 0.1);
	}
	
	@Test
	public void testTrapeziumIntegral() {
		double trap = AdvancedCalculator.trapeziumIntegral(new MockCalculator(0, 0));
		
		assertEquals(82.95, trap, 0.1);
	}
	
	@Test
	public void testGaussIntegral() {
		double gauss = AdvancedCalculator.gaussIntegral(new MockCalculator(0, 0));
		
		assertEquals(82.95, gauss, 0.1);
	}
	
	@Test
	public void testDF(){
		assertEquals(4, AdvancedCalculator.df(2, new MockCalculator(0,0)),0.01);
	}

}
