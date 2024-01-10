package com.devkgm.app.notice;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.devkgm.app.files.FileDTO;

@Service
public class NoticeService {
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private ServletContext servletContext;
	
	public List<NoticeDTO> getList() throws Exception {
		return noticeDAO.getList();
	}
	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.getDetail(noticeDTO);
	}
	public int add(NoticeDTO noticeDTO, MultipartFile file) throws Exception {
		int result = noticeDAO.add(noticeDTO);
		if(file != null && file.getOriginalFilename().length() > 0) {
			NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
			
			addImage(file,noticeFileDTO);
			noticeDAO.addFile(noticeFileDTO);
			
			noticeFileDTO.setNotice_id(noticeDTO.getId());
			int addNoticeFileResult = noticeDAO.addNoticeFile(noticeFileDTO);
			
			noticeDTO.setImage(noticeFileDTO.getName());
			System.out.println(noticeDTO.getImage()+"Service");
			return result  & addNoticeFileResult;
		}
		
		
		return result;
	}
	public NoticeFileDTO addImage(MultipartFile file, NoticeFileDTO noticeFileDTO) throws Exception{
		if(noticeFileDTO == null) noticeFileDTO = new NoticeFileDTO();
		if(file == null) return null;
		String path = servletContext.getRealPath("/resources/upload");
		File f = new File(path,"notices");
		if(!f.exists()) {
			f.mkdirs();
		}
		String originFileName = file.getOriginalFilename();
		String fileName = UUID.randomUUID().toString() + originFileName;
		
		f = new File(f, fileName);
		
		FileCopyUtils.copy(file.getBytes(), f);
		System.out.println(path);
		
		noticeFileDTO.setName(fileName);
		noticeFileDTO.setOrigin_nm(originFileName);
		//noticeDAO.addFile(noticeFileDTO);
		return noticeFileDTO;
	}
	public int update(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.update(noticeDTO);
	}
	public int delete(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.delete(noticeDTO);
	}
	public int updateHit(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.updateHit(noticeDTO);
	}
}
