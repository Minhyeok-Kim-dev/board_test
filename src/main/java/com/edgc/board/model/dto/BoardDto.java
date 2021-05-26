package com.edgc.board.model.dto;

import java.util.ArrayList;

import com.edgc.board.model.entity.Board;
import com.edgc.board.model.network.parameter.Paging;
import com.edgc.board.model.network.parameter.Search;
import com.edgc.board.model.network.parameter.Sort;
import com.edgc.common.base.model.dto.BaseDto;
import com.edgc.login.model.entity.UserInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class BoardDto extends BaseDto<Board> {
	private Search search;
	private Paging paging;
	private ArrayList<Sort> sort;
	private UserInfo userInfo;
}
