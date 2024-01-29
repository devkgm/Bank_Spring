package com.devkgm.app;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.devkgm.app.board.product.ProductDTO;

public class DBTest extends MyTest {
    @Autowired
    private SqlSession sqlSession;
    private String namespace = "com.devkgm.app.board.product.ProductDAO.";

    @Test
    public void test() throws Exception {
        assert (true);
    }

}
