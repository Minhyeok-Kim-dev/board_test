package com.edgc.login.model.entity;

import com.edgc.common.base.model.entity.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@SuperBuilder
public class UserInfo extends BaseEntity {
	private String edgcid;
	private String passwd;
	private String edgctype;
	private String usernm;
	private String company;
}
