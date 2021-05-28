package com.edgc.board.model.entity;

import com.edgc.common.base.model.entity.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * FILE table entity입니다.
 * 
 * @author MINHYEOK.KIM
 *
 */

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class FileEntity extends BaseEntity{
	private Long idx;
	private Long boardIdx;
	private String filePath;
	private String orgFileNm;
	private String saveFileNm;
	private Long fileSize;
}
