package com.devkgm.app.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devkgm.app.board.BoardDAO;
import com.devkgm.app.board.BoardPager;

@Repository
public class QnaDAO implements BoardDAO<QnaDTO>{
	@Autowired
	private SqlSession sqlSession;
	private String namespace = "com.devkgm.app.board.qna.QnaDAO.";

	@Override
	public List<QnaDTO> getList(BoardPager boardPager) throws Exception {
		return sqlSession.selectList(namespace+"getList", boardPager);
	}

	@Override
	public QnaDTO getDetail(QnaDTO qnaDTO) throws Exception {
		return sqlSession.selectOne(namespace+"getDetail", qnaDTO);
	}

	@Override
	public int add(QnaDTO qnaDTO) throws Exception {
		return sqlSession.insert(namespace+"add", qnaDTO);
	}

	@Override
	public int update(QnaDTO qnaDTO) throws Exception {
		return sqlSession.update(namespace+"update", qnaDTO);
	}

	@Override
	public int delete(QnaDTO qnaDTO) throws Exception {
		return sqlSession.delete(namespace+"delete", qnaDTO);
	}

	@Override
	public Long getTotalPage() throws Exception {
		return sqlSession.selectOne(namespace+"getTotalPage");
	}

}
