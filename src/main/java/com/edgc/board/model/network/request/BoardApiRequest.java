package com.edgc.board.model.network.request;

import java.util.ArrayList;

import com.edgc.board.model.entity.Board;
import com.edgc.board.model.network.parameter.Paging;
import com.edgc.board.model.network.parameter.Search;
import com.edgc.board.model.network.parameter.Sort;
import com.edgc.login.model.entity.UserInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BoardApiRequest {
	private Search search;
	private Paging paging;
	private ArrayList<Sort> sort;
	private Board board;
	private UserInfo userInfo;
}
