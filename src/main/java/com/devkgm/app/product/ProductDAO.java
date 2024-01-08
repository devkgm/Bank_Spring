package com.devkgm.app.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devkgm.app.util.Pager;

@Repository
public class ProductDAO {
	@Autowired
	private SqlSession sqlSession;
	
	private final String namespace = "com.devkgm.app.product.ProductDAO.";
	
	public List<ProductDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(namespace+"getList", pager);
	}
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception{
		return sqlSession.selectOne(namespace+"getDetail",productDTO);
	}
	public int add(ProductDTO productDTO) throws Exception{
		return sqlSession.insert(namespace+"add",productDTO);
	}
	public int update(ProductDTO productDTO) throws Exception{
		return sqlSession.update(namespace+"update", productDTO);
	}
	public int delete(ProductDTO productDTO) throws Exception{
		return sqlSession.delete(namespace+"delete", productDTO);
	}
}
