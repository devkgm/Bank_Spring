package com.devkgm.app.util;

public class Pager {
	private Long startRow;
	private Long endRow;
	private Long perPage = 10l;
	private Long page;
	
	public void makeRow() {
		setEndRow(getPage()*getPerPage());
		setStartRow(getEndRow()-getPerPage()+1);
	}
	
	
	public Long getPerPage() {
		return perPage;
	}


	public void setPerPage(Long perPage) {
		this.perPage = perPage;
		
	}


	public Long getPage() {
		return page;
	}


	public void setPage(Long page) {
		if(page == null || page < 1) {
			this.page = 1l;
		} else {
			this.page = page;
		}
		
		this.makeRow();
	}


	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getEndRow() {
		return endRow;
	}
	public void setEndRow(Long endRow) {
		this.endRow = endRow;
	}
	
}
