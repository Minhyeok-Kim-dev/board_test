package com.edgc.common.base.model.dto;

import com.edgc.common.base.model.entity.BaseEntity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@ToString
@SuperBuilder
public class BaseDto<E extends BaseEntity> {
	private E entity;
}
