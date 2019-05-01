package org.cs.dojo.recurring.charater;

import java.util.Hashtable;
import java.util.Map;

public class FirstRecurringCharacter {

	private final String rec;

	public FirstRecurringCharacter(String rec) {
		this.rec = rec;
	}

	public Character recurringCharater() {
		Map<Character, Integer> rc = new Hashtable<Character, Integer>();
		int count = this.rec == null ? 0 : this.rec.length();
		for (int i = 0; i < count; i++) {
			char c = this.rec.charAt(i);
			if (rc.get(c)!=null && rc.get(c) > 0) {
				return c;
			}
			rc.put(c, 1);
		}
		return null;
	}
}
