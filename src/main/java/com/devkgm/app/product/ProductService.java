package com.devkgm.app.product;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.devkgm.app.util.Pager;



@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	public List<ProductDTO> getList(Pager pager) throws Exception {
		Long totalPage = this.productDAO.getTotalPage(pager);
		pager.setTotalPage(totalPage);
		pager.calc();
		return this.productDAO.getList(pager);
	}
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception{
		return this.productDAO.getDetail(productDTO);
	}
	public int add(ProductDTO productDTO, MultipartFile file) throws Exception {
		this.productDAO.add(productDTO);
		
		if(file != null) {
			String path = servletContext.getRealPath("/resources/upload") ;
			System.out.println(path);
			File f = new File(path, "products");
			
			if(!f.exists()) {
				f.mkdirs();
			}
			
			String fileName = UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
			f = new File(f, fileName);
			FileCopyUtils.copy(file.getBytes(), f);
			ProductFileDTO productFileDTO = new ProductFileDTO();
			productFileDTO.setProduct_id(productDTO.getId());
			productFileDTO.setName(fileName);
			productFileDTO.setOrigin_nm(file.getOriginalFilename());
			this.productDAO.addFile(productFileDTO);
			this.productDAO.addProductFile(productFileDTO);
		}
		
		
		
		return 0;
//		return this.productDAO.add(productDTO);
	}
	public int update(ProductDTO productDTO) throws Exception {
		return this.productDAO.update(productDTO);
	}
	public int delete(ProductDTO productDTO) throws Exception{
		return this.productDAO.delete(productDTO);
	}
	
}
