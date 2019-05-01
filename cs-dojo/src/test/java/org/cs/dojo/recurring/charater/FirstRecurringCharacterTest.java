package org.cs.dojo.recurring.charater;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(value = Parameterized.class)
public class FirstRecurringCharacterTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(FirstRecurringCharacterTest.class);

	@Parameterized.Parameter(0)
	public String m1;

	@Parameterized.Parameter(1)
	public Character result;

	@Parameterized.Parameters(name = "{index}: Test with m1={0}, result is:{1} ")
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { "ABCA", 'A' }, { "BCABA", 'B' }, { "ABC", null }, { null, null } };
		return Arrays.asList(data);
	}

	@Test
	public void test_recurringCharater() {
		LOGGER.info("Test method [test_recurringCharater]");
		FirstRecurringCharacter frc = new FirstRecurringCharacter(m1);
		Character ch = frc.recurringCharater();
		if (ch != null) {
			assertEquals("Result", result, ch);
		} else {
			assertNull("Result is Null", ch);
		}
	}
}
