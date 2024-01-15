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
	public int update(QnaDTO t) throws Exception {
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
