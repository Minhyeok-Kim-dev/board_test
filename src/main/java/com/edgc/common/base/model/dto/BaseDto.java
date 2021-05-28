package com.edgc.common.base.model.dto;

import com.edgc.common.base.model.entity.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * DTO(Data Transfer Object) class 구현에 사용됩니다.
 * - DTO class 생성시 해당 class를 상속받아 구현합니다.
 * - 구현 시 BaseEntity class type을 포함 시킬 수 있으며, entity field로 참조 가능합니다. (this.entity)
 * 
 * 
 * Package 구성
 * - domain package > model > dto 
 * 
 * 권장 Lombok annotation
 * - @Getter @Setter @NoArgsConstructor @SuperBuilder @ToString(callSuper = true)
 *
 *
 * @author MINHYEOK.KIM
 *
 * @param <E> Entity : DTO에 포함될 entity class type
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@SuperBuilder
public class BaseDto<E extends BaseEntity> {
	protected E entity;
}
