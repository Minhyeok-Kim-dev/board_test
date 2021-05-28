package com.edgc.common.util;

import java.io.File;
import java.io.FileInputStream;
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

/**
 * 파일 처리 관련 util class입니다.
 * 
 * @author MINHYEOK.KIM
 */
@Component
public class FileUtil {
	public static String FILE_PATH = "";
	
	@Value("${file.path}")
	public void setFilePath(String fileDir) {
		FILE_PATH = fileDir;
	}
	
	
	/**
	 * file upload를 처리합니다.
	 * 
	 * @param filePath 		파일이 저장되는 물리 directory 경로
	 * @param prefix		저장할 파일명의 접두어
	 * @param file			저장할 파일
	 * @throws IOException
	 */
	public static void fileUpload(String filePath, String prefix, MultipartFile file) throws IOException {
		String fileName = file.getOriginalFilename();
		String absolutePath = filePath + File.separator + prefix + "_" + fileName;
		
		try (FileOutputStream fos = new FileOutputStream(absolutePath)){
			byte[] fileData = file.getBytes();
			fos.write(fileData);
		} catch (IOException e) {
			throw e;
		} 
	}
	
	
	/**
	 * file upload를 처리합니다.
	 * - 파일이 저장되는 물리 directory 경로는 file.properties에 저장된 경로로 설정합니다.
	 * 
	 * @param prefix		저장할 파일명의 접두어
	 * @param file			저장할 파일
	 * @throws IOException	
	 */
	public static void fileUpload(String prefix, MultipartFile file) throws IOException {
		fileUpload(FILE_PATH, prefix, file);
	}
	
	
	/**
	 * file download를 처리합니다.
	 * 
	 * @param filePath		파일이 저장되는 물리 directory 경로
	 * @param orgFileNm		원본 파일명
	 * @param saveFileNm	저장된 파일명
	 * @return				file관련 header, body적용한 ResponseEntity
	 * @throws IOException
	 */
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
