package com.devkgm.app.board.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devkgm.app.board.BoardDTO;
import com.devkgm.app.board.BoardPager;
import com.devkgm.app.board.BoardService;

@Controller
@RequestMapping(value = "/product/*")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void list(Model model,BoardPager boardPager) throws Exception{
		List<ProductDTO> list = productService.getList(boardPager);
		model.addAttribute("list", list);
		model.addAttribute("pager", boardPager);
	}
	@RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
	public String detail(Model model, @PathVariable Long id) throws Exception{
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(id);
		productDTO = productService.getDetail(productDTO);
		model.addAttribute("dto", productDTO);
		return "product/detail";
	}
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {
		
	}
}
