package org.cs.dojo.number;

import java.util.Arrays;

public class GCD {

	private static int gcd(int x, int y) {
		return (y == 0) ? x : gcd(y, x % y);
	}

	public static int gcd(int... numbers) {
		return Arrays.stream(numbers).reduce(0, (x, y) -> gcd(x, y));
	}
}
