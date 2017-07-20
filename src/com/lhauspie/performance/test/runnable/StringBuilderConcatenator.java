package com.lhauspie.performance.test.runnable;

public class StringBuilderConcatenator extends AbstractStringConcatenator {

	StringBuilder stringBuilder = new StringBuilder();

	boolean firstAppend = true;
	
	@Override
	public AbstractStringConcatenator append(String string) {
		if (!firstAppend) {
			stringBuilder.append(", ");
		}
		stringBuilder.append(string);
		firstAppend = false;
		return this;
	}
	
	@Override
	public String toString() {
		return stringBuilder.toString();
	}
}
