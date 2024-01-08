package com.devkgm.app;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.devkgm.app.product.ProductDTO;
import com.devkgm.app.util.Pager;

public class DBTest extends MyTest{
	@Autowired
	private SqlSession sqlSession;
	private String namespace = "com.devkgm.app.product.ProductDAO.";
	@Test
	public void test() {
		Pager pager = new Pager();
		pager.setPage(1l);
		List<ProductDTO> list = sqlSession.selectList(namespace+"getList", pager);
		for(ProductDTO dto:list) {
			System.out.println(dto);
		}
		assertEquals(10, list.size());
	}

}
