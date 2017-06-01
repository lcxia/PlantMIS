package com.lhhy.bean;

public class PredictBean {

	private String surviveId;
	private int surviveRate;
	private String plantName;
	private String areaName;
	public String getSurviveId() {
		return surviveId;
	}
	public void setSurviveId(String surviveId) {
		this.surviveId = surviveId;
	}
	public int getSurviveRate() {
		return surviveRate;
	}
	public void setSurviveRate(int surviveRate) {
		this.surviveRate = surviveRate;
	}
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public PredictBean(String surviveId, int surviveRate, String plantName, String areaName) {
		super();
		this.surviveId = surviveId;
		this.surviveRate = surviveRate;
		this.plantName = plantName;
		this.areaName = areaName;
	}
	public PredictBean() {
		super();
	}

}
