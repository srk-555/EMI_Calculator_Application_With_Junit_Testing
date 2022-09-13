package JunitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

public class InputValuesTest {


	@Test
	public void Test1() {
		EMICalculatorClass junit = new EMICalculatorClass();
		String result = junit.isEverythingAllRight("-100000","5","5");
		
		assertEquals("Test Case Failed","Status : Loan amount should be greater than 0.",result);
	}
	
	@Test
	public void Test2() {
		EMICalculatorClass junit = new EMICalculatorClass();
		String result = junit.isEverythingAllRight("100000","5","-5");
		
		assertEquals("Test Case Failed","Status : Interest should be greater than 0.",result);
	}
	
	@Test
	public void Test3() {
		EMICalculatorClass junit = new EMICalculatorClass();
		String result = junit.isEverythingAllRight("100000","5","5");
		
		assertEquals("Test Case Failed","Status : All good",result);
	}
	
	@Test
	public void Test4() {
		EMICalculatorClass junit = new EMICalculatorClass();
		String result = junit.isEverythingAllRight("0","5","5");
		
		assertEquals("Test Case Failed","Status : Loan amount should be greater than 0.",result);
	}
	
	@Test
	public void Test5() {
		EMICalculatorClass junit = new EMICalculatorClass();
		String result = junit.isEverythingAllRight("50000","9","0");
		
		assertEquals("Test Case Failed","Status : Interest should be greater than 0.",result);
	}
	
	@Test
	public void Test6() {
		EMICalculatorClass junit = new EMICalculatorClass();
		String result = junit.isEverythingAllRight("-50000","-9","-8");
		
		assertEquals("Test Case Failed","Status : Loan amount should be greater than 0.",result);
	}

}
