package JunitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

public class ObjectCreationTest {
	
	@Test
	public void test1() {
		EMICalculatorClass junit = new EMICalculatorClass();
		
		
		assertNotNull(junit);
	}
	
	@Test
	public void test2() {
		EMICalculatorClass junit1 = new EMICalculatorClass();
		EMICalculatorClass junit2 = new EMICalculatorClass();
		
		assertNotSame(junit1, junit2);
	}

}
