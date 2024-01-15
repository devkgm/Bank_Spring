package com.devkgm.app.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devkgm.app.board.BoardDAO;
import com.devkgm.app.board.BoardPager;

@Repository
public class NoticeDAO implements BoardDAO<NoticeDTO>{
	@Autowired
	private SqlSession sqlSession;
	private String namespace = "com.devkgm.app.board.notice.NoticeDAO.";
	
	@Override
	public List<NoticeDTO> getList(BoardPager boardPager) throws Exception {
		return sqlSession.selectList(namespace+"getList", boardPager);
	}

	@Override
	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.selectOne(namespace+"getDetail", noticeDTO);
	}

	@Override
	public int add(NoticeDTO t) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(NoticeDTO t) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(NoticeDTO t) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Long getTotalPage() throws Exception {
		return sqlSession.selectOne(namespace+"getTotalPage");
	}

}
