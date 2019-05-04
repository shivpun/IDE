package org.cs.dojo.recurring.charater;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(value = Parameterized.class)
public class MinimumTimeTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(MinimumTimeTest.class);

	@Parameterized.Parameter(0)
	public Integer m1;

	@Parameterized.Parameter(1)
	public Integer[] m2;

	@Parameterized.Parameter(2)
	public Integer result;

	@Parameterized.Parameters(name = "{index}: Test with m1={0}, result is:{1} ")
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { 4, new Integer[] { 20, 4, 8, 2 }, 54 },
				{ 6, new Integer[] { 1, 2, 5, 10, 35, 89 }, 224 } };
		return Arrays.asList(data);
	}

	@Test
	public void test_minimumTime() {
		LOGGER.info("Inside test method [test_minimumTime]");
		MinimumTime time = new MinimumTime();
		Integer r = time.minimumTime(m1, Arrays.asList(m2));
		assertEquals(result, r);
	}
}
