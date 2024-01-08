package com.devkgm.app;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DBTest extends MyTest{
	@Autowired
	private SqlSession sqlSession;

	@Test
	public void test() {
		assertNotNull(sqlSession);
	}

}
