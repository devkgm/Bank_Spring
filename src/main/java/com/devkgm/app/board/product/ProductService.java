package com.devkgm.app.board.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.devkgm.app.board.BoardDTO;
import com.devkgm.app.board.BoardPager;
import com.devkgm.app.board.BoardService;
import com.devkgm.app.util.FileManager;

@Service
public class ProductService implements BoardService<ProductDTO>{
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private FileManager fileManager;

	@Override
	public List<ProductDTO> getList(BoardPager boardPager) throws Exception {
		boardPager.setTotalPage(productDAO.getTotalPage());
		System.out.println(boardPager);
		return productDAO.getList(boardPager);
	}

	@Override
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		return productDAO.getDetail(productDTO);
	}

	@Override
	public int add(ProductDTO productDTO, MultipartFile[] files) throws Exception {
		int result = productDAO.add(productDTO);
		
		for(MultipartFile file: files) {
			if(file.isEmpty()) continue;
			ProductFileDTO productFileDTO = new ProductFileDTO();
			String fileName = fileManager.saveFile("/resources/upload/products", file);
			String originName = file.getOriginalFilename();
			
			productFileDTO.setProduct_id(productDTO.getId());
			productFileDTO.setName(fileName);
			productFileDTO.setOrigin_nm(originName);
			
			result = productDAO.addFile(productFileDTO);
		}
		
		return result;
	}

	@Override
	public int update(ProductDTO productDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(ProductDTO productDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Long getTotalPage() throws Exception {
		return productDAO.getTotalPage();
	}

	

}
