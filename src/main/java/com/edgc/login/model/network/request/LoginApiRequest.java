package com.edgc.login.model.network.request;

import com.edgc.common.base.model.network.request.BaseApiRequest;
import com.edgc.login.model.entity.UserInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginApiRequest extends BaseApiRequest {
	UserInfo userInfo;
}
