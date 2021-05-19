package com.edgc.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edgc.board.service.BoardService;
import com.edgc.login.model.entity.UserInfo;
import com.edgc.util.SessionUtil;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@GetMapping(value = {"/", ""})
	public String index() {
		UserInfo userInfo = null;
		try {
			userInfo = (UserInfo) SessionUtil.getAttribute("userInfo");
			if(userInfo == null) {
				return "login/index";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("########### board : " + userInfo);
		
		boardService.selectTestList();
		
		return "board/index";
	}
	
}
