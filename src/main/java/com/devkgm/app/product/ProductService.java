package com.devkgm.app.product;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devkgm.app.util.Pager;

import oracle.jdbc.Const;


@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;
	
	public List<ProductDTO> getList(Pager pager) throws Exception {
		Long totalPage = this.productDAO.getTotalPage(pager);
		pager.setTotalPage(totalPage);
		pager.calc();
		return this.productDAO.getList(pager);
	}
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception{
		return this.productDAO.getDetail(productDTO);
	}
	public int add(ProductDTO productDTO) throws Exception {
		return this.productDAO.add(productDTO);
	}
	public int update(ProductDTO productDTO) throws Exception {
		return this.productDAO.update(productDTO);
	}
	public int delete(ProductDTO productDTO) throws Exception{
		return this.productDAO.delete(productDTO);
	}
	
}
