package com.devkgm.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.devkgm.app.board.BoardPager;
import com.devkgm.app.board.BoardService;
import com.devkgm.app.board.product.ProductFileDTO;
import com.devkgm.app.util.FileManager;

@Service
public class NoticeService implements BoardService<NoticeDTO>{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileManager fileManager;
		
	@Override
	public List<NoticeDTO> getList(BoardPager boardPager) throws Exception {
		boardPager.setTotalPage(noticeDAO.getTotalPage(boardPager));
		return noticeDAO.getList(boardPager);	
	}

	@Override
	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.getDetail(noticeDTO);
	}

	@Override
	public int add(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.add(noticeDTO);
	}

	@Override
	public int update(NoticeDTO noticeDTO, MultipartFile[] files) throws Exception {
		int result = noticeDAO.update(noticeDTO);

		for(MultipartFile file: files) {
			if(file.isEmpty()) continue;
			NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
			String fileName = fileManager.saveFile("/resources/upload/notice", file);
			String originName = file.getOriginalFilename();
			
			noticeFileDTO.setNotice_id(noticeDTO.getId());
			noticeFileDTO.setName(fileName);
			noticeFileDTO.setOrigin_nm(originName);
			
			result = noticeDAO.addFile(noticeFileDTO);
			System.out.println(result);
		}
		return 	result;
	}
	
	public int addFile(NoticeFileDTO noticeFileDTO, MultipartFile file) throws Exception {
		String fileName = fileManager.saveFile("/resources/upload/notice", file);
		String originName = file.getOriginalFilename();
		
		noticeFileDTO.setNotice_id(noticeFileDTO.getId());
		noticeFileDTO.setName(fileName);
		noticeFileDTO.setOrigin_nm(originName);
		
		int result = noticeDAO.addFile(noticeFileDTO);

		return result;
	}

	@Override
	public int delete(NoticeDTO t) throws Exception {
		return noticeDAO.delete(t);
	}
	
	public boolean deleteFile(NoticeFileDTO noticeFileDTO) throws Exception {
		boolean result = fileManager.deleteFile("/resources/upload/notice", noticeFileDTO.getName());
		if(result) noticeDAO.deleteFile(noticeFileDTO);
		return result;
	}

}
