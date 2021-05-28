package com.edgc.login.mapper;

import com.edgc.common.base.mapper.BaseMapper;
import com.edgc.login.model.entity.UserInfoEntity;

public interface LoginMapper extends BaseMapper<UserInfoEntity> {
	UserInfoEntity selectUserInfo(UserInfoEntity userInfo);
}
