package com.lhhy.bean;

public class AnalysisBean {

	private String problemId;
	private String problemName;
	private String problemText;
	private String solution;
	private String picture;

	public String getProblemId() {
		return problemId;
	}

	public void setProblemId(String problemId) {
		this.problemId = problemId;
	}

	public String getProblemName() {
		return problemName;
	}

	public void setProblemName(String problemName) {
		this.problemName = problemName;
	}

	public String getProblemText() {
		return problemText;
	}

	public void setProblemText(String problemText) {
		this.problemText = problemText;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String salution) {
		this.solution = salution;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public AnalysisBean(String problemId, String problemName, String problemText, String solution, String picture) {
		super();
		this.problemId = problemId;
		this.problemName = problemName;
		this.problemText = problemText;
		this.solution = solution;
		this.picture = picture;
	}

	public AnalysisBean() {
		super();
	}

}
