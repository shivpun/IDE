package org.cs.dojo.recurring.charater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinimumTime {

	public Integer minimumTime(int numParts, List<Integer> parts) {
		int sum = 0;
		List<Integer> resolve = new ArrayList<Integer>(parts);
		while (resolve.size() >= 2) {
			resolve.sort(Comparator.naturalOrder());
			Integer a = resolve.get(0);
			Integer b = resolve.get(1);
			Integer c = a + b;
			sum = sum + c;
			resolve.removeAll(Arrays.asList(a, b));
			resolve.add(c);
		}
		return sum;
	}
}
