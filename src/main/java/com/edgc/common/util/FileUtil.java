package com.edgc.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUtil {
	public static String FILE_PATH = "";
	
	@Value("${file.path}")
	public void setFilePath(String fileDir) {
		FILE_PATH = fileDir;
	}
	
	public static void fileUpload(String fileDir, String prefix, MultipartFile file) throws IOException {
		String fileName = file.getOriginalFilename();
		String absolutePath = fileDir + File.separator + prefix + "_" + fileName;
		
		try (FileOutputStream fos = new FileOutputStream(absolutePath)){
			byte[] fileData = file.getBytes();
			fos.write(fileData);
		} catch (IOException e) {
			throw e;
		} 
	}
	
	public static void fileUpload(String prefix, MultipartFile file) throws IOException {
		fileUpload(FILE_PATH, prefix, file);
	}
	
	public static ResponseEntity<InputStreamResource> fileDownload(String filePath, String orgFileNm, String saveFileNm) throws IOException {
		File file = new File(filePath + File.separator + saveFileNm);
		
		// file명 encode (UTF-8)
		orgFileNm = URLEncoder.encode(orgFileNm, "UTF-8").replace("+", "%20");
		
		if(file.exists()) {
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attatchment; filename=" + orgFileNm);
			headers.add(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
			headers.add(HttpHeaders.PRAGMA, "no-cache");
			headers.add(HttpHeaders.EXPIRES, "0");
			
			try (FileInputStream fis = new FileInputStream(file)){
				InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

				return ResponseEntity.ok() 
						.headers(headers) 
						.contentLength(file.length()) 
						.contentType(MediaType.parseMediaType("application/octet-stream; charset=UTF-8")) 
						.body(resource);
			} catch (IOException e) {
				throw e;
			} 
		}
		
		return ResponseEntity.ok().build();
	}
}
