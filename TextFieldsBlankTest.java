package JunitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

public class TextFieldsBlankTest {

	@Test
	public void Emptytest1() {
		EMICalculatorClass junit = new EMICalculatorClass();
		String result = junit.checkTextFields("","","");
		
		assertEquals("Test Case Failed","Status : All fields are mandatory!",result);
	}
	
	@Test
	public void Emptytest2() {
		EMICalculatorClass junit = new EMICalculatorClass();
		String result = junit.checkTextFields("12000","5","");
		
		assertEquals("Test Case Failed","Status : All fields are mandatory!",result);
	}
	
	@Test
	public void EmptyTest3() {
		EMICalculatorClass junit = new EMICalculatorClass();
		String result = junit.checkTextFields("120000","5","7");
		
		assertEquals("Test Case Failed","OK",result);
	}
}


