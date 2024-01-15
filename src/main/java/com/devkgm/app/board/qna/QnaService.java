package com.devkgm.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.devkgm.app.board.BoardPager;
import com.devkgm.app.board.BoardService;

@Service
public class QnaService implements BoardService<QnaDTO>{
	@Autowired
	private QnaDAO qnaDAO;

	@Override
	public List<QnaDTO> getList(BoardPager boardPager) throws Exception {
		return qnaDAO.getList(boardPager);
	}

	@Override
	public QnaDTO getDetail(QnaDTO t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(QnaDTO t) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(QnaDTO t, MultipartFile[] file) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(QnaDTO t) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Long getTotalPage() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
