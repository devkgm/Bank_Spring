package com.devkgm.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devkgm.app.board.BoardPager;

@Controller
@RequestMapping("/qna/*")
public class QnaController{
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("list")
	public void list(BoardPager boardPager, Model model) throws Exception{
		List<QnaDTO> list = qnaService.getList(boardPager);
		model.addAttribute("list", list);
	}
}
