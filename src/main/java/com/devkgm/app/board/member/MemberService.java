package com.devkgm.app.board.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberDAO memberDAO;

    public int join(MemberDTO memberDTO) throws Exception {
        return memberDAO.join(memberDTO);
    }

    public MemberDTO getMemberInfo() throws Exception {
        return memberDAO.getMemberInfo();
    }
}
