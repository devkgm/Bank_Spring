package com.devkgm.app.board.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
    @Autowired
    private SqlSession sqlSession;
    private String namespace = "com.devkgm.app.board.member.MemberDAO.";

    public int join(MemberDTO memberDTO) throws Exception {
        return sqlSession.insert(namespace + "join", memberDTO);
    }

    public MemberDTO getMemberInfo() throws Exception {
        return sqlSession.selectOne(namespace + "getMemberInfo");
    }
}
