package com.devkgm.app;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.devkgm.app.board.product.ProductDTO;

public class DBTest extends MyTest {
    @Autowired
    private SqlSession sqlSession;
    private String namespace = "com.devkgm.app.board.product.ProductDAO.";

    //@Test
    public void test() throws Exception {

        for (int i = 1; i <= 100; i++) {
            Double rate = Math.random() * 5;
            Long sale = (long) Math.random() * 2;

            ProductDTO productDTO = new ProductDTO();
            productDTO.setName("Test" + i);
            productDTO.setContent("Test Content" + i);
            productDTO.setRate(rate);
            productDTO.setIs_sale(sale);
            ;
            sqlSession.insert(namespace + "add", productDTO);

            if (i % 10 == 0)
                Thread.sleep(500);
        }
    }

}
