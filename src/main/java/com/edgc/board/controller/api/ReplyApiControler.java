package com.edgc.board.controller.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edgc.board.model.network.request.BoardApiRequest;
import com.edgc.board.model.network.response.BoardApiResponse;
import com.edgc.board.service.ReplyApiService;
import com.edgc.common.base.controller.BaseApiController;
import com.edgc.common.base.model.network.Header;
import com.edgc.common.util.SessionUtil;
import com.edgc.login.model.entity.UserInfo;

@RestController
@RequestMapping("/api/reply")
public class ReplyApiControler extends BaseApiController<ReplyApiService, BoardApiRequest, BoardApiResponse>{
	
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
		
		return this.service.create(request);
	}

	@Override
	public Header<BoardApiResponse> read(Header<BoardApiRequest> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header<BoardApiResponse> read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header<BoardApiResponse> update(Header<BoardApiRequest> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header<BoardApiResponse> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
