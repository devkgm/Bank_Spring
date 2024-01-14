package com.devkgm.app.board.product;

import java.util.List;

import com.devkgm.app.board.BoardDTO;

public class ProductDTO extends BoardDTO<ProductFileDTO>{
	private String name;
	private Long is_sale;
	private Double rate;
	private Long counts;
	private Long is_temp;
	private List<String> thumbnails;
	
	
	

	public List<String> getThumbnails() {
		return thumbnails;
	}
	public void setThumbnails(List<String> thumbnails) {
		this.thumbnails = thumbnails;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getIs_sale() {
		return is_sale;
	}
	public void setIs_sale(Long is_sale) {
		this.is_sale = is_sale;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public Long getCounts() {
		return counts;
	}
	public void setCounts(Long counts) {
		this.counts = counts;
	}
	public Long getIs_temp() {
		return is_temp;
	}
	public void setIs_temp(Long is_temp) {
		this.is_temp = is_temp;
	}
	
}
