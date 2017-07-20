package com.lhauspie.performance.test.runnable;

public abstract class AbstractStringConcatenator implements IPerformanceRunnable {

	@Override
	public void run(int nbIteration) {
		for (int i = 0; i < nbIteration; i++) {
			this.append("_");
		}
		System.out.println(this.toString());
	}
	
	public abstract AbstractStringConcatenator append(String string);
}
