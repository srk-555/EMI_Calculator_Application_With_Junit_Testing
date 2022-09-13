package JunitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComputationTest {

	@Test
	public void computetest1() {
		EMICalculatorClass junit = new EMICalculatorClass();
		String result = junit.isEverythingAllRight("100000","4","5");
		
		assertEquals("Test Case Failed", "Status : All good", result);
	}
	
	@Test
	public void computetest2() {
		EMICalculatorClass junit = new EMICalculatorClass();
		double result = junit.getEMI(100000.0,20.0,5.01);
		
		assertEquals("Test Case Failed", 660.51, result, 0.001);
	}
	
	@Test
	public void computetest3() {
		EMICalculatorClass junit = new EMICalculatorClass();
		double result = junit.getEMI(400000.0,6,7);
		
		assertEquals("Test Case Failed", 6819.6, result, 0.001);
	}
	

}
