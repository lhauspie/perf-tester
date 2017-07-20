package com.lhauspie.performance.test.runnable;
public class Tester {

	public interface Action {
		public void execute();
	}

	public static long test(Action action) {
		final long begin = System.currentTimeMillis();

		action.execute();

		final long end = System.currentTimeMillis();
		return end - begin;
	}
}
