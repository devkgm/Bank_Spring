package com.devkgm.app.board.notice;

import com.devkgm.app.board.BoardDTO;

public class NoticeDTO extends BoardDTO<NoticeFileDTO>{

	@Override
	public String toString() {
		return "NoticeDTO [getFileDTOs()=" + getFileDTOs() + ", getPager()=" + getPager() + ", getId()=" + getId()
				+ ", getTitle()=" + getTitle() + ", getWriter()=" + getWriter() + ", getContent()=" + getContent()
				+ ", getCreate_dt()=" + getCreate_dt() + ", getViews()=" + getViews() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
