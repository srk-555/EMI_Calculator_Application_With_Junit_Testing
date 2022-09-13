package JunitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

public class TextfieldsNumericTest {

	@Test
	public void Numerictest1() {
		EMICalculatorClass junit = new EMICalculatorClass();
		String result = junit.checkTextFields("120000","5","7");
		
		assertEquals("Test Case Failed","OK",result);
	}
	
	@Test
	public void Numerictest2() {
		EMICalculatorClass junit = new EMICalculatorClass();
		String result = junit.checkTextFields("12000","5","6y");
		
		assertEquals("Test Case Failed","Status : Rate field should be numbers only.",result);
	}
	
	@Test
	public void Numerictest3() {
		EMICalculatorClass junit = new EMICalculatorClass();
		String result = junit.checkTextFields("1200a00","15","6");
		
		assertEquals("Test Case Failed","Status : Loan field should be numbers only.",result);
	}

	@Test
	public void Numerictest4() {
		EMICalculatorClass junit = new EMICalculatorClass();
		String result = junit.checkTextFields("1200a00","Y15","6g");
		
		assertEquals("Test Case Failed","Status : Loan field should be numbers only.",result);
	}

}
