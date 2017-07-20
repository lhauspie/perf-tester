package com.lhauspie.performance.test.runnable.foreach_vs_stream;

public class MyArtifact {
	private String artifactTechnicalId;
	private String anotherInfo;

	public MyArtifact(String artifactTechnicalId, String anotherInfo) {
		super();
		this.artifactTechnicalId = artifactTechnicalId;
		this.anotherInfo = anotherInfo;
	}

	public String getArtifactTechnicalId() {
		return artifactTechnicalId;
	}

	public String getAnotherInfo() {
		return anotherInfo;
	}
}
