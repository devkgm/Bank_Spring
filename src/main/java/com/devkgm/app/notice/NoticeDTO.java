package com.devkgm.app.notice;

import java.sql.Date;


public class NoticeDTO {
	private Long id;
	private String title;
	private String description;
	private Date create_dt;
	private int hit;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreate_dt() {
		return create_dt;
	}
	public void setCreate_dt(Date create_dt) {
		this.create_dt = create_dt;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
}
