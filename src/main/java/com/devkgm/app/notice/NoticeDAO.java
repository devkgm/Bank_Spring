package com.devkgm.app.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "com.devkgm.app.notice.NoticeDAO.";
	public List<NoticeDTO> getList() {
		return sqlSession.selectList(namespace+"getList");
	}
	public NoticeDTO getDetail(NoticeDTO noticeDTO) {
		return sqlSession.selectOne(namespace+"getDetail",noticeDTO);
	}
	public int add(NoticeDTO noticeDTO) {
		return sqlSession.insert(namespace+"add",noticeDTO);
	}
	public int update(NoticeDTO noticeDTO) {
		return sqlSession.update(namespace+"update",noticeDTO);
	}
	public int delete(NoticeDTO noticeDTO) {
		return sqlSession.delete(namespace+"delete",noticeDTO);
	}
	public int updateHit(NoticeDTO noticeDTO) {
		return sqlSession.update(namespace+"updateHit",noticeDTO);
	}
}
