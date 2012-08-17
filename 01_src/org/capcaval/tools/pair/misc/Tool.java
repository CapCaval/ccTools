package org.capcaval.tools.pair.misc;

import java.util.ArrayList;
import java.util.List;

public class Tool {
	public static <T> List<T> newList(T... items) {
		List<T> result = new ArrayList<T>(items.length);
		for (T t : items) {
			result.add(t);
		}
		return result;
	}
}
