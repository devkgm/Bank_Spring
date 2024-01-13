package com.devkgm.app.board.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devkgm.app.board.BoardDTO;
import com.devkgm.app.board.BoardPager;
import com.devkgm.app.board.BoardService;

@Service
public class ProductService implements BoardService<ProductDTO>{
	@Autowired
	private ProductDAO productDAO;

	@Override
	public List<ProductDTO> getList(BoardPager boardPager) throws Exception {
		boardPager.setTotalPage(productDAO.getTotalPage());
		System.out.println(boardPager);
		return productDAO.getList(boardPager);
	}

	@Override
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		return productDAO.getDetail(productDTO);
	}

	@Override
	public int add(ProductDTO productDTO) throws Exception {
		return productDAO.add(productDTO);
	}

	@Override
	public int update(ProductDTO productDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(ProductDTO productDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Long getTotalPage() throws Exception {
		return productDAO.getTotalPage();
	}

	

}
