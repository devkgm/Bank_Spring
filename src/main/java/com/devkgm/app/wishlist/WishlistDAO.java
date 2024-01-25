package com.devkgm.app.wishlist;


import com.devkgm.app.account.AccountDTO;
import com.devkgm.app.board.product.ProductDTO;
import com.devkgm.app.member.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class WishlistDAO {
    @Autowired
    private SqlSession sqlSession;
    private final String NAMESPACE = "com.devkgm.app.wishlist.WishlistDAO.";

    public List<ProductDTO> getList(MemberDTO memberDTO) throws Exception {
        return sqlSession.selectList(NAMESPACE + "getList", memberDTO);
    }

    public int doAdd(AccountDTO accountDTO) throws Exception {
        return sqlSession.insert(NAMESPACE + "doAdd", accountDTO);
    }

    public int doDelete(Map<String, Object> map) throws Exception {
        return sqlSession.delete(NAMESPACE + "doDelete", map);
    }
}
