package com.edgc.board.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edgc.board.model.network.request.BoardApiRequest;
import com.edgc.board.model.network.response.BoardApiResponse;
import com.edgc.board.service.BoardApiService;
import com.edgc.common.base.model.network.Header;
import com.edgc.common.ifs.CrudInterface;
import com.edgc.common.util.SessionUtil;
import com.edgc.login.model.entity.UserInfo;

@RestController
@RequestMapping("/api/board")
public class BoardApiController implements CrudInterface<BoardApiRequest, BoardApiResponse> {
	@Autowired
	BoardApiService boardApiService;
	
	@Override
	@PostMapping("")
	public Header<BoardApiResponse> create(@RequestBody Header<BoardApiRequest> request) {
		System.out.println("############# create");
		System.out.println(request);
		
		// 세션에서 사용자 정보 가져옴 - TODO: AOP 적용 -> Controller에서?
		UserInfo userInfo = null;
		try {
			userInfo = (UserInfo) SessionUtil.getAttribute("userInfo");
			if(userInfo == null) {
				return Header.Error();
			}
			
			request.getData().setUserInfo(userInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return boardApiService.create(request);
	}

	@Override
	@PostMapping("list")
	public Header<BoardApiResponse> read(@RequestBody Header<BoardApiRequest> request) {
		System.out.println("############# read");
		System.out.println(request);
		
		return boardApiService.read(request);
	}

	@Override
	@GetMapping("{idx}")
	public Header<BoardApiResponse> read(@PathVariable(name = "idx") Long idx) {
		System.out.println("############# read by idx : " + idx);
		return boardApiService.read(idx);
	}

	@Override
	@PutMapping
	public Header<BoardApiResponse> update(@RequestBody Header<BoardApiRequest> request) {
		System.out.println("############# update");
		System.out.println(request);
		return boardApiService.update(request);
	}

	@Override
	@DeleteMapping("{idx}")
	public Header<BoardApiResponse> delete(@PathVariable(name = "idx") Long idx) {
		System.out.println("############# delete by idx : " + idx);
		System.out.println(idx);
		
		return boardApiService.delete(idx);
	}
}
