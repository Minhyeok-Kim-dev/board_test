package com.edgc.login.mapper;

import com.edgc.common.base.mapper.BaseMapper;
import com.edgc.login.model.entity.UserInfo;

public interface LoginMapper extends BaseMapper<UserInfo> {
	UserInfo selectUserInfo(UserInfo userInfo);
}
