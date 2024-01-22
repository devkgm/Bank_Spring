package com.devkgm.app.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
    @Autowired
    private SqlSession sqlSession;
    private String namespace = "com.devkgm.app.member.MemberDAO.";

    public int update(MemberDTO memberDTO) throws Exception {
        return sqlSession.update(namespace + "update", memberDTO);
    }

    public MemberDTO getDetail(MemberDTO memberDTO) throws Exception {
        return sqlSession.selectOne(namespace + "getDetail", memberDTO);
    }


    public int join(MemberDTO memberDTO) throws Exception {
        return sqlSession.insert(namespace + "join", memberDTO);
    }

    public MemberDTO getMemberInfo() throws Exception {
        return sqlSession.selectOne(namespace + "getMemberInfo");
    }

    public int addAvatar(AvatarDTO avatarDTO) throws Exception {
        return sqlSession.insert(namespace + "addAvatar", avatarDTO);
    }
}
