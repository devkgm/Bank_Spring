package com.devkgm.app.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.devkgm.app.board.product.ProductDTO;

public interface BoardService<T> {
	
	public List<T> getList(BoardPager boardPager)throws Exception;
	
	public T getDetail(T t) throws Exception;
	
	public int add(T t) throws Exception;
	
	public int update(T t, MultipartFile[] file) throws Exception;
	
	public int delete(T t) throws Exception;
	
	public Long getTotalPage() throws Exception;
}
