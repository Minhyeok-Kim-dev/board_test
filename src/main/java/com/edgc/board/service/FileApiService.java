package com.edgc.board.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.edgc.board.mapper.FileMapper;
import com.edgc.board.model.entity.FileEntity;
import com.edgc.board.model.network.request.FileApiRequest;
import com.edgc.board.model.network.response.FileApiResponse;
import com.edgc.common.base.model.network.Header;
import com.edgc.common.base.service.BaseApiService;
import com.edgc.common.util.DateUtil;
import com.edgc.common.util.FileUtil;

@Service
public class FileApiService extends BaseApiService<FileApiRequest, FileApiResponse> {
	@Autowired
	FileMapper fileMapper;
	
	public Header<FileApiResponse> upload(MultipartHttpServletRequest request) {
		List<MultipartFile> fileList = request.getFiles("file");
		
		ArrayList<FileEntity> fileEntityList = new ArrayList<FileEntity>();
		
		String prefix = DateUtil.now("yyyyMMddHHmmssSSS");
		
		for(MultipartFile file : fileList) {
			String orgFileNm = file.getOriginalFilename();
			Long fileSize = file.getSize();
			
			// response 내용 생성
			fileEntityList.add(
					FileEntity.builder()
						.filePath(FileUtil.FILE_PATH)
						.orgFileNm(orgFileNm)
						.saveFileNm(prefix + "_" + orgFileNm)
						.fileSize(fileSize)
						.build());
			
			try {
				// file upload
				FileUtil.fileUpload(prefix, file);
			} catch (IOException e) {
				e.printStackTrace();
				
				return Header.Error();
			}
		}
		
		return response(fileEntityList);
	}
	
	public ResponseEntity<InputStreamResource> download(Long idx) {
		FileEntity file = FileEntity.builder()
				.idx(idx)
				.build();
		
		file = fileMapper.selectFileByIdx(file);
		
		ResponseEntity<InputStreamResource> responseEntity = null;
		try {
			// file download
			responseEntity = FileUtil.fileDownload(
					file.getFilePath(), file.getOrgFileNm(), file.getSaveFileNm());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return responseEntity;
	}
	
	
	public Header<FileApiResponse> response(ArrayList<FileEntity> fileEntityList) {
		FileApiResponse body = FileApiResponse.builder()
				.fileList(fileEntityList)
				.build();
		
		return Header.OK(body);
	}
}
