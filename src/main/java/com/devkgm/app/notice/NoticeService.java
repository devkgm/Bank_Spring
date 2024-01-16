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
import com.devkgm.app.util.FileManager;

@Service
public class NoticeService {
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileManager fileManager;
	
	public List<NoticeDTO> getList() throws Exception {
		return noticeDAO.getList();
	}
	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.getDetail(noticeDTO);
	}
	public int add(NoticeDTO noticeDTO, MultipartFile[] file) throws Exception {
		int result = noticeDAO.add(noticeDTO);
		for(MultipartFile f: file) {
			if(!f.isEmpty()) {
				String path = servletContext.getRealPath("/resources/upload/notices");
				
				String fileName = fileManager.fileSave(path, f);
				
				
				NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
				noticeFileDTO.setName(fileName);
				noticeFileDTO.setOrigin_nm(f.getOriginalFilename());
				noticeFileDTO.setNotice_id(noticeDTO.getId());
				result = noticeDAO.addFile(noticeFileDTO);
				
			}
			
		}
		
		
		return result;
	}
	public int update(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.update(noticeDTO);
	}
	public int delete(NoticeDTO noticeDTO) throws Exception {
		List<NoticeFileDTO> list = noticeDAO.getFileList(noticeDTO);
		int result = noticeDAO.delete(noticeDTO);
		for(NoticeFileDTO dto:list) {
			noticeDAO.deleteFile(dto);
			
			String path = servletContext.getRealPath("/resources/upload/notices");
			boolean deleteResult = fileManager.fileDelete(path,dto.getName());
			
		}
		
		return result;
	}
	public int updateHit(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.updateHit(noticeDTO);
	}
	public NoticeFileDTO addImage(MultipartFile file) throws Exception {
		NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
		String path = servletContext.getRealPath("/resources/upload/notices");
		noticeFileDTO.setName(fileManager.fileSave(path, file));
		return noticeFileDTO;
	}
}
