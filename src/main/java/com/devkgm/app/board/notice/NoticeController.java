package com.devkgm.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devkgm.app.board.BoardPager;

import oracle.net.aso.m;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;

	@GetMapping("list")
	public void list(BoardPager boardPager, Model model) throws Exception{
		List<NoticeDTO> list = noticeService.getList(boardPager);
		model.addAttribute("pager", boardPager);
		model.addAttribute("list", list);
	}
	
	@GetMapping("detail/{id}")
	public String detail(Model model, @PathVariable Long id) throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setId(id);
		noticeDTO = noticeService.getDetail(noticeDTO);
		model.addAttribute("dto", noticeDTO);
		return "notice/detail";
	}
}
