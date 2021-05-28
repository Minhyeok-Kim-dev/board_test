package com.edgc.login.model.network.request;

import com.edgc.common.base.model.network.request.BaseApiRequest;
import com.edgc.login.model.entity.UserInfoEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@SuperBuilder
public class LoginApiRequest extends BaseApiRequest {
	UserInfoEntity userInfo;
}
