package com.devkgm.app.account;

import com.devkgm.app.board.BoardPager;
import com.devkgm.app.member.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountDAO accountDAO;

    public int doAdd(AccountDTO accountDTO) throws Exception {
        accountDTO.setAccount_num(createAccountNumber());
        return accountDAO.doAdd(accountDTO);
    }

    public Long createAccountNumber() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return Long.parseLong(sdf.format(System.currentTimeMillis()));
    }

    public List<AccountDTO> getList(MemberDTO memberDTO, BoardPager pager) throws Exception {
        return accountDAO.getList(memberDTO, pager);
    }
}
