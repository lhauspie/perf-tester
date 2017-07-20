package com.lhauspie.performance.test.runnable.foreach_vs_stream;

import java.util.ArrayList;
import java.util.List;

import com.lhauspie.performance.test.runnable.IPerformanceRunnable;

public class StreamRunnable implements IPerformanceRunnable {

	static List<MyArtifact> myArtifacts = new ArrayList<MyArtifact>();
	static {
		for (int artifactId = 0; artifactId < 1000; artifactId++) {
			myArtifacts.add(new MyArtifact("" + artifactId, "another_" + artifactId));
		}
	}
	
	static List<String> myArtifactTechnicalIds = new ArrayList<String>();
	static {
		for (int artifactId = 0; artifactId < 1000; artifactId++) {
			myArtifactTechnicalIds.add("" + artifactId);
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
		for (String myArtifactTechnicalId : myArtifactTechnicalIds) {
			MyArtifact existedStickyNote = myArtifacts.stream().filter(sn -> sn.getArtifactTechnicalId().equals(myArtifactTechnicalId)).findFirst().orElse(null);
			if (existedStickyNote != null) {
				String value = existedStickyNote.getAnotherInfo();
			}
		}
	}
}