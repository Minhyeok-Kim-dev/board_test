package com.edgc.board.model.network.response;

import java.util.ArrayList;

import com.edgc.board.model.dto.BoardForm;
import com.edgc.board.model.entity.BoardEntity;
import com.edgc.board.model.network.parameter.Paging;
import com.edgc.common.base.model.network.response.BaseApiResponse;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoardApiResponse extends BaseApiResponse {
	private Paging paging;
	private BoardEntity board;
	private BoardForm boardForm;
	private ArrayList<BoardForm> boardFormList;
}
