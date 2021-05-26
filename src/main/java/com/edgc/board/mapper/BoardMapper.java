package com.edgc.board.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.edgc.board.model.dto.BoardDto;
import com.edgc.board.model.dto.BoardForm;
import com.edgc.board.model.entity.Board;
import com.edgc.board.model.network.parameter.Search;
import com.edgc.board.model.network.request.BoardApiRequest;
import com.edgc.common.base.mapper.BaseMapper;

@Mapper
public interface BoardMapper{
	int insertBoard(BoardDto boardDto);
	
	int selectBoardListCnt(BoardDto boardDto);
	ArrayList<BoardForm> selectBoardList(BoardDto boardDto);
	BoardForm selectBoard(BoardDto boardDto);
	int updateBoard(BoardDto boardDto);
	int deleteBoard(BoardDto boardDto);
}
