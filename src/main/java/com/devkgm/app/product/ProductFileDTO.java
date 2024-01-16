package com.devkgm.app.product;

import com.devkgm.app.files.FileDTO;

public class ProductFileDTO extends FileDTO{
	private Long id;
	private Long product_id;
	private Long file_id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public Long getFile_id() {
		return file_id;
	}
	public void setFile_id(Long file_id) {
		this.file_id = file_id;
	}
	
	
}
