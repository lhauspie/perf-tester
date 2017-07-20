package com.lhauspie.performance.test.runnable;

import java.util.ArrayList;
import java.util.List;

public class StringJoinConcatenator extends AbstractStringConcatenator {

	List<String> strings = new ArrayList<String>();

	@Override
	public AbstractStringConcatenator append(String string) {
		strings.add(string);
		return this;
	}
	
	@Override
	public String toString() {
		return String.join(", ", strings);
	}
}
