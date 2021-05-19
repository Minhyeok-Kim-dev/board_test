package com.edgc.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edgc.board.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		boardService.selectTestList();
		
		return "board/index";
	}
	
}
