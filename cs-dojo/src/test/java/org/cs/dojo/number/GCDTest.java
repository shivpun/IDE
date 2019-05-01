package org.cs.dojo.number;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(value = Parameterized.class)
public class GCDTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(GCDTest.class);

	@Parameterized.Parameter(0)
	public int[] m1;

	@Parameterized.Parameter(1)
	public int result;

	@Parameterized.Parameters(name = "{index}: GCD for m1={0}, result is:{1} ")
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { new int[] { 2, 4, 6, 8, 10 }, 2 } };
		return Arrays.asList(data);
	}

	@Test
	public void test_recurringCharater() {
		LOGGER.info("Test method [test_recurringCharater]");
		int num = GCD.gcd(m1);
		assertEquals("Result", result, num);
	}
}
