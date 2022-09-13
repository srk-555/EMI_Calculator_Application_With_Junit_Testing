package JunitTesting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ComputationTest.class, InputValuesTest.class, ObjectCreationTest.class, TextFieldsBlankTest.class,
		TextfieldsNumericTest.class })

public class AllTests {

}
