package com.edgc.common.base.mapper;

import java.util.List;

import com.edgc.common.base.model.entity.BaseEntity;

/**
 * Mapper base interface입니다.
 * - Mapper interface 구현시 해당 interface를 상속받아 구현합니다.
 * 
 * 
 * Package 구성
 * - domain package > mapper
 *    
 *    
 * @author MINHYEOK.KIM
 * 
 * @param <E> Entity : Mapper에 사용 될 entity class type
 */
public interface BaseMapper<E extends BaseEntity> {	
	int insertEntity(E entity);
	int insertEntityList(List<E> entityList);
	
	int updateEntity(E entity);
	
	int deleteEntity(E entity);
	
	E selectEntity(E entity);
}
