package com.edgc.login.model.dto;

import com.edgc.common.base.model.dto.BaseDto;
import com.edgc.login.model.entity.UserInfo;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class LoginDto extends BaseDto<UserInfo> {
	
}
