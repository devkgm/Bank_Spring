package com.devkgm.app.util;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	public String fileSave(String path, MultipartFile file) throws Exception {
		System.out.println("file save");
		File f = new File(path);
		
		if(f.isFile()) {
			throw new Exception();
			
		}
		
		if(!f.exists()) {
			f.mkdirs();
		}
		String originFileName = file.getOriginalFilename();
		String fileName = UUID.randomUUID().toString() + originFileName;
		
		f = new File(f, fileName);
		
//		FileCopyUtils.copy(file.getBytes(), f);
//		System.out.println(path);
		
		file.transferTo(f);
		return fileName;
	}
	
	public boolean fileDelete(String path,String fileName) throws Exception {
		System.out.println(path);
		System.out.println(fileName);
		File f = new File(path, fileName);

	
		return f.delete();
	}

}
