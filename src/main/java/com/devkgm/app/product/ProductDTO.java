package com.devkgm.app.product;

public class ProductDTO {
	private Long id;
	private String name;
	private String description;
	private Double rate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		if(this.name==null) return "";
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		if(this.description==null) return "";
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getRate() {
		if(this.rate == null) return 0.0;
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", description=" + description + ", rate=" + rate + "]";
	}
	
}
