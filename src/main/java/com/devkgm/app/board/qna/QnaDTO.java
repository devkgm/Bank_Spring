package com.devkgm.app.board.qna;

import com.devkgm.app.board.BoardDTO;

public class QnaDTO extends BoardDTO<QnaFileDTO>{
	private Integer is_deleted;

	public Integer getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(Integer is_deleted) {
		this.is_deleted = is_deleted;
	}
	
	
}
