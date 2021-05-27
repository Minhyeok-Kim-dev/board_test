package com.edgc.common.base.mapper;

import java.util.List;

import com.edgc.common.base.model.entity.BaseEntity;

public interface BaseMapper<E extends BaseEntity> {	
	int insertEntity(E entity);
	int insertEntityList(List<E> entityList);
	
	int updateEntity(E entity);
	
	int deleteEntity(E entity);
	
	E selectEntity(E entity);
}
