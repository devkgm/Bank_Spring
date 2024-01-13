package com.devkgm.app.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	@Autowired
	private ServletContext servletContext;
	
	public String saveFile(String path, MultipartFile file) throws Exception {
		path = servletContext.getRealPath(path);
		File f = new File(path);
		
		if(f.isFile()) {
			throw new Exception();
		}
		
		if(!f.exists()) {
			f.mkdirs();
		}
		String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
	
		f = new File(f, fileName);
		
		file.transferTo(f);
		System.out.println(path+"/"+fileName);
		return fileName;
	}
	
	public boolean deleteFile(String path, String fileName) throws Exception {
		path = servletContext.getRealPath(path);
		File f = new File(path,fileName);
		
//		if(!f.isFile()) {
//			throw new Exception();
//		}
		System.out.println(path+"/"+fileName);
		System.out.println("delete");
		return f.delete();
	}
}
