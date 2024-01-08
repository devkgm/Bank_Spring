package com.devkgm.app.util;

public class Pager {
	private int startRow;
	private int endRow;
	private int perPage = 10;
	private int page;
	
	public void makeRow() {
		this.endRow = this.page * this.perPage;
		this.startRow = this.endRow - this.perPage + 1;
	}
	
	
	public int getPerPage() {
		return perPage;
	}


	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
		this.makeRow();
	}


	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	
}
