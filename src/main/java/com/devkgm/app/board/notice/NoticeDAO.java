package com.devkgm.app.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devkgm.app.board.BoardDAO;
import com.devkgm.app.board.BoardPager;

@Repository
public class NoticeDAO implements BoardDAO<NoticeDTO> {
    @Autowired
    private SqlSession sqlSession;
    private String namespace = "com.devkgm.app.board.notice.NoticeDAO.";

    @Override
    public List<NoticeDTO> getList(BoardPager boardPager) throws Exception {
        return sqlSession.selectList(namespace + "getList", boardPager);
    }

    @Override
    public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception {
        return sqlSession.selectOne(namespace + "getDetail", noticeDTO);
    }

    @Override
    public int add(NoticeDTO noticeDTO) throws Exception {
        return sqlSession.insert(namespace + "add", noticeDTO);
    }

    @Override
    public int update(NoticeDTO noticeDTO) throws Exception {
        return sqlSession.update(namespace + "update", noticeDTO);
    }

    @Override
    public int delete(NoticeDTO noticeDTO) throws Exception {
        return sqlSession.delete(namespace + "delete", noticeDTO);
    }

    @Override
    public Long getTotalPage(BoardPager boardPager) throws Exception {
        return sqlSession.selectOne(namespace + "getTotalPage", boardPager);
    }

    public int addFile(NoticeFileDTO noticeFileDTO) throws Exception {
        return sqlSession.insert(namespace + "addFile", noticeFileDTO);
    }

    public int deleteFile(NoticeFileDTO noticeFileDTO) throws Exception {
        return sqlSession.delete(namespace + "deleteFile", noticeFileDTO);
    }
}
