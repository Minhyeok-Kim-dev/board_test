package com.edgc.common.base.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@ToString
@SuperBuilder
public class BaseEntity {
	private String regdt;
	private String regid;
	private String updt;
	private String upid;
}
