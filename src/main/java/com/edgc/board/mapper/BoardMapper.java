package com.edgc.board.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.edgc.board.model.entity.Board;

@Mapper
public interface BoardMapper {
	int insertBoard(Board test);
	
	ArrayList<Board> selectBoardList();
}
