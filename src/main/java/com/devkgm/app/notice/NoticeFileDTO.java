package com.devkgm.app.notice;

import com.devkgm.app.files.FileDTO;

public class NoticeFileDTO extends FileDTO{
	private Long notice_id;
	private Long file_id;
	public Long getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(Long notice_id) {
		this.notice_id = notice_id;
	}
	public Long getFile_id() {
		return file_id;
	}
	public void setFile_id(Long file_id) {
		this.file_id = file_id;
	}
	
}
