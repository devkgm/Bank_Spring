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
	public List<NoticeDTO> getList() throws Exception{
		return sqlSession.selectList(namespace+"getList");
	}
	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.selectOne(namespace+"getDetail",noticeDTO);
	}
	public int add(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.insert(namespace+"add",noticeDTO);
	}
	public int update(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.update(namespace+"update",noticeDTO);
	}
	public int delete(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.delete(namespace+"delete",noticeDTO);
	}
	public int deleteFile(NoticeFileDTO noticeFileDTO) throws Exception{
		return sqlSession.delete(namespace+"deleteFile",noticeFileDTO);
	}
	public int updateHit(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.update(namespace+"updateHit",noticeDTO);
	}
	public int addFile(NoticeFileDTO noticeFileDTO) throws Exception{
		return sqlSession.insert(namespace+"addFile", noticeFileDTO);
	}
	public int addNoticeFile(NoticeFileDTO noticeFileDTO) throws Exception{
		return sqlSession.insert(namespace+"addNoticeFile", noticeFileDTO);
	}
	
	public List<NoticeFileDTO> getFileList(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.selectList(namespace+"getFileList", noticeDTO);
	}
}
