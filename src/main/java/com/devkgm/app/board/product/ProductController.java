package com.devkgm.app.board.product;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	public void add(ProductDTO productDTO,Model model) throws Exception{
		int result = productService.add(productDTO);
		model.addAttribute("dto", productDTO);
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(ProductDTO productDTO,MultipartFile[] attach, Model model) throws Exception{
		int result = productService.update(productDTO, attach);
		String path = "product/list";
		String message = "추가 실패.";
		if(result > 0) {
			message = "추가 성공.";
		}
		model.addAttribute("message",message);
		model.addAttribute("path",path);
		return "commons/result";
	}
	
	@RequestMapping(value="update", method = RequestMethod.GET)
	public void update(Model model, ProductDTO productDTO) throws Exception{
		productDTO = productService.getDetail(productDTO);
		model.addAttribute("dto",productDTO);
	}
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String update(Model model,MultipartFile[] attach,  ProductDTO productDTO) throws Exception{
		int result = productService.update(productDTO, attach);
		String path = "product/list";
		String message = "수정 실패.";
		if(result > 0) {
			message = "수정 성공.";
		}
		model.addAttribute("message",message);
		model.addAttribute("path",path);
		return "commons/result";
	}
	
	@RequestMapping(value="addFile", method = RequestMethod.POST)
	@ResponseBody
	public ProductFileDTO addFile(ProductFileDTO productFileDTO, MultipartFile attach) throws Exception{
		int result = productService.addFile(productFileDTO,attach);
		return productFileDTO;
	}
	@RequestMapping(value="addTumbnail", method = RequestMethod.POST)
	@ResponseBody
	public void addTumbnail(ProductDTO productDTO, MultipartFile attach) throws Exception{
		int result = productService.addThumbnail(productDTO,attach);
	}
	@RequestMapping(value="deleteThumbnail", method = RequestMethod.POST)
	@ResponseBody
	public void deleteThumbnail(ProductFileDTO productFileDTO) throws Exception{
		boolean result = productService.deleteThumbnail(productFileDTO);
	}
	
	@RequestMapping(value="deleteFile", method = RequestMethod.POST)
	@ResponseBody
	public void deleteFile(ProductFileDTO productFileDTO) throws Exception{
		boolean result = productService.deleteFile(productFileDTO);
	}
}
