package com.edgc.board.model.network.response;

import java.util.ArrayList;

import com.edgc.board.model.entity.FileEntity;
import com.edgc.common.base.model.network.response.BaseApiResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 파일 관련 ApiResponse class입니다.
 * 
 * @author MINHYEOK.KIM
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@SuperBuilder
public class FileApiResponse extends BaseApiResponse {
	private ArrayList<FileEntity> fileList;
}
