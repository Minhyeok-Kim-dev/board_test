package com.edgc.board.model.entity;

import com.edgc.common.base.model.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)

@NoArgsConstructor
@AllArgsConstructor
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
