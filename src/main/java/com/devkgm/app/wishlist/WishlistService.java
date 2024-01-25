package com.devkgm.app.wishlist;

import com.devkgm.app.account.AccountDTO;
import com.devkgm.app.board.product.ProductDTO;
import com.devkgm.app.member.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WishlistService {
    @Autowired
    private WishlistDAO wishlistDAO;

    public int doAdd(AccountDTO accountDTO) throws Exception {
        return wishlistDAO.doAdd(accountDTO);
    }

    public List<ProductDTO> getList(MemberDTO memberDTO) throws Exception {
        return wishlistDAO.getList(memberDTO);
    }

    public int doDelete(Map<String, Object> map) throws Exception {
        return wishlistDAO.doDelete(map);
    }

}
