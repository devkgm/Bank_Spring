package com.devkgm.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.devkgm.app.util.Pager;

@Controller
@RequestMapping(value = "/products/*")
public class ProductController {	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(Model model, Pager pager) throws Exception{
		List<ProductDTO> list = productService.getList(pager);
				
		model.addAttribute("list", list);
		model.addAttribute("pager", pager);
		return "products/list";
	}
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detail( Model model, ProductDTO productDTO) throws Exception{
		productDTO = productService.getDetail(productDTO);
		model.addAttribute("dto", productDTO);
		return "products/detail";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String add( ) throws Exception{
		return "products/add";
	}
	
	
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public ModelAndView update(ModelAndView modelAndView, ProductDTO productDTO) throws Exception{
		modelAndView.addObject("dto",productDTO);
		return modelAndView;
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add( Model model, ProductDTO productDTO) throws Exception{
		int result = productService.add(productDTO);
		String resultString = "추가 성공";
		if(result == 0) {
			resultString = "추가 실패";
		}
		model.addAttribute("message",resultString);
		model.addAttribute("path","./list");
		return "commons/result";
	}
	
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update( Model model, ProductDTO productDTO) throws Exception{
		int result = productService.update(productDTO);
		String resultString = "수정 성공";
		if(result == 0) {
			resultString = "수정 실패";
		}
		model.addAttribute("message",resultString);
		model.addAttribute("path","./list");
		return "commons/result";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public String delete( Model model, ProductDTO productDTO) throws Exception{
		int result = productService.delete(productDTO);
		String resultString = "삭제 성공";
		if(result == 0) {
			resultString = "삭제 실패";
		}
		model.addAttribute("message",resultString);
		model.addAttribute("path","./list");
		return "commons/result";
	}
	
}
