package com.edgc.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgc.common.base.model.network.Header;
import com.edgc.common.base.service.BaseApiService;
import com.edgc.common.util.SessionUtil;
import com.edgc.login.mapper.LoginMapper;
import com.edgc.login.model.entity.UserInfoEntity;
import com.edgc.login.model.network.request.LoginApiRequest;
import com.edgc.login.model.network.response.LoginApiResponse;

@Service
public class LoginApiService extends BaseApiService<LoginApiRequest, LoginApiResponse> {
	@Autowired
	LoginMapper loginMapper;
	
	@Override
	public Header<LoginApiResponse> readList(Header<LoginApiRequest> request) {
		LoginApiRequest body = request.getData();
		
		UserInfoEntity userInfo = body.getUserInfo();
		
		if(userInfo == null) {
			return Header.Error();
		}
		
		// 사용자 검색
		userInfo = loginMapper.selectUserInfo(userInfo);
		System.out.println(userInfo);
		
		// session 등록
		try {
			if(userInfo != null) {
				SessionUtil.setAttribute("userInfo", userInfo);
				return Header.OK();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Header.Error();
	}
}
