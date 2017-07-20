package com.lhauspie.performance.test.runnable;

public interface IPerformanceRunnable<T extends Object> {
	
	public default void init(T object) {
		
	}
	
	public void run(int nbIteration);
}
