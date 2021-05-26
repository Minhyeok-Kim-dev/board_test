package com.edgc.login.controller.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edgc.common.base.controller.BaseApiController;
import com.edgc.common.base.model.network.Header;
import com.edgc.common.util.SessionUtil;
import com.edgc.login.model.network.request.LoginApiRequest;
import com.edgc.login.model.network.response.LoginApiResponse;
import com.edgc.login.service.LoginApiService;

@RestController
@RequestMapping("/api/login")
public class LoginApiController extends BaseApiController
		<LoginApiService, LoginApiRequest, LoginApiResponse> {
	
	@Override
	@PostMapping("")
	public Header<LoginApiResponse> read(@RequestBody Header<LoginApiRequest> request) {
		System.out.println("### login");
		return this.service.read(request);
	}
	
	@PostMapping("logout")
	public Header<LoginApiResponse> logout() {
		System.out.println("### logout");
		try {
			SessionUtil.removeAttribute("userInfo");
			return Header.OK();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Header.Error();
	}
}
