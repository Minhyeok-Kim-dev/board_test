package com.edgc.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgc.board.mapper.BoardMapper;
import com.edgc.board.model.entity.Board;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardMapper boardMapper;
	
	
	@Override
	public List<Board> selectTestList() {
		/*
		ArrayList<Board> testList = boardMapper.selectBoardList();
		
 		for(Board t : testList) {
			System.out.println(t);
		}
		*/
		return null;
	}

}
