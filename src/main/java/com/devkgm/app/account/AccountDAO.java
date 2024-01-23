package com.devkgm.app.account;

import com.devkgm.app.board.BoardPager;
import com.devkgm.app.member.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDAO {
    @Autowired
    private SqlSession sqlSession;
    private final String NAMESPACE = "com.devkgm.app.account.AccountDAO.";

    public int doAdd(AccountDTO accountDTO) {
        return sqlSession.insert(NAMESPACE + "doAdd", accountDTO);
    }

    public List<AccountDTO> getList(MemberDTO memberDTO, BoardPager pager) {
        return sqlSession.selectList(NAMESPACE + "getList", memberDTO);
    }

}
