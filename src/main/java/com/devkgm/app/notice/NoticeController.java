package com.devkgm.app.notice;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.core.io.Resource; 
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.awt.image.BufferedImage;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private ServletContext servletContext;
	
//	@RequestMapping(value = "file/{imageUrl}", method = RequestMethod.GET)
//    public ResponseEntity<byte[]> getImage(@PathVariable String imageUrl) {
//        try {
//        	String path = "file:"+servletContext.getRealPath("/resources/upload/notices")+File.separator+imageUrl+".jpeg";
//            URL url = new URL(path);
//            BufferedImage image = ImageIO.read(url);
//            
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            ImageIO.write(image, "jpg", byteArrayOutputStream);
//            byte[] imageBytes = byteArrayOutputStream.toByteArray();
//            
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.IMAGE_JPEG); 
//            
//            return new ResponseEntity<byte[]>(imageBytes, headers, HttpStatus.OK);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    
    
    @RequestMapping(value="addImage", method = RequestMethod.POST)
    @ResponseBody
    public NoticeFileDTO addImage(MultipartFile image,HttpServletResponse response) throws Exception {
    	NoticeFileDTO noticeFileDTO = noticeService.addImage(image);
    	return noticeFileDTO;
    }
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception{
		List<NoticeDTO> dtoList = noticeService.getList();
		model.addAttribute("dtoList", dtoList);
	}
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void getDetail(Model model, NoticeDTO noticeDTO) throws Exception{
		noticeDTO = noticeService.getDetail(noticeDTO);
		List<NoticeFileDTO> list = noticeDTO.getNoticeFileDTOs();
		for(NoticeFileDTO iDto : list) {
			System.out.println(iDto.getName());
		}
		int result = noticeService.updateHit(noticeDTO);
		model.addAttribute("dto", noticeDTO);
	}
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add(Model model) throws Exception{
	}
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(Model model, NoticeDTO noticeDTO) throws Exception{
		noticeDTO = noticeService.getDetail(noticeDTO);
		model.addAttribute("dto", noticeDTO);
	}
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Model model, NoticeDTO noticeDTO, MultipartFile[] photo) throws Exception{
		int result = noticeService.add(noticeDTO, photo);
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
