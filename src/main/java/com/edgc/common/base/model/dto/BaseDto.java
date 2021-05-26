package com.edgc.common.base.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
public class BaseDto<E> {
	private E entity;
}
