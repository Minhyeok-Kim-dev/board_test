package com.edgc.common.base.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.edgc.common.base.model.dto.BaseDto;
import com.edgc.common.base.model.entity.BaseEntity;

@Mapper
public interface BaseMapper<E extends BaseEntity> {	
	int insertEntity(E entity);
	
	int updateEntity(E entity);
	
	int deleteEntity(E entity);
}
