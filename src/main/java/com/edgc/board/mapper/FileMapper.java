package com.edgc.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.edgc.board.model.entity.FileEntity;
import com.edgc.common.base.mapper.BaseMapper;

@Mapper
public interface FileMapper extends BaseMapper<FileEntity> {
	FileEntity selectFileByIdx(FileEntity fileEntity);
}
