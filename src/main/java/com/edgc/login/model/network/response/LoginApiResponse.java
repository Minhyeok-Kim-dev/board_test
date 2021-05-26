package com.edgc.login.model.network.response;

import com.edgc.common.base.model.network.response.BaseApiResponse;
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
public class LoginApiResponse extends BaseApiResponse {
	UserInfo userInfo;
}
