package com.edgc.login.mapper;

import com.edgc.login.model.entity.UserInfo;

public interface LoginMapper {
	UserInfo selectUserInfo(UserInfo userInfo);
}
