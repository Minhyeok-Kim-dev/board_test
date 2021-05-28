package com.edgc.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 게시판 관련 View Controller입니다.
 * 
 * @author MINHYEOK.KIM
 */

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	@GetMapping(value = {"/", ""})
	public String index() {
		return "board/index";
	}
	
	@GetMapping(value = "writeForm")
	public String writeForm() {
		return "board/contents/write_form";
	}
	
	@GetMapping(value = "listForm")
	public String listForm() {
		return "board/contents/list_form";
	}
	
	@GetMapping(value = "detailForm")
	public String detailForm() {
		return "board/contents/detail_form";
	}
	
	
}
