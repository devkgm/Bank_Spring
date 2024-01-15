package com.devkgm.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.devkgm.app.board.BoardPager;

@Controller
@RequestMapping("/qna/*")
public class QnaController{
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("list")
	public String list(BoardPager boardPager, Model model) throws Exception{
		List<QnaDTO> list = qnaService.getList(boardPager);
		model.addAttribute("pager", boardPager);
		model.addAttribute("list", list);
		return "board/list";
	}
	
	@GetMapping("detail/{id}")
	public String detail(Model model, @PathVariable Long id, QnaDTO qnaDTO) throws Exception {
		qnaDTO = qnaService.getDetail(qnaDTO);
		model.addAttribute("dto", qnaDTO);
		
		return "board/detail";
	}
	
	@GetMapping("add")
	public String add(Model model, QnaDTO qnaDTO) throws Exception{
		qnaService.add(qnaDTO);
		model.addAttribute("dto", qnaDTO);
		return "board/add";
	}
	
	@PostMapping("add")
	public String add(Model model, QnaDTO qnaDTO, MultipartFile[] attach) throws Exception{
		qnaService.update(qnaDTO, attach);
		
		return "redirect:./list";
	}
	
	@GetMapping("update")
	public String update(Model model, QnaDTO qnaDTO) throws Exception{
		qnaDTO = qnaService.getDetail(qnaDTO);
		model.addAttribute("dto", qnaDTO);
		return "board/update";
	}
	
	@PostMapping("update")
	public String update(Model model, QnaDTO qnaDTO, MultipartFile[] attach) throws Exception{
		qnaService.update(qnaDTO, attach);
		
		return "redirect:./list";
	}
	
	@GetMapping("delete")
	public String delete(Model model, QnaDTO qnaDTO) throws Exception{
		qnaService.delete(qnaDTO);
		return "redirect:./list";
	}
	
}
