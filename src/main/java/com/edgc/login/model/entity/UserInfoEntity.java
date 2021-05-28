package com.edgc.login.model.entity;

import com.edgc.common.base.model.entity.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * USER_INFO table entity입니다.
 * 
 * @author MINHYEOK.KIM
 */

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class UserInfoEntity extends BaseEntity {
	private String edgcid;
	private String passwd;
	private String edgctype;
	private String usernm;
	private String company;
}
