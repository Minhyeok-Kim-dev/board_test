package com.edgc.board.controller.api;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.edgc.board.model.network.request.FileApiRequest;
import com.edgc.board.model.network.response.FileApiResponse;
import com.edgc.board.service.FileApiService;
import com.edgc.common.base.controller.BaseApiController;
import com.edgc.common.base.model.network.Header;

/**
 * file 처리 관련 RestAPI Controller입니다.
 * 
 * @author MINHYEOK.KIM
 */

@RestController
@RequestMapping(value="/api/file")
public class FileApiContoller extends BaseApiController
		<FileApiService, FileApiRequest, FileApiResponse> {
	
	@PostMapping("upload")
	public Header<FileApiResponse> upload(MultipartHttpServletRequest request) {
		return service.upload(request);
	}

	
	@GetMapping("download/{idx}")	// 현재 저장된 file명으로 검색토록 설정
	public ResponseEntity<InputStreamResource> download(@PathVariable Long idx) {
		return service.download(idx);
	}
}
