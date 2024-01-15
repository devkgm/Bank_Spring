package com.devkgm.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.devkgm.app.board.BoardPager;
import com.devkgm.app.board.BoardService;

@Service
public class NoticeService implements BoardService<NoticeDTO>{
	
	@Autowired
	private NoticeDAO noticeDAO;
		
	@Override
	public List<NoticeDTO> getList(BoardPager boardPager) throws Exception {
		boardPager.setTotalPage(noticeDAO.getTotalPage());
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
	public int update(NoticeDTO noticeDTO, MultipartFile[] file) throws Exception {
		return noticeDAO.update(noticeDTO);
	}

	@Override
	public int delete(NoticeDTO t) throws Exception {
		return noticeDAO.delete(t);
	}

	@Override
	public Long getTotalPage() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
