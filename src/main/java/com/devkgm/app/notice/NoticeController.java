package com.devkgm.app.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception{
		List<NoticeDTO> dtoList = noticeService.getList();
		model.addAttribute("dtoList", dtoList);
	}
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void getDetail(Model model, NoticeDTO noticeDTO) throws Exception{
		noticeDTO = noticeService.getDetail(noticeDTO);
		int result = noticeService.updateHit(noticeDTO);
		model.addAttribute("dto", noticeDTO);
	}
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add(Model model) throws Exception{
	}
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(Model model, NoticeDTO noticeDTO) throws Exception{
		model.addAttribute("dto", noticeDTO);
	}
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Model model, NoticeDTO noticeDTO) throws Exception{
		int result = noticeService.add(noticeDTO);
		String message = "추가 성공";
		if(result == 0) {
			message = "추가 실패";
		}
		model.addAttribute("message", message);
		model.addAttribute("path", "./list");
		return "commons/result";
	}
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(ModelAndView modelAndView, NoticeDTO noticeDTO) throws Exception{
		int result = noticeService.update(noticeDTO);
		String message = "수정 성공";
		
		if(result == 0) {
			message = "수정 실패";
		}
		modelAndView.addObject("message", message);
		modelAndView.addObject("path", "./list");
		modelAndView.setViewName("commons/result");
		return modelAndView;
	}
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(Model model,NoticeDTO noticeDTO) throws Exception{
		int result = noticeService.delete(noticeDTO);
		String message = "삭제 성공";
		
		if(result == 0) {
			message = "삭제 실패";
		}
		model.addAttribute("message", message);
		model.addAttribute("path", "./list");
		return "commons/result";
	}
	
	
}
