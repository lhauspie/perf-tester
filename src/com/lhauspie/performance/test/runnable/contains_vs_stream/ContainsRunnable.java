package com.lhauspie.performance.test.runnable.contains_vs_stream;

import java.util.ArrayList;
import java.util.List;

import com.lhauspie.performance.test.runnable.IPerformanceRunnable;

public class ContainsRunnable implements IPerformanceRunnable {

	static List<String> myArtifactTechnicalIds = new ArrayList<String>();
	static {
		for (int artifactId = 0; artifactId < 10000; artifactId++) {
			myArtifactTechnicalIds.add("myString" + artifactId);
		}
	}

	@Override
	public void run(int nbIteration) {
		for (int i = 0; i < nbIteration; i++) {
			this.test();
		}
		System.out.println(this.toString());
	}
	
	private void test() {
		if (myArtifactTechnicalIds.contains("myString7800")) {
			String value = "found";
		}
	}
}