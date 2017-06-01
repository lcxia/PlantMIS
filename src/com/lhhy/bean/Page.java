package com.lhhy.bean;

public class Page {
	private int page;
	private int rows;
	private int startIndex;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getStartIndex() {
		startIndex = (page - 1) * rows;
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public Page(int page, int rows) {
		super();
		this.page = page;
		this.rows = rows;
	}

	public Page(String page, String rows) {
		super();
		this.page = Integer.parseInt(page);
		this.rows = Integer.parseInt(rows);
	}

	public Page() {
		super();
	}

}
