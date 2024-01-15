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
		boardPager.setTotalPage(qnaDAO.getTotalPage());
		return qnaDAO.getList(boardPager);
	}

	@Override
	public QnaDTO getDetail(QnaDTO qnaDTO) throws Exception {
		return qnaDAO.getDetail(qnaDTO);
	}

	@Override
	public int add(QnaDTO qnaDTO) throws Exception {
		return qnaDAO.add(qnaDTO);
	}

	@Override
	public int update(QnaDTO qnaDTO, MultipartFile[] file) throws Exception {
		return qnaDAO.update(qnaDTO);
	}

	@Override
	public int delete(QnaDTO qnaDTO) throws Exception {
		return qnaDAO.delete(qnaDTO);
	}

	@Override
	public Long getTotalPage() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
