package com.edgc.board.model.network.response;

import java.util.ArrayList;

import com.edgc.board.model.dto.BoardForm;
import com.edgc.board.model.entity.BoardEntity;
import com.edgc.board.model.network.parameter.Paging;
import com.edgc.common.base.model.network.response.BaseApiResponse;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 게시판 관련 ApiResponse class입니다.
 * 
 * @author MINHYEOK.KIM
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoardApiResponse extends BaseApiResponse {
	private Paging paging;
	private BoardEntity board;
	private BoardForm boardForm;
	private ArrayList<BoardForm> boardFormList;
}
