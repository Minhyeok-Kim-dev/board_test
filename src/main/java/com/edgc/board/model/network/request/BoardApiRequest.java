package com.edgc.board.model.network.request;

import java.util.ArrayList;

import com.edgc.board.model.entity.BoardEntity;
import com.edgc.board.model.entity.FileEntity;
import com.edgc.board.model.network.parameter.Paging;
import com.edgc.board.model.network.parameter.Search;
import com.edgc.board.model.network.parameter.Sort;
import com.edgc.common.base.model.network.request.BaseApiRequest;
import com.edgc.login.model.entity.UserInfoEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 게시판 관련 ApiRequest class입니다.
 * 
 * @author MINHYEOK.KIM
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoardApiRequest extends BaseApiRequest {
	private Search search;
	private Paging paging;
	private ArrayList<Sort> sort;
	private BoardEntity board;
	private UserInfoEntity userInfo;
	
	private ArrayList<FileEntity> fileList;
}
