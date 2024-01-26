package com.devkgm.app.comment;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDAO {
    @Autowired
    private SqlSession sqlSession;
    private final String namespace = "com.devkgm.app.comment.CommentDAO.";

    public int doAdd(CommentDTO commentDTO) {
        return sqlSession.insert(namespace + "doAdd", commentDTO);
    }

    public List<CommentDTO> getList(CommentDTO commentDTO) {
        return sqlSession.selectList(namespace + "getList", commentDTO);
    }
}
