package com.devkgm.app.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devkgm.app.board.BoardDAO;
import com.devkgm.app.board.BoardPager;

@Repository
public class QnaDAO implements BoardDAO<QnaDTO> {
    @Autowired
    private SqlSession sqlSession;
    private String namespace = "com.devkgm.app.board.qna.QnaDAO.";

    @Override
    public List<QnaDTO> getList(BoardPager boardPager) throws Exception {
        return sqlSession.selectList(namespace + "getList", boardPager);
    }

    @Override
    public QnaDTO getDetail(QnaDTO qnaDTO) throws Exception {
        return sqlSession.selectOne(namespace + "getDetail", qnaDTO);
    }

    @Override
    public int add(QnaDTO qnaDTO) throws Exception {
        return sqlSession.insert(namespace + "add", qnaDTO);
    }

    @Override
    public int update(QnaDTO qnaDTO) throws Exception {
        return sqlSession.update(namespace + "update", qnaDTO);
    }

    @Override
    public int delete(QnaDTO qnaDTO) throws Exception {
        return sqlSession.update(namespace + "delete", qnaDTO);
    }

    @Override
    public Long getTotalPage(BoardPager boardPager) throws Exception {
        return sqlSession.selectOne(namespace + "getTotalPage", boardPager);
    }

    public int replyUpdate(QnaDTO qnaDTO) throws Exception {
        return sqlSession.update(namespace + "replyUpdate", qnaDTO);
    }

    public int replyAdd(QnaDTO qnaDTO) throws Exception {
        return sqlSession.insert(namespace + "replyAdd", qnaDTO);
    }

    public int addFile(QnaFileDTO qnaFileDTO) throws Exception {
        return sqlSession.insert(namespace + "addFile", qnaFileDTO);
    }

    public int deleteFile(QnaFileDTO qnaFileDTO) throws Exception {
        return sqlSession.delete(namespace + "deleteFile", qnaFileDTO);
    }

    public int deleteAllFile(QnaDTO qnaDTO) throws Exception {
        return sqlSession.delete(namespace + "deleteAllFile", qnaDTO);
    }

    public List<QnaFileDTO> getTotalFile(QnaDTO qnaDTO) throws Exception {
        return sqlSession.selectList(namespace + "getTotalFile", qnaDTO);
    }

    public int addView(QnaDTO qnaDTO) throws Exception {
        return sqlSession.update(namespace + "addView", qnaDTO);
    }

}
