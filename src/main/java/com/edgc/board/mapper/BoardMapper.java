package com.edgc.board.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.edgc.board.model.dto.BoardDto;
import com.edgc.board.model.dto.BoardForm;
import com.edgc.board.model.dto.ReplyForm;
import com.edgc.board.model.entity.Board;
import com.edgc.common.base.mapper.BaseMapper;

@Mapper
public interface BoardMapper extends BaseMapper<Board> {
	int selectBoardListCnt(BoardDto boardDto);
	
	ArrayList<BoardForm> selectBoardFormList(BoardDto boardDto);
	
	BoardForm selectBoardFormByIdx(BoardDto boardDto);
	
	ArrayList<ReplyForm> selectReplyFormListByBoardIdx(BoardDto boardDto);
}
