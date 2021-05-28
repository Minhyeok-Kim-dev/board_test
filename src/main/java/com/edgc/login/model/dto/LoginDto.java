package com.edgc.login.model.dto;

import com.edgc.common.base.model.dto.BaseDto;
import com.edgc.login.model.entity.UserInfoEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString
public class LoginDto extends BaseDto<UserInfoEntity> {
	
}
