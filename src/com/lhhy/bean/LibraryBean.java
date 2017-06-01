package com.lhhy.bean;

public class LibraryBean {

	private String libraryId;
	private String publish;
	private String updateDate;
	private String writer;
	private String theme;
	private String libraryText;
	private String abst;
	private String mainword;
	private String come;
	private String libraryName;
	public String getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(String libraryId) {
		this.libraryId = libraryId;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getLibraryText() {
		return libraryText;
	}
	public void setLibraryText(String libraryText) {
		this.libraryText = libraryText;
	}
	public String getAbst() {
		return abst;
	}
	public void setAbst(String abst) {
		this.abst = abst;
	}
	public String getMainword() {
		return mainword;
	}
	public void setMainword(String mainword) {
		this.mainword = mainword;
	}
	public String getCome() {
		return come;
	}
	public void setCome(String come) {
		this.come = come;
	}
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	public LibraryBean(String libraryId, String publish, String updateDate, String writer, String theme,
			String libraryText, String abst, String mainword, String come, String libraryName) {
		super();
		this.libraryId = libraryId;
		this.publish = publish;
		this.updateDate = updateDate;
		this.writer = writer;
		this.theme = theme;
		this.libraryText = libraryText;
		this.abst = abst;
		this.mainword = mainword;
		this.come = come;
		this.libraryName = libraryName;
	}
	public LibraryBean() {
		super();
	}

}
