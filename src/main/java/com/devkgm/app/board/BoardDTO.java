package com.devkgm.app.board;

import java.sql.Date;
import java.util.List;


public class BoardDTO<T> {
	private Long id;
	private String title;
	private String writer;
	private String content;
	private Date create_dt;
	private Long views;
	private BoardPager pager;
	private List<T> fileDTOs;
	
	
	
	
	

	public List<T> getFileDTOs() {
		return fileDTOs;
	}
	public void setFileDTOs(List<T> fileDTOs) {
		this.fileDTOs = fileDTOs;
	}
	public BoardPager getPager() {
		return pager;
	}
	public void setPager(BoardPager pager) {
		this.pager = pager;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreate_dt() {
		return create_dt;
	}
	public void setCreate_dt(Date create_dt) {
		this.create_dt = create_dt;
	}
	public Long getViews() {
		return views;
	}
	public void setViews(Long views) {
		this.views = views;
	}
	
	
}
