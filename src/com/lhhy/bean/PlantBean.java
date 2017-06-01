package com.lhhy.bean;

public class PlantBean {

	private String plantId;
	private String plantName;
	private String plantText;
	private String genusName;
	private String phylumName;
	private String className;
	private String orderName;
	private String familyName;
	private String picture;
	public String getPlantId() {
		return plantId;
	}
	public void setPlantId(String plantId) {
		this.plantId = plantId;
	}
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	public String getPlantText() {
		return plantText;
	}
	public void setPlantText(String plantText) {
		this.plantText = plantText;
	}
	public String getGenusName() {
		return genusName;
	}
	public void setGenusName(String genusName) {
		this.genusName = genusName;
	}
	public String getPhylumName() {
		return phylumName;
	}
	public void setPhylumName(String phylumName) {
		this.phylumName = phylumName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public PlantBean(String plantId, String plantName, String plantText, String genusName, String phylumName,
			String className, String orderName, String familyName, String picture) {
		super();
		this.plantId = plantId;
		this.plantName = plantName;
		this.plantText = plantText;
		this.genusName = genusName;
		this.phylumName = phylumName;
		this.className = className;
		this.orderName = orderName;
		this.familyName = familyName;
		this.picture = picture;
	}
	public PlantBean() {
		super();
	}

}
