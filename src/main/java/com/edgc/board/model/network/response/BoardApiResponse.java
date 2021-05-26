package com.edgc.board.model.network.response;

import java.util.ArrayList;

import com.edgc.board.model.dto.BoardForm;
import com.edgc.board.model.entity.Board;
import com.edgc.board.model.network.parameter.Paging;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoardApiResponse {
	private Paging paging;
	private Board board;
	private BoardForm boardForm;
	private ArrayList<BoardForm> boardFormList;
}
