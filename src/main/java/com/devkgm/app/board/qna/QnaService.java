package com.devkgm.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.devkgm.app.board.BoardDTO;
import com.devkgm.app.board.BoardPager;
import com.devkgm.app.board.BoardService;
import com.devkgm.app.board.FileDTO;
import com.devkgm.app.board.notice.NoticeDTO;
import com.devkgm.app.board.notice.NoticeFileDTO;
import com.devkgm.app.util.FileManager;

@Service
public class QnaService implements BoardService<QnaDTO>{
	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private FileManager fileManager;

	@Override
	public List<QnaDTO> getList(BoardPager boardPager) throws Exception {
		boardPager.setTotalPage(qnaDAO.getTotalPage(boardPager));
		return qnaDAO.getList(boardPager);
	}

	@Override
	public QnaDTO getDetail(QnaDTO qnaDTO) throws Exception {
		qnaDAO.addView(qnaDTO);
		return qnaDAO.getDetail(qnaDTO);
	}

	@Override
	public int add(QnaDTO qnaDTO) throws Exception {
		return qnaDAO.add(qnaDTO);
	}

	@Override
	public int update(QnaDTO qnaDTO, MultipartFile[] files) throws Exception {
		int result = qnaDAO.update(qnaDTO);

		for(MultipartFile file: files) {
			if(file.isEmpty()) continue;
			QnaFileDTO qnaFileDTO = new QnaFileDTO();
			String fileName = fileManager.saveFile("/resources/upload/qna", file);
			String originName = file.getOriginalFilename();
			
			qnaFileDTO.setQna_id(qnaDTO.getId());
			qnaFileDTO.setName(fileName);
			qnaFileDTO.setOrigin_nm(originName);
			
			result = qnaDAO.addFile(qnaFileDTO);
			System.out.println(result);
		}
		return 	result;
	}

	@Override
	public int delete(QnaDTO qnaDTO) throws Exception {
		List<QnaFileDTO> files = qnaDAO.getTotalFile(qnaDTO);
		for(QnaFileDTO file: files) {
			fileManager.deleteFile("/resources/upload/qna", file.getName());
			

		}
		int result=qnaDAO.deleteAllFile(qnaDTO);
		qnaDTO.setIs_deleted(1);
		return qnaDAO.delete(qnaDTO);
	}

	
	public int reply(QnaDTO qnaDTO) throws Exception {
		QnaDTO parent = qnaDAO.getDetail(qnaDTO);
		qnaDTO.setRefs(parent.getRefs());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepths(parent.getDepths()+1);
		
		int result = qnaDAO.replyUpdate(parent);
		
		result = qnaDAO.replyAdd(qnaDTO);
		
		return result;
	}
	public int addFile(QnaFileDTO qnaFileDTO, MultipartFile file) throws Exception {
		String fileName = fileManager.saveFile("/resources/upload/qna", file);
		String originName = file.getOriginalFilename();
		
		qnaFileDTO.setQna_id(qnaFileDTO.getId());
		qnaFileDTO.setName(fileName);
		qnaFileDTO.setOrigin_nm(originName);
		
		int result = qnaDAO.addFile(qnaFileDTO);

		return result;
	}
	
	
	public boolean deleteFile(QnaFileDTO qnaFileDTO) throws Exception {
		boolean result = fileManager.deleteFile("/resources/upload/qna", qnaFileDTO.getName());
		if(result) qnaDAO.deleteFile(qnaFileDTO);
		return result;
	}

}
