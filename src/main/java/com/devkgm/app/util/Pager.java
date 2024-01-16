package com.devkgm.app.util;

public class Pager {
	private Long startRow;
	private Long endRow;
	private Long perPage = 10l;
	private Long page=1l;
	private Long totalPage;
	
	private Long perBlock=5l;
	private Long curBlock;
	private Long startPage;
	private Long lastPage;
	
	private String search;
	private Integer kind;
	
	
	
	
	public Integer getKind() {
		if(this.kind == null) {
			this.kind = 1;
		}
		return kind;
	}
	public void setKind(Integer kind) {
		this.kind = kind;
	}
	public String getSearch() {
		if(this.search == null) {
			this.search = "";
		}
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
	public boolean isStart() {
		return this.curBlock == 1;
	}
	public boolean isLast() {
		return this.curBlock == this.totalPage / this.perBlock + (this.totalPage % this.perBlock > 0? 1 : 0);
	}
	
	public void makeRow() {
		this.endRow = this.page*perPage;
		this.startRow = this.endRow - this.perPage + 1;
	}
	
	
	public void makeCurBlock() {
		this.curBlock = this.page / this.perBlock + (this.page%this.perBlock > 0 ? 1:0);
		
	}
	
	public void makePage() {
		this.startPage = this.curBlock * this.perBlock - this.perBlock + 1;
		if(this.isLast()) {
			this.lastPage = this.totalPage % this.perBlock+ this.startPage-1;
		} else {
			this.lastPage = this.curBlock * this.perBlock; 
		}
	}
	
	public void calc() {
		this.makeRow();
		this.makeCurBlock();
		this.makePage();
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
	}
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage / this.perPage + (totalPage % this.perPage > 0 ? 1 : 0);
		if(this.totalPage < this.page) {
			this.page=1l;
		}
	}
	
	public Long getPerBlock() {
		return perBlock;
	}
	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}
	public Long getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(Long curBlock) {
		this.curBlock = curBlock;
	}
	public Long getStartPage() {
		return startPage;
	}
	public void setStartPage(Long startPage) {
		this.startPage = startPage;
	}
	public Long getLastPage() {
		return lastPage;
	}
	public void setLastPage(Long lastPage) {
		this.lastPage = lastPage;
	}
	
	
	
}
