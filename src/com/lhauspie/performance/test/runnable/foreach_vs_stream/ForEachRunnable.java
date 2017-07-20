package com.lhauspie.performance.test.runnable.foreach_vs_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.lhauspie.performance.test.runnable.IPerformanceRunnable;

public class ForEachRunnable implements IPerformanceRunnable {

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
		Map<String, MyArtifact> myArtifactsMap = myArtifacts.stream().collect(Collectors.toMap(MyArtifact::getArtifactTechnicalId, Function.identity()));
		for (String myArtifactTechnicalId : myArtifactTechnicalIds) {
			MyArtifact existedStickyNote = myArtifactsMap.get(myArtifactTechnicalId);
			if (existedStickyNote != null) {
				String value = existedStickyNote.getAnotherInfo();
			}
		}
	}
}