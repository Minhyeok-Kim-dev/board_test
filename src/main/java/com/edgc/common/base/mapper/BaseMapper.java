package com.edgc.common.base.mapper;

import com.edgc.common.base.model.entity.BaseEntity;

public interface BaseMapper<E extends BaseEntity> {	
	int insertEntity(E entity);
	
	int updateEntity(E entity);
	
	int deleteEntity(E entity);
	
	E selectEntity(E entity);
}
