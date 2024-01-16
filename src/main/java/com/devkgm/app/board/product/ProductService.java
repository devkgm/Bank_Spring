package com.devkgm.app.board.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	public int add(ProductDTO productDTO) throws Exception {
		int result = productDAO.add(productDTO);
		
		return result;
	}
	
	@Override
	public int update(ProductDTO productDTO, MultipartFile[] files) throws Exception {
		int result = productDAO.update(productDTO);
		System.out.println(result);
		for(MultipartFile file: files) {
			if(file.isEmpty()) continue;
			ProductFileDTO productFileDTO = new ProductFileDTO();
			String fileName = fileManager.saveFile("/resources/upload/products", file);
			String originName = file.getOriginalFilename();
			
			productFileDTO.setProduct_id(productDTO.getId());
			productFileDTO.setName(fileName);
			productFileDTO.setOrigin_nm(originName);
			
			result = productDAO.addThumbnail(productFileDTO);
			System.out.println(result);
		}
		
		return result;
	}
	
	@Override
	public int delete(ProductDTO productDTO) throws Exception {
		List<ProductFileDTO> fileList = productDAO.getTotalImage(productDTO);
		for(ProductFileDTO fileDTO : fileList) {
			fileManager.deleteFile("/resources/upload/products", fileDTO.getName());
		}
		return productDAO.delete(productDTO);
	}

	public int addFile(ProductFileDTO productFileDTO, MultipartFile file) throws Exception {
		String fileName = fileManager.saveFile("/resources/upload/products", file);
		String originName = file.getOriginalFilename();
		
		productFileDTO.setName(fileName);
		productFileDTO.setOrigin_nm(originName);
		
		int result = productDAO.addFile(productFileDTO);

		return result;
	}
	
	public int addThumbnail(ProductDTO productDTO, MultipartFile file) throws Exception {
		ProductFileDTO productFileDTO = new ProductFileDTO();
		String fileName = fileManager.saveFile("/resources/upload/products", file);
		String originName = file.getOriginalFilename();
		
		productFileDTO.setProduct_id(productDTO.getId());
		productFileDTO.setName(fileName);
		productFileDTO.setOrigin_nm(originName);
		
		int result = productDAO.addThumbnail(productFileDTO);
		
		return result;
	}
	
	
	public boolean deleteFile(ProductFileDTO productFileDTO) throws Exception {
		boolean result = fileManager.deleteFile("/resources/upload/products", productFileDTO.getName());
		if(result) productDAO.deleteFile(productFileDTO);
		return result;
	}
	
	public boolean deleteThumbnail(ProductFileDTO productFileDTO) throws Exception {
		boolean result = fileManager.deleteFile("/resources/upload/products", productFileDTO.getName());
		if(result) productDAO.deleteThumbnail(productFileDTO);
		return result;
	}


}
