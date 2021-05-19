package com.edgc.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgc.login.mapper.LoginMapper;
import com.edgc.login.model.LoginForm;
import com.edgc.login.model.entity.UserInfo;
import com.edgc.util.SessionUtil;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	LoginMapper loginMapper;
	
	@Override
	public String login(LoginForm loginForm) {
		System.out.println("######### login : " + loginForm);
		
		UserInfo userInfo = UserInfo.builder()
				.userid(loginForm.getUserid())
				.passwd(loginForm.getPasswd())
				.build();
		
		// 사용자 검색
		userInfo = loginMapper.selectUserInfo(userInfo);
		System.out.println(userInfo);
		
		if(userInfo == null) {
			return "redirect:/";
		}
		
		// session 등록
		try {
			SessionUtil.setAttribute("userInfo", userInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:board";
	}

}
