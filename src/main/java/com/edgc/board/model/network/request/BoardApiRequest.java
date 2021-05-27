package com.edgc.board.model.network.request;

import java.util.ArrayList;

import com.edgc.board.model.entity.BoardEntity;
import com.edgc.board.model.entity.FileEntity;
import com.edgc.board.model.network.parameter.Paging;
import com.edgc.board.model.network.parameter.Search;
import com.edgc.board.model.network.parameter.Sort;
import com.edgc.common.base.model.network.request.BaseApiRequest;
import com.edgc.login.model.entity.UserInfo;

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
public class BoardApiRequest extends BaseApiRequest {
	private Search search;
	private Paging paging;
	private ArrayList<Sort> sort;
	private BoardEntity board;
	private UserInfo userInfo;
	
	private ArrayList<FileEntity> fileList;
}
