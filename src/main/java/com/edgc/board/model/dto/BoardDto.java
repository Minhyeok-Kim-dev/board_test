package com.edgc.board.model.dto;

import java.util.ArrayList;

import com.edgc.board.model.entity.BoardEntity;
import com.edgc.board.model.network.parameter.Paging;
import com.edgc.board.model.network.parameter.Search;
import com.edgc.board.model.network.parameter.Sort;
import com.edgc.common.base.model.dto.BaseDto;
import com.edgc.login.model.entity.UserInfoEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter 
@Setter 
@NoArgsConstructor 
@SuperBuilder 
@ToString(callSuper = true)
public class BoardDto extends BaseDto<BoardEntity> {
	private Search search;
	private Paging paging;
	private ArrayList<Sort> sort;
	private UserInfoEntity userInfo;
}
