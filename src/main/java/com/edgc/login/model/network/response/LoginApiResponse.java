package com.edgc.login.model.network.response;

import com.edgc.common.base.model.network.response.BaseApiResponse;
import com.edgc.login.model.entity.UserInfoEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class LoginApiResponse extends BaseApiResponse {
	UserInfoEntity userInfo;
}
