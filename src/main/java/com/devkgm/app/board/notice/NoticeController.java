package com.devkgm.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.devkgm.app.board.BoardPager;
import com.devkgm.app.board.product.ProductFileDTO;

import oracle.net.aso.m;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}

	@GetMapping("list")
	public String list(BoardPager boardPager, Model model) throws Exception{
		List<NoticeDTO> list = noticeService.getList(boardPager);
		model.addAttribute("pager", boardPager);
		model.addAttribute("list", list);

		return "board/list";
	}
	
	@GetMapping("detail/{id}")
	public String detail(Model model, @PathVariable Long id) throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setId(id);
		noticeDTO = noticeService.getDetail(noticeDTO);
		model.addAttribute("dto", noticeDTO);
		return "board/detail";
	}
	
	@GetMapping("add")
	public String add(Model model, NoticeDTO noticeDTO) throws Exception{
		noticeService.add(noticeDTO);
		model.addAttribute("dto", noticeDTO);
		return "board/add";
	}
	@PostMapping("add")
	public String add(Model model, NoticeDTO noticeDTO, MultipartFile[] attach) throws Exception{
		int result = noticeService.update(noticeDTO, attach);
		
		String path = "notice/list";
		String message = "추가 실패.";
		if(result > 0) {
			message = "추가 성공.";
		}
		model.addAttribute("message",message);
		model.addAttribute("path",path);
		return "redirect:./list";
	}
	@GetMapping("update")
	public String update(Model model, NoticeDTO noticeDTO) throws Exception{
		noticeDTO = noticeService.getDetail(noticeDTO);
		System.out.println(noticeDTO);
		model.addAttribute("dto", noticeDTO);
		return "board/update";
	}
	@PostMapping("update")
	public String update(Model model, NoticeDTO noticeDTO, MultipartFile[] attach) throws Exception{
		int result = noticeService.update(noticeDTO, attach);
		
		String path = "notice/list";
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
	public NoticeFileDTO addFile(NoticeFileDTO noticeFileDTO, MultipartFile attach) throws Exception{
		int result = noticeService.addFile(noticeFileDTO,attach);
		return noticeFileDTO;
	}
	
	@GetMapping("delete")
	public String delete(Model model, NoticeDTO noticeDTO) throws Exception{
		int result = noticeService.delete(noticeDTO);
		
		String path = "notice/list";
		String message = "삭제 실패.";
		if(result > 0) {
			message = "삭제 성공.";
		}
		model.addAttribute("message",message);
		model.addAttribute("path",path);
		return "commons/result";
	}
	
	@RequestMapping(value="deleteFile", method = RequestMethod.POST)
	@ResponseBody
	public void deleteFile(NoticeFileDTO noticeFileDTO) throws Exception{
		boolean result = noticeService.deleteFile(noticeFileDTO);
	}
	
}
